package com.file.sftpuse;

import java.io.File;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;


public class Main {

    private static final String SESSION_CONFIG_STRICT_HOST_KEY_CHECKING = "StrictHostKeyChecking";

    // @Value("${ssh.remote_jump_host}")
    // private static String host;

    // private static String private_key;

    // private static String user;
    
    // private static String ssh_port;


    // public Main(
    //     @Value("${ssh.remote_jump_host}") String host,
    //     @Value("${ssh.private_key}") String private_key,
    //     @Value("${ssh.user}") String user,
    //     @Value("${ssh.ssh_port}") String ssh_port) {

    //         this.host = host;
    //         this.private_key = private_key;
    //         this.user = user;
    //         this.ssh_port = ssh_port;
    //     }

    
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
            sftp.cd("/home/test/");
            sftp.put( "c:\\Users\\SIUK\\GIT_REPO\\PLAYGROUND\\JAVA\\board\\sftpuse\\README.md","black.md");
                
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getCause());
        }

        sftp.disconnect();
        channel.disconnect();
        session.disconnect();
            

    }

    
}
