package com.edu.wlqz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.edu.wlqz.mapper")
public class WlqzApplication {

    public static void main(String[] args) {
        SpringApplication.run(WlqzApplication.class, args);
    }
}
