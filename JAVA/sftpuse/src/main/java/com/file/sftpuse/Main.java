package com.file.sftpuse;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Main {

    private static final String SESSION_CONFIG_STRICT_HOST_KEY_CHECKING = "StrictHostKeyChecking";

    
    public static void main(String[] args) throws JSchException {
        String remote   = "127.0.0.1";
        int    ssh_port = 2222;
        String user     = "root";
        String private_key = "9315";


        JSch jSch = new JSch();
        Session session = jSch.getSession(user, remote, ssh_port);
        session.setConfig(SESSION_CONFIG_STRICT_HOST_KEY_CHECKING,"no");
        session.setPassword(private_key);
        session.connect(15000);


        Channel channel = session.openChannel("sftp");
		channel.connect(15000);

        ChannelSftp sftp = (ChannelSftp) channel;
        try {
            sftp.cd("/home/");
            sftp.put( "/Users/maxxing/Documents/github-repo/PLAY_GROUND/DOCKER/TOTALMD.md","black.md");
                
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }

        sftp.disconnect();
        channel.disconnect();
        session.disconnect();

    }
}
