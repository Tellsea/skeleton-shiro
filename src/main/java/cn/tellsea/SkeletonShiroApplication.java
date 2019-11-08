package cn.tellsea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Skeleton 骨架 启动类
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@EnableAsync
@SpringBootApplication
@MapperScan("cn.tellsea.*.mapper")
public class SkeletonShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkeletonShiroApplication.class, args);
    }
}
