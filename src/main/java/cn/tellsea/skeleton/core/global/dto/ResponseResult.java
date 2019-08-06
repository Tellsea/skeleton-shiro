package cn.tellsea.skeleton.core.global.dto;

import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import lombok.Data;

/**
 * 全局返回结果集
 *
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
@Data
public class ResponseResult {

    private int code;
    private String message;
    private Object data;
    private static volatile ResponseResult instance;

    public static ResponseResult build(StatusEnums enums) {
        ResponseResult result = getInstance();
        result.code = enums.getCode();
        result.message = enums.getInfo();
        result.data = null;
        return result;
    }

    public static ResponseResult build(StatusEnums enums, Object data) {
        ResponseResult result = getInstance();
        result.code = enums.getCode();
        result.message = enums.getInfo();
        result.data = data;
        return result;
    }

    public static ResponseResult getInstance() {
        if (null == instance) {
            synchronized (ResponseResult.class) {
                if (null == instance) {
                    instance = new ResponseResult();
                }
            }
        }
        return instance;
    }
}
