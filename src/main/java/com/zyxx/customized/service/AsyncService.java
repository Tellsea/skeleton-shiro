package com.zyxx.customized.service;

import java.util.concurrent.Future;

/**
 * 异步方法示例 接口层
 *
 * @author: Tellsea
 * @date: 2019/09/10
 */
public interface AsyncService {

    /**
     * 异步方法测试案例
     *
     * @return
     */
    Future<String> exampleAsync();

    /**
     * 异步加上线程池
     */
    void executeAsync();
}