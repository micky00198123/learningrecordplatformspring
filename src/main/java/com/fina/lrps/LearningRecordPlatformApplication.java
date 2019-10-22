package com.fina.lrps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.fina.lrps.repository")
@SpringBootApplication
public class LearningRecordPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningRecordPlatformApplication.class, args);
    }

}
