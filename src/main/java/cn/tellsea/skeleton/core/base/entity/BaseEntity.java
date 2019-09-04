package cn.tellsea.skeleton.core.base.entity;

import lombok.Data;

/**
 * 基类实体类, 实体公共属性
 *
 * @author Tellsea
 * @date 2019/7/29
 */
@Data
public class BaseEntity {

    /**
     * 当前页数
     */
    private int page;

    /**
     * 计算后的页数
     */
    private int offset;

    /**
     * 总条数
     */
    private int limit;

    public int getOffset() {
        return (page - 1) * limit;
    }

}
