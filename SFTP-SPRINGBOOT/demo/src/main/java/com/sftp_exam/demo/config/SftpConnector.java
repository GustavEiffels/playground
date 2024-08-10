package com.sftp_exam.demo.config;


import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.sftp_exam.demo.properties.SftpProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@RequiredArgsConstructor
@Slf4j
public class SftpConnector {

    private final SftpProperties sftpProperties;

    // ThreadLocal to hold SFTP connections per thread
    private final ThreadLocal<Session> sessionHolder = new ThreadLocal<>();
    private final ThreadLocal<ChannelSftp> channelHolder = new ThreadLocal<>();

    public ChannelSftp getSftpChannel() throws JSchException {
        Session session = sessionHolder.get();
        ChannelSftp channel = channelHolder.get();

        if (session == null || !session.isConnected() || channel == null || !channel.isConnected()) {
            JSch jSch = new JSch();
            session = jSch.getSession(sftpProperties.getUser(), sftpProperties.getHost(), sftpProperties.getPort());
            session.setPassword(sftpProperties.getPassword());

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect(15000);

            channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect(15000);

            sessionHolder.set(session);
            channelHolder.set(channel);
        }

        return channel;
    }

    public void disconnect() {
        ChannelSftp channel = channelHolder.get();
        Session session = sessionHolder.get();

        if (channel != null && channel.isConnected()) {
            channel.disconnect();
            channelHolder.remove();
            log.info("channel disconnecting");
        }

        if (session != null && session.isConnected()) {
            session.disconnect();
            sessionHolder.remove();
            log.info("session disconnecting");
        }
    }
}
