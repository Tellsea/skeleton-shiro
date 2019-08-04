package cn.tellsea.skeleton.business.entity.vo;

import cn.tellsea.skeleton.business.entity.UserInfo;
import lombok.Data;

/**
 * 实体扩展 Vo
 *
 * @author Tellsea
 * @Description Created on 2019/8/4
 */
@Data
public class UserInfoVo extends UserInfo {

    /**
     * 创建人
     */
    private String createUserName;
}
