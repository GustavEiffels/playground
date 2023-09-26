package com.example.demo.common.dto;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity 
{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID pid;

    private Timestamp createTimeStamp;

    private Timestamp updateTimeStamp;

    public BaseEntity()
    {
        this.createTimeStamp = new Timestamp(System.currentTimeMillis());
        this.createTimeStamp = new Timestamp(System.currentTimeMillis());
    }
        
}
