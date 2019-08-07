package cn.tellsea.skeleton.core.base.enums;

/**
 * 枚举根接口
 *
 * @author Tellsea
 * @Description Created on 2019/8/5
 */
public interface BaseEnums {

    /**
     * 获得状态码
     *
     * @return
     */
    int getCode();

    /**
     * 获得消息
     *
     * @return
     */
    String getInfo();
}