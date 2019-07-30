package cn.tellsea.skeleton.core.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * layui 固定格式
 *
 * @author Tellsea
 * @Description Created on 2019/7/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    private int code;

    private String msg;

    private int count;

    private Object data;
}
