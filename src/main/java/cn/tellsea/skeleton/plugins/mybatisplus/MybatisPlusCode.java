package cn.tellsea.skeleton.plugins.mybatisplus;

import cn.tellsea.skeleton.plugins.mybatisplus.config.MybatisPlusCodeConfig;

import javax.swing.*;

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
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "当前操作: 生成代码，请确保生成的文件不存在，否则会覆盖！", "请选择", JOptionPane.YES_NO_OPTION);
        if (0 == showConfirmDialog) {
             String[] nameList = new String[]{"map_user_role", "role_info", "map_role_resource", "resource_info", "login_log", "system_log"};
            for (int i = 0; i < nameList.length; i++) {
                MybatisPlusCodeConfig.codeGenerator("common", nameList[i]);
            }
        }
    }
}
