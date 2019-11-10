package cn.tellsea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Skeleton 骨架 Shiro版 启动类
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@EnableAsync
@SpringBootApplication
@MapperScan("cn.tellsea.*.mapper")
public class SkeletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkeletonApplication.class, args);
    }
}
