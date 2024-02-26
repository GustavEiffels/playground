docker run -d --name my-mariadb -e MYSQL_ROOT_PASSWORD=ssw8039315 -p 33306:3306 mariadb

```
PS C:\Users\SIUK\GIT_REPO\PLAYGROUND> docker exec -it my-mariadb mysql -u root -p
OCI runtime exec failed: exec failed: unable to start container process: exec: "mysql": executable file not found in $PATH: unknown
```
> mysql 실행 파일을 찾을 수 없다. -> Mariadb 클라이언트가 컨테이너 내부에 설치 되어 있지 않다 


docker exec -it my-mariadb mariadb -uroot -p