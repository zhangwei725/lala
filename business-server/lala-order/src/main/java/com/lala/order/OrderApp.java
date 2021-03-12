package com.lala.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * DTO 可以控制层入口参数  业务层的入口参
 *
 */
@SpringBootApplication(scanBasePackages = "com.lala")
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
