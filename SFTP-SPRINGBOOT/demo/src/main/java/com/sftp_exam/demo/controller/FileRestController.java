package com.sftp_exam.demo.controller;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.sftp_exam.demo.config.SftpConnector;
import com.sftp_exam.demo.upload.UploadFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;

@RestController
@Slf4j
@RequiredArgsConstructor
public class FileRestController {

    private final UploadFile uploadFile;

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file")MultipartFile file) throws JSchException, SftpException, IOException {
        log.info(file.getOriginalFilename());

        uploadFile.upload(file,"/profile/");

        return file.getOriginalFilename();
    }
}
