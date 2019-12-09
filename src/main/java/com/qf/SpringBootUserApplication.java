package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootUserApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        System.out.println("项目启动啦");
        System.out.println("第二次修改");
        SpringApplication.run(SpringBootUserApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootUserApplication.class);
    }
}
