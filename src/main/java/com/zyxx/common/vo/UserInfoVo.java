package com.zyxx.common.vo;

import com.zyxx.common.entity.UserInfo;
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
