package cn.tellsea.skeleton.common.vo;

import cn.tellsea.skeleton.common.entity.UserInfo;
import lombok.Data;

/**
 * @author Tellsea
 * @date 2019/8/10
 */
@Data
public class UserInfoVo extends UserInfo {

    /**
     * 创建人
     */
    private String createUserName;
}
