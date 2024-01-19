package practice.jpa.board.logging;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LogDto {

    public  void info(String text,String methodName){
        log.info("[{}] - METHOD NAME : {} ",uuid,methodName);
        log.info("[{}] - TEXT : {} ",uuid,text);

    }
    private String uuid     ;
    private long startTime  ;

    @PostConstruct
    public void commence(){
        uuid  = UUID.randomUUID().toString();
        log.info("[{}] - REQUEST SCOPE BEAN CREATE ",uuid);
    }

    @PreDestroy
    public void terminate(){
        log.info("[{}] - REQUEST SCOPE BEAN TERMINATE ",uuid);
    }
}
