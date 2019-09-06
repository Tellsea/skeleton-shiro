package com.zyxx.skeleton.core.global.dto;

import com.zyxx.skeleton.core.base.enums.BaseEnums;
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
    private static volatile ResponseResult instance;

    public static ResponseResult build(BaseEnums enums) {
        ResponseResult result = getInstance();
        result.code = enums.getCode();
        result.message = enums.getInfo();
        result.data = null;
        return result;
    }

    public static ResponseResult build(BaseEnums enums, Object data) {
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

    @Override
    protected Object clone() {
        ResponseResult result = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // 将待克隆对象序列化
            oos.writeObject(this);
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));) {
                // 反序列化待克隆对象并在内存中重建
                result = (ResponseResult) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
