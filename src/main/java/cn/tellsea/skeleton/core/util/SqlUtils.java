package cn.tellsea.skeleton.core.util;

/**
 * SQL 构建工具类
 *
 * @author Tellsea
 * @Description Created on 2019/8/10
 */
public class SqlUtils {

    public static String like(String value) {
        return "%".concat(value).concat("%");
    }
}
