package cn.tellsea.skeleton.core.base.entity;

import lombok.Data;

/**
 * 基类实体类, 实体公共属性
 *
 * @author Tellsea
 * @Description Created on 2019/7/29
 */
@Data
public class BaseEntity {

    private int page;

    private int offset;

    private int limit;

    public int getOffset() {
        return (page - 1) * limit;
    }

}
