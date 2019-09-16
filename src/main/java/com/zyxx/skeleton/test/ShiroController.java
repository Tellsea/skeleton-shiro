package com.zyxx.skeleton.test;

import com.zyxx.skeleton.core.shiro.realm.ShiroRealm;
import com.zyxx.skeleton.core.shiro.util.ShiroUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * shiro 测试类
 *
 * @author: Tellsea
 * @date: 2019/09/11
 */
@RestController
@RequestMapping("shiro")
public class ShiroController {

    @Autowired
    private ShiroRealm shiroRealm;

    @GetMapping("test")
    public void test() {
        AuthorizationInfo info = shiroRealm.getAuthorizationInfo(ShiroUtils.getPrincipals());
        System.out.println(info);
    }
}