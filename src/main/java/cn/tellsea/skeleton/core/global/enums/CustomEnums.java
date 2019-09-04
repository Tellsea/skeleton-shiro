package cn.tellsea.skeleton.core.global.enums;

import cn.tellsea.skeleton.core.base.enums.BaseEnums;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 自定义枚举
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@NoArgsConstructor
@AllArgsConstructor
public enum CustomEnums implements BaseEnums {

    /**
     * 默认枚举
     */
    OK(),
    ERROR(),
    ;

    public static CustomEnums ok(int code, String info) {
        CustomEnums.OK.code = code;
        CustomEnums.OK.info = info;
        return CustomEnums.OK;
    }

    @Setter
    private int code;

    @Setter
    private String info;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getInfo() {
        return info;
    }
}
