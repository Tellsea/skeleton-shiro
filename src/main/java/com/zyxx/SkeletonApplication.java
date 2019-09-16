package com.zyxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 项目启动类
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@EnableAsync
@SpringBootApplication
@MapperScan("com.zyxx.business.*.mapper")
public class SkeletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkeletonApplication.class, args);
    }
}
