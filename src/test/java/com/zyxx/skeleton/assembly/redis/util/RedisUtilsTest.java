package com.zyxx.skeleton.assembly.redis.util;

import com.zyxx.SkeletonApplicationTests;
import org.junit.Test;

public class RedisUtilsTest extends SkeletonApplicationTests {

    @Test
    public void testRedis() {
        /*boolean result = RedisUtils.set("name", "hello");
        System.out.println(result);*/
        System.out.println(RedisUtils.get("name"));
    }
}