package cn.tellsea.skeleton.business.service;

import cn.tellsea.skeleton.business.entity.vo.ResourceInfoVo;

import java.util.List;

/**
 * 资源表 Service接口
 *
 * @author Tellsea
 * @Description Created on 2019-08-03
 */
public interface ResourceInfoService {

    /**
     * 根据用户id，构建侧边栏
     *
     * @param id
     * @return
     */
    List<ResourceInfoVo> listResourceInfoByUserId(Integer id);
}
