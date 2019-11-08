package cn.tellsea.skeleton.core.dto;

import cn.tellsea.skeleton.core.base.enums.BaseEnums;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import lombok.Data;

import java.io.*;

/**
 * 全局返回结果集
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Data
public class ResponseResult implements Cloneable, Serializable {

    private int code;
    private String message;
    private Object data;

    public static ResponseResult build(BaseEnums enums) {
        ResponseResult result = new ResponseResult();
        result.code = enums.getCode();
        result.message = enums.getInfo();
        result.data = null;
        return result;
    }

    public static ResponseResult build(BaseEnums enums, Object data) {
        ResponseResult result = new ResponseResult();
        result.code = enums.getCode();
        result.message = enums.getInfo();
        result.data = data;
        return result;
    }
}
