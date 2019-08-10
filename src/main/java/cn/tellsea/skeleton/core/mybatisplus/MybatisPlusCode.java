package cn.tellsea.skeleton.core.mybatisplus;

import cn.tellsea.skeleton.core.mybatisplus.config.MybatisPlusCodeConfig;

/**
 * 代码生成器
 *
 * @author Tellsea
 * @Description Created on 2019/7/22
 * 数据库时区问题解决方案
 * SHOW VARIABLES LIKE '%time_zone%'
 * SET GLOBAL time_zone='+8:00'
 */
public class MybatisPlusCode {

    public static void main(String[] args) {
        String[] nameList = new String[]{"user_info", "map_user_role", "role_info", "map_role_resource", "resource_info", "login_log", "system_log"};
        for (int i = 0; i < nameList.length; i++) {
            MybatisPlusCodeConfig.codeGenerator("common", nameList[i]);
        }
    }
}
