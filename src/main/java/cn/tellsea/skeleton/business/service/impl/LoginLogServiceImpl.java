package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.dao.LoginLogDao;
import cn.tellsea.skeleton.business.entity.LoginLog;
import cn.tellsea.skeleton.business.entity.UserInfo;
import cn.tellsea.skeleton.business.mapper.LoginLogMapper;
import cn.tellsea.skeleton.business.service.LoginLogService;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import cn.tellsea.skeleton.core.global.exception.SkeletonException;
import cn.tellsea.skeleton.core.layui.LayuiPage;
import cn.tellsea.skeleton.core.layui.LayuiTable;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDao loginLogDao;
    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public LayuiTable listLoginLog(LoginLog loginLog, LayuiPage layuiPage) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(loginLog.getUserName())) {
            criteria.andLike("user_name", loginLog.getUserName());
        }
        int count = loginLogMapper.selectCountByExample(example);
        List<LoginLog> list = null;
        if (count > 0) {
            PageHelper.startPage(layuiPage.getOffset(), layuiPage.getLimit());
            PageInfo<LoginLog> pageInfo = new PageInfo<>(loginLogMapper.selectAll());
            list = pageInfo.getList();
        }
        return LayuiTable.build(count, list);
    }

    @Override
    public void saveLoginLog(LoginLog loginLog) {
        int count = loginLogMapper.insertSelective(loginLog);
        if (count != 1) {
            throw new SkeletonException(StatusEnums.SAVE_ERROR);
        }
    }
}

