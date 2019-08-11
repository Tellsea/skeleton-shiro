package cn.tellsea.skeleton.core.base.entity;

import lombok.Data;

/**
 * 基类实体类
 *
 * @author Tellsea
 * @Description Created on 2019/7/29
 * 通常存放共有属性
 */
@Data
public class BaseEntity {

    /**
     * Layui Page 分页参数：页数
     */
    private int page;

    /**
     * Layui Page 分页参数：条数
     */
    private int limit;

}
