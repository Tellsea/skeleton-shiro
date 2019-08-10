package cn.tellsea.skeleton.core.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基类实体类
 *
 * @author Tellsea
 * @Description Created on 2019/7/29
 * 通常存放共有属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    /**
     * Layui Page 分页参数：页数
     */
    private int page;

    /**
     * Layui Page 分页参数：条数
     */
    private int limit;

    public int getPage() {
        return (page - 1) * limit;
    }

}
