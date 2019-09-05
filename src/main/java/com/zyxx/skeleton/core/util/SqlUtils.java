package com.zyxx.skeleton.core.util;

/**
 * SQL 构建工具类
 *
 * @author Tellsea
 * @date 2019/8/10
 */
public class SqlUtils {

    public static String like(String value) {
        return "%".concat(value).concat("%");
    }
}
