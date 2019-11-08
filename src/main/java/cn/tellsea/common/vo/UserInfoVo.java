package cn.tellsea.common.vo;

import cn.tellsea.common.entity.UserInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Tellsea
 * @date 2019/8/10
 */
@Getter
@Setter
public class UserInfoVo extends UserInfo {

    /**
     * 创建人
     */
    private String createUserName;
}
