package com.zyxx.customized.service.impl;

import com.zyxx.common.entity.ResourceInfo;
import com.zyxx.common.mapper.ResourceInfoMapper;
import com.zyxx.customized.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * shiro service 实现类
 *
 * @author: Tellsea
 * @date: 2019/09/05
 * 参考文章：https://blog.csdn.net/batter_hwb/article/details/83792775
 */
@Slf4j
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    public ShiroFilterFactoryBean loadShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());
        return shiroFilterFactoryBean;
    }

    @Override
    public Map<String, String> loadFilterChainDefinitions() {
        List<ResourceInfo> list = resourceInfoMapper.selectAll();
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(resourceInfo -> {
                if (!StringUtils.isEmpty(resourceInfo.getUrl()) && !StringUtils.isEmpty(resourceInfo.getPerms())) {
                    filterChainDefinitionMap.put(resourceInfo.getUrl(), "perms[\"" + resourceInfo.getPerms() + "\"]");
                }
            });
        }
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/Captcha.jpg", "anon");
        filterChainDefinitionMap.put("/assets/**", "anon");
        filterChainDefinitionMap.put("/**", "user");
        return filterChainDefinitionMap;
    }

    @Override
    public void updatePermission() {
        synchronized (this) {
            ShiroFilterFactoryBean shiroFilterFactoryBean = loadShiroFilterFactoryBean();
            shiroFilterFactoryBean.setSecurityManager(SecurityUtils.getSecurityManager());

            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
            } catch (Exception e) {
                log.error("ShiroServiceImpl: 从 ShirofilterFactoryBean 错误获取 Shirofilter !");
                throw new RuntimeException("从 ShirofilterFactoryBean 错误获取 Shirofilter !");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            log.info("ShiroServiceImpl: 清空旧的权限控制...");
            manager.getFilterChains().clear();
            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());

            log.info("ShiroServiceImpl: 重新构建权限控制的过滤链...");
            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                manager.createChain(url, chainDefinition);
            }
        }
    }
}
