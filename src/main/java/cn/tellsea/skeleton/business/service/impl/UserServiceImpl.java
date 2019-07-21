package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.skeleton.business.dto.TableDataDTO;
import cn.tellsea.skeleton.business.entity.User;
import cn.tellsea.skeleton.business.mapper.UserMapper;
import cn.tellsea.skeleton.core.base.service.impl.BaseServiceImpl;
import cn.tellsea.skeleton.business.service.UserService;
import cn.tellsea.skeleton.core.consts.MysqlConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * User 接口实现类
 *
 * @author Tellsea
 * @Description Created on 2019/07/16
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public PageInfo<User> listUserByPage(Integer pn) {
        PageHelper.startPage(pn, 10);
        return new PageInfo<>(userMapper.listUserByPage());
    }

    @Override
    public TableDataDTO listUser(TableDataDTO<User> tableDataDTO) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        User userConditon = tableDataDTO.getEntity();
        if (!ObjectUtils.isEmpty(userConditon)) {
            if (!StringUtils.isEmpty(userConditon.getUsername())) {
                criteria.andLike("username", userConditon.getUsername());
            }
            if (!StringUtils.isEmpty(userConditon.getUsername())) {
                criteria.andLike("phone", userConditon.getPhone());
            }
        }
        if (!StringUtils.isEmpty(tableDataDTO.getSort()) && !StringUtils.isEmpty(tableDataDTO.getOrderName())) {
            if (StringUtils.equals(MysqlConst.ASC, tableDataDTO.getSort())) {
                example.orderBy(tableDataDTO.getOrderName()).asc();
            }
            if (StringUtils.equals(MysqlConst.DESC, tableDataDTO.getSort())) {
                example.orderBy(tableDataDTO.getOrderName()).desc();
            }
        }
        PageHelper.startPage(tableDataDTO.getOffset(), tableDataDTO.getLimit());
        List<User> list = baseMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<>(list);

        // 赋值结果集
        tableDataDTO.setRows(pageInfo.getList());
        tableDataDTO.setTotal(baseMapper.selectCountByExample(example));
        return tableDataDTO;
    }
}
