package com.edu.lingnan.fouradminmallboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 23:34 2020/7/21
 */
@MapperScan("com.edu.lingnan.fouradminmallboot.*.mapper")
@SpringBootApplication
public class FourAdminMallBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(FourAdminMallBootApplication.class, args);
    }
}
