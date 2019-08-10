package cn.tellsea.skeleton.common.entity.vo;

import cn.tellsea.skeleton.common.entity.UserInfo;
import lombok.Data;

/**
 * @author Tellsea
 * @Description Created on 2019/8/10
 */
@Data
public class UserInfoVO extends UserInfo {

    /**
     * 创建人
     */
    private String createUserName;
}
