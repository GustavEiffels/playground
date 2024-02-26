docker run -d --name my-mariadb -e MYSQL_ROOT_PASSWORD=ssw8039315 -p 33306:3306 mariadb

```
PS C:\Users\SIUK\GIT_REPO\PLAYGROUND> docker exec -it my-mariadb mysql -u root -p
OCI runtime exec failed: exec failed: unable to start container process: exec: "mysql": executable file not found in $PATH: unknown
```
> mysql 실행 파일을 찾을 수 없다. -> Mariadb 클라이언트가 컨테이너 내부에 설치 되어 있지 않다 


docker exec -it my-mariadb mariadb -uroot -p


docker run -d --name my-mariadb -e MYSQL_ROOT_PASSWORD=ssw8039315 -p 33306:3306 mariadb
Unable to find image 'mariadb:latest' locally
latest: Pulling from library/mariadb
a4a2c7a57ed8: Already exists 
cd9fa9deb29a: Pull complete 
d846006199d6: Pull complete 
34e3d3eb6f5f: Pull complete 
345b36a58287: Pull complete 
aa77992d6a9b: Pull complete 
9b1e408a68af: Pull complete 
fb648a814e37: Pull complete 
Digest: sha256:4762bcec7c5396fa672d1035498bda3506f29f253190ff4cb642bb7e99785977
Status: Downloaded newer image for mariadb:latest
6b5925ee2f3eb00ca5fb6373ec4f8e17a149bbfafabf736fc261ee564639c64f
 Xiuk  🍻   ~/Documents/GIT-HUB/OnlineLectureStudy   master ±
 docker exec -it my-mariadb -uroot -p
OCI runtime exec failed: exec failed: unable to start container process: exec: "-uroot": executable file not found in $PATH: unknown
 ✘ Xiuk  🍻   ~/Documents/GIT-HUB/OnlineLectureStudy   master ±
 docker exec -it my-mariadb -u root -p
OCI runtime exec failed: exec failed: unable to start container process: exec: "-u": executable file not found in $PATH: unknown



root@6b5925ee2f3e:/# apt-get update
Get:2 http://ports.ubuntu.com/ubuntu-ports jammy InRelease [270 kB]
Get:1 https://archive.mariadb.org/mariadb-11.3.2/repo/ubuntu jammy InRelease [7764 B]   
Get:3 https://archive.mariadb.org/mariadb-11.3.2/repo/ubuntu jammy/main arm64 Packages [15.8 kB]
Get:4 http://ports.ubuntu.com/ubuntu-ports jammy-updates InRelease [119 kB]
Get:5 https://archive.mariadb.org/mariadb-11.3.2/repo/ubuntu jammy/main/debug arm64 Packages [15.4 kB]
Get:6 http://ports.ubuntu.com/ubuntu-ports jammy-backports InRelease [109 kB]
Get:7 http://ports.ubuntu.com/ubuntu-ports jammy-security InRelease [110 kB]
Get:8 http://ports.ubuntu.com/ubuntu-ports jammy/main arm64 Packages [1758 kB]
Get:9 http://ports.ubuntu.com/ubuntu-ports jammy/restricted arm64 Packages [24.2 kB]
Get:10 http://ports.ubuntu.com/ubuntu-ports jammy/universe arm64 Packages [17.2 MB]
Get:11 http://ports.ubuntu.com/ubuntu-ports jammy/multiverse arm64 Packages [224 kB]                                                                                                                      
Get:12 http://ports.ubuntu.com/ubuntu-ports jammy-updates/restricted arm64 Packages [1302 kB]                                                                                                             
Get:13 http://ports.ubuntu.com/ubuntu-ports jammy-updates/multiverse arm64 Packages [28.4 kB]                                                                                                             
Get:14 http://ports.ubuntu.com/ubuntu-ports jammy-updates/universe arm64 Packages [1266 kB]                                                                                                               
Get:15 http://ports.ubuntu.com/ubuntu-ports jammy-updates/main arm64 Packages [1532 kB]                                                                                                                   
Get:16 http://ports.ubuntu.com/ubuntu-ports jammy-backports/main arm64 Packages [49.9 kB]                                                                                                                 
Get:17 http://ports.ubuntu.com/ubuntu-ports jammy-backports/universe arm64 Packages [26.2 kB]                                                                                                             
Get:18 http://ports.ubuntu.com/ubuntu-ports jammy-security/main arm64 Packages [1257 kB]                                                                                                                  
Get:19 http://ports.ubuntu.com/ubuntu-ports jammy-security/universe arm64 Packages [997 kB]                                                                                                               
Get:20 http://ports.ubuntu.com/ubuntu-ports jammy-security/multiverse arm64 Packages [24.0 kB]                                                                                                            
Get:21 http://ports.ubuntu.com/ubuntu-ports jammy-security/restricted arm64 Packages [1270 kB]                                                                                                            
Fetched 27.6 MB in 11s (2577 kB/s)                                                                                                                                                                        
Reading package lists... Done
root@6b5925ee2f3e:/# apt-get install -y mariadb-client
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
mariadb-client is already the newest version (1:11.3.2+maria~ubu2204).
mariadb-client set to manually installed.
0 upgraded, 0 newly installed, 0 to remove and 3 not upgraded.
root@6b5925ee2f3e:/# exit
exit
 Xiuk  🍻   ~/Documents/GIT-HUB/OnlineLectureStudy   master ±
 docker exec -it my-mariadb -u root -p
OCI runtime exec failed: exec failed: unable to start container process: exec: "-u": executable file not found in $PATH: unknown
 ✘ Xiuk  🍻   ~/Documents/GIT-HUB/OnlineLectureStudy   master ±
 docker exec -it my-mariadb -uroot -p                                                   
OCI runtime exec failed: exec failed: unable to start container process: exec: "-uroot": executable file not found in $PATH: unknown


root@6b5925ee2f3e:/# mariadb -u root -p
Enter password: 
