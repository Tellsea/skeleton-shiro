package com.zyxx.skeleton.core.global.dto;

import com.zyxx.skeleton.core.base.enums.BaseEnums;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
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
    private static ResponseResult responseResult;

    static {
        // 初始加载时，设置默认状态码与消息为成功，解决深度克隆空指针
        responseResult = new ResponseResult();
        responseResult.setCode(StatusEnums.OK.getCode());
        responseResult.setMessage(StatusEnums.OK.getInfo());
    }

    public static ResponseResult build(BaseEnums enums) {
        // ResponseResult result = getInstance();
        ResponseResult result = responseResult.clone();
        result.code = enums.getCode();
        result.message = enums.getInfo();
        result.data = null;
        return result;
    }

    public static ResponseResult build(BaseEnums enums, Object data) {
        // ResponseResult result = getInstance();
        ResponseResult result = responseResult.clone();
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
    public ResponseResult clone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            ResponseResult result = (ResponseResult) ois.readObject();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
