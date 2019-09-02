package cn.tellsea.skeleton.common.service.impl;

import cn.tellsea.skeleton.common.dao.LoginLogDao;
import cn.tellsea.skeleton.common.entity.LoginLog;
import cn.tellsea.skeleton.common.service.LoginLogService;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.layui.LayuiTable;
import cn.tellsea.skeleton.core.util.SqlUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Service接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019-08-10
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
        int count = baseMapper.selectCountByExample(example);
        List<LoginLog> list = null;
        if (0 < count) {
            PageHelper.startPage(loginLog.getPage(), loginLog.getLimit());
            list = baseMapper.selectByExample(example);
        }
        return LayuiTable.build(count, list);
    }
}
