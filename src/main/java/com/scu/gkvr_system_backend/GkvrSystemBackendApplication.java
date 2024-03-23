package com.scu.gkvr_system_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.scu.gkvr_system_backend.mapper")
public class GkvrSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GkvrSystemBackendApplication.class, args);
    }

}
