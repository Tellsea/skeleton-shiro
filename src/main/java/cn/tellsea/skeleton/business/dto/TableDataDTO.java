package cn.tellsea.skeleton.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * bootstrap-table 指定格式DTO
 *
 * @author Tellsea
 * @Description Created on 2019/7/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableDataDTO<T> {

    /**
     * 实体类
     */
    private T entity;

    /**
     * 开始页
     */
    private Integer offset;

    /**
     * 条数
     */
    private Integer limit;

    /**
     * 排序
     */
    private String sort;

    /**
     * 排序字段名称
     */
    private String orderName;

    /**
     * 查询数据结果
     */
    private Object rows;

    /**
     * 总条数
     */
    private Integer total;
}
