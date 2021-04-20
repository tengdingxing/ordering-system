package com.czd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czd.mapper")
public class OrderingSystemAdminAplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingSystemAdminAplication.class,args);
    }
}
