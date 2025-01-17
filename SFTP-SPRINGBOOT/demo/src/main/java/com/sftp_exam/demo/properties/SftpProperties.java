package com.sftp_exam.demo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sftp")
@Getter
@Setter
public class SftpProperties {

    private String host;
    private int port;
    private String user;
    private String password;
}
