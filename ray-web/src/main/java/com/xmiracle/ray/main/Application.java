package com.xmiracle.ray.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by haiyan@meili-inc.com on 2019/1/31
 */
@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan(value = "com.xmiracle.ray.servlet")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
