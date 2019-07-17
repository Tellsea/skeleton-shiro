package cn.tellsea.skeleton.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 封装在线用户信息
 *
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
@Data
public class OnlineUser implements Serializable {

    /**
     * sessionId
     */
    private String id;

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 主机地址
     */
    private String host;

    /**
     * 地理位置
     */
    private String address;

    /**
     * 用户开始访问时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 用户最后访问时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 超时时间
     */
    private Long timeout;

    /**
     * 状态
     */
    private String status;
}
