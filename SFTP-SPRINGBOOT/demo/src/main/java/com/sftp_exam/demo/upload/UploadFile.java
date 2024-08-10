package com.sftp_exam.demo.upload;


import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.sftp_exam.demo.config.SftpConnector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
@RequiredArgsConstructor
public class UploadFile {

    private final SftpConnector sftpConnector;



    @Async("taskExecutor")
    public void upload(MultipartFile file, String path) {
        ChannelSftp channelSftp = null;
        try {
            channelSftp = sftpConnector.getSftpChannel();
            if (!isPathAvailable(channelSftp, path)) {
                channelSftp.mkdir(path);
            }
            try (InputStream inputStream = file.getInputStream()) {
                channelSftp.cd(path);
                channelSftp.put(inputStream, file.getOriginalFilename());
            }
        } catch (JSchException | SftpException | IOException e) {
            log.error("Error uploading file: {}", file.getOriginalFilename(), e);
        } finally {
            if (channelSftp != null) {
                sftpConnector.disconnect();
            }
        }
    }

    public boolean isPathAvailable(ChannelSftp channelSftp,String path) {

        try{
            channelSftp.cd(path);
            return true;
        }
        catch (SftpException e){
            return false;
        }
    }

}
