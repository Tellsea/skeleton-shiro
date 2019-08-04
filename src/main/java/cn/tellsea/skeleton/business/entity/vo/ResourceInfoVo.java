package cn.tellsea.skeleton.business.entity.vo;

import cn.tellsea.skeleton.business.entity.ResourceInfo;
import lombok.Data;

import java.util.List;

/**
 * @author Tellsea
 * @Description Created on 2019/8/4
 */
@Data
public class ResourceInfoVo extends ResourceInfo {

    /**
     * 子菜单
     */
    private List<ResourceInfoVo> childMenus;
}
