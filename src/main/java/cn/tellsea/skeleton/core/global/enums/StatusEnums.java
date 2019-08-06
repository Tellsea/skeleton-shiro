package cn.tellsea.skeleton.core.global.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 异常枚举类
 *
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusEnums {

    /**
     * 业务枚举
     */
    LAYUI_SUCCESS(0, "加载成功"),
    SAVE_SUCCESS(200, "新增成功"),
    DELETE_SUCCESS(200, "删除成功"),
    UPDATE_SUCCESS(200, "修改成功"),
    SELECT_SUCCESS(200, "查询成功"),
    SAVE_ERROR(500, "新增失败"),
    DELETE_ERROR(500, "删除失败"),
    UPDATE_ERROR(500, "修改失败"),
    SELECT_ERROR(500, "查询失败"),
    /**
     * 系统枚举
     */
    UNAUTHORIZED(403, "未授权"),
    NOT_FOUND(404, "请求资源不存在"),
    USER_NOT_FOUND(500, "用户不存在"),
    PARAM_NOT_NULL(500, "参数不能为空"),
    CAPTCHA_ERROR(500, "验证码错误"),
    PASSWORD_ERROR(500, "密码错误"),
    SERVER_ERROR(500, "服务器累了，休息一会吧!"),
    ;

    private int code;

    private String info;

}
