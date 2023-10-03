package com.example.demo.common.dto;

import org.springframework.jdbc.core.RowCountCallbackHandler;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReturnDto 
{
    private String  resultCode;
    private String  resultMessage;
    private Object  sendSomething;   

    public ReturnDto(String resultCode, String resultMessage, Object sendSomething)
    {
        this.resultCode     = resultCode;
        this.resultMessage  = resultMessage;
        this.sendSomething  = sendSomething;
    }

    public ReturnDto() {}

    public ReturnDto success(String message, Object sendSomething)
    {
        return new ReturnDto("200", message, sendSomething);
    } 

    public ReturnDto fail(String message, Object sendSomething)
    {
        return new ReturnDto("400", message, sendSomething);
    }
}
