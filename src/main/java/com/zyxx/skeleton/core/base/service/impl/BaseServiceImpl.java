package com.zyxx.skeleton.core.base.service.impl;

import com.zyxx.skeleton.core.base.dao.BaseDao;
import com.zyxx.skeleton.core.base.mapper.MyMapper;
import com.zyxx.skeleton.core.base.service.BaseService;
import com.zyxx.skeleton.core.global.enums.StatusEnums;
import com.zyxx.skeleton.core.global.exception.GlobalException;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 基类接口实现类
 *
 * @param <T>
 * @param <D>
 * @author Tellsea
 * @date 2019/8/6
 */
public class BaseServiceImpl<T, D extends BaseDao> implements BaseService<T> {

    @Autowired
    protected D baseDao;

    @Autowired
    protected MyMapper<T> baseMapper;

    @Override
    public void insert(T record) {
        int count = baseMapper.insert(record);
        if (0 == count) {
            throw new GlobalException(StatusEnums.SAVE_ERROR);
        }
    }

    @Override
    public void insertSelective(T record) {
        int count = baseMapper.insertSelective(record);
        if (0 == count) {
            throw new GlobalException(StatusEnums.SAVE_ERROR);
        }
    }

    @Override
    public void insertList(List<? extends T> recordList) {
        int count = baseMapper.insertList(recordList);
        if (0 == count) {
            throw new GlobalException(StatusEnums.SAVE_ERROR);
        }
    }

    @Override
    public void insertUseGeneratedKeys(T record) {
        int count = baseMapper.insertUseGeneratedKeys(record);
        if (0 == count) {
            throw new GlobalException(StatusEnums.SAVE_ERROR);
        }
    }

    @Override
    public void delete(T record) {
        int count = baseMapper.delete(record);
        if (0 == count) {
            throw new GlobalException(StatusEnums.DELETE_ERROR);
        }
    }

    @Override
    public void deleteByPrimaryKey(Object key) {
        int count = baseMapper.deleteByPrimaryKey(key);
        if (0 == count) {
            throw new GlobalException(StatusEnums.DELETE_ERROR);
        }
    }

    @Override
    public void deleteByIds(String ids) {
        int count = baseMapper.deleteByIds(ids);
        if (0 == count) {
            throw new GlobalException(StatusEnums.DELETE_ERROR);
        }
    }

    @Override
    public void deleteByExample(Object example) {
        int count = baseMapper.deleteByExample(example);
        if (0 == count) {
            throw new GlobalException(StatusEnums.DELETE_ERROR);
        }
    }

    @Override
    public void updateByPrimaryKey(T record) {
        int count = baseMapper.updateByPrimaryKey(record);
        if (0 == count) {
            throw new GlobalException(StatusEnums.DELETE_ERROR);
        }
    }

    @Override
    public void updateByPrimaryKeySelective(T record) {
        int count = baseMapper.updateByPrimaryKeySelective(record);
        if (0 == count) {
            throw new GlobalException(StatusEnums.DELETE_ERROR);
        }
    }

    @Override
    public void updateByExample(T record, Object example) {
        int count = baseMapper.updateByExample(record, example);
        if (0 == count) {
            throw new GlobalException(StatusEnums.DELETE_ERROR);
        }
    }

    @Override
    public void updateByExampleSelective(T record, Object example) {
        int count = baseMapper.updateByExampleSelective(record, example);
        if (0 == count) {
            throw new GlobalException(StatusEnums.DELETE_ERROR);
        }
    }

    @Override
    public void updateBatchByPrimaryKeySelective(List<? extends T> recordList) {
        int count = baseMapper.updateBatchByPrimaryKeySelective(recordList);
        if (0 == count) {
            throw new GlobalException(StatusEnums.DELETE_ERROR);
        }
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        T t = baseMapper.selectByPrimaryKey(key);
        if (null == t) {
            throw new GlobalException(StatusEnums.NOT_FOUND);
        }
        return t;
    }

    @Override
    public T selectOne(T record) {
        T t = baseMapper.selectOne(record);
        if (null == t) {
            throw new GlobalException(StatusEnums.NOT_FOUND);
        }
        return t;
    }

    @Override
    public T selectOneByExample(Object example) {
        T t = baseMapper.selectOneByExample(example);
        if (null == t) {
            throw new GlobalException(StatusEnums.NOT_FOUND);
        }
        return t;
    }

    @Override
    public List<T> select(T record) {
        return baseMapper.select(record);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public List<T> selectByExample(Object example) {
        if (ObjectUtils.isEmpty(example)) {
            throw new GlobalException(StatusEnums.PARAM_NOT_NULL);
        }
        return baseMapper.selectByExample(example);
    }

    @Override
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        if (null == record || null == rowBounds) {
            throw new GlobalException(StatusEnums.PARAM_NOT_NULL);
        }
        return baseMapper.selectByRowBounds(record, rowBounds);
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        if (null == rowBounds || ObjectUtils.isEmpty(example)) {
            throw new GlobalException(StatusEnums.PARAM_NOT_NULL);
        }
        return baseMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public int selectCount(T record) {
        if (ObjectUtils.isEmpty(record)) {
            throw new GlobalException(StatusEnums.PARAM_NOT_NULL);
        }
        return baseMapper.selectCount(record);
    }

    @Override
    public int selectCountByExample(Object example) {
        if (ObjectUtils.isEmpty(example)) {
            throw new GlobalException(StatusEnums.PARAM_NOT_NULL);
        }
        return baseMapper.selectCountByExample(example);
    }
}
