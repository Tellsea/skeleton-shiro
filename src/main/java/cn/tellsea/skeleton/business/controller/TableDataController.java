package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.business.dto.TableDataDTO;
import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.business.service.UserService;
import cn.tellsea.skeleton.core.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * bootstrap-table 测试控制器
 *
 * @author Tellsea
 * @Description Created on 2019/7/20
 */
@Controller
public class TableDataController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     *
     * @param tableDataDTO
     * @return
     */
    @GetMapping("/listUser")
    @ResponseBody
    public ResponseResult listUser(TableDataDTO<User> tableDataDTO) {
        return ResponseResult.success(userService.listUser(tableDataDTO));
    }
}
