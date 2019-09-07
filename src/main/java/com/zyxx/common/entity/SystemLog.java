package com.zyxx.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyxx.skeleton.core.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 系统日志表 实体类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Getter
@Setter
public class SystemLog extends BaseEntity {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作用户
     */
    private String userName;

    /**
     * 操作描述
     */
    private String operation;

    /**
     * 耗时(毫秒)
     */
    private Integer time;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 操作参数
     */
    private String params;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 操作时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 操作地点
     */
    private String location;

}
