package com.zyxx.skeleton.service;

import com.zyxx.common.entity.UserInfo;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import java.util.List;
import java.util.Map;

/**
 * shiro service 接口
 *
 * @author: Tellsea
 * @date: 2019/09/05
 */
public interface ShiroService {

    /**
     * 加载初始 bean 设置
     * @return
     */
    ShiroFilterFactoryBean loadShiroFilterFactoryBean();

    /**
     * 加载拦截器链
     *
     * @return
     */
    Map<String, String> loadFilterChainDefinitions();

    /**
     * 动态更新 shiro
     */
    void updatePermission();

}
