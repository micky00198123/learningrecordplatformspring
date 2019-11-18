package com.fina.lrps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.fina.lrps.dao")
public class LearningRecordPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearningRecordPlatformApplication.class, args);
    }
}
