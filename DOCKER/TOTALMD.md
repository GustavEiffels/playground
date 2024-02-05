# Dockerer

# GIT ITGNORE 추가 

## 우분투 컨테이너에 sftp 설정하는 dockerfile 생성 
```Dockerfile
FROM ubuntu:20.04

RUN apt-get update \
    && apt-get install -y openssh-server \
    && mkdir /var/run/sshd \
    && echo 'root:9315' | chpasswd \
    && sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config \
    && sed -i 's/#PasswordAuthentication yes/PasswordAuthentication yes/' /etc/ssh/sshd_config \
    && sed -i 's/#X11Forwarding yes/X11Forwarding no/' /etc/ssh/sshd_config \
    && echo "AllowTcpForwarding yes" >> /etc/ssh/sshd_config

EXPOSE 22

CMD ["/usr/sbin/sshd", "-D"]
```

## BUILD 
```bash
docker build -t sftp-server .
```
  
## Cotainer 실행 
```bash
docker run -d -p 2222:22 --name sftp-container sftp-server
```  

## SFTP 접속
```bash
sftp -P 2222 root@localhost
```

## SFTP 접속 에러 - 참고 
https://kingsong.tistory.com/127
