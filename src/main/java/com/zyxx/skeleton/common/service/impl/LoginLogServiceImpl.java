package com.zyxx.skeleton.common.service.impl;

import com.zyxx.skeleton.common.dao.LoginLogDao;
import com.zyxx.skeleton.common.entity.LoginLog;
import com.zyxx.skeleton.common.service.LoginLogService;
import com.zyxx.skeleton.core.base.service.impl.BaseServiceImpl;
import com.zyxx.skeleton.core.layui.LayuiTable;
import com.zyxx.skeleton.core.util.SqlUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Service接口实现类
 *
 * @author Tellsea
 * @date 2019-08-10
 */
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog, LoginLogDao> implements LoginLogService {

    @Override
    public LayuiTable listLoginLog(LoginLog loginLog) {
        Example example = new Example(LoginLog.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(loginLog.getUserName())) {
            criteria.andLike("userName", SqlUtils.like(loginLog.getUserName()));
        }
        example.orderBy("createTime").desc();
        int count = baseMapper.selectCountByExample(example);
        List<LoginLog> list = null;
        if (0 < count) {
            PageHelper.startPage(loginLog.getPage(), loginLog.getLimit());
            list = baseMapper.selectByExample(example);
        }
        return LayuiTable.build(count, list);
    }
}
