package cn.tellsea.skeleton.business.mapper;

import cn.tellsea.skeleton.business.entity.Resource;
import cn.tellsea.skeleton.core.base.mapper.MyMapper;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author Tellsea
 * @Description Created on 2019/07/16
 */
public interface ResourceMapper extends MyMapper<Resource> {

    /**
     * 根据用户id查询所有资源名称
     *
     * @param id
     * @return
     */
    List<Resource> listResourceByUserId(Long id);
}
