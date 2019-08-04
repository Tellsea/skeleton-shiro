package cn.tellsea.skeleton.business.service.impl;

import cn.tellsea.SkeletonApplicationTests;
import cn.tellsea.skeleton.business.entity.vo.ResourceInfoVo;
import cn.tellsea.skeleton.business.service.ResourceInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ResourceInfoServiceImplTest extends SkeletonApplicationTests {

    @Autowired
    private ResourceInfoService resourceInfoService;

    @Test
    public void listResourceInfoByUserId() {
        List<ResourceInfoVo> resourceInfoVoList = resourceInfoService.listResourceInfoByUserId(1);
        System.out.println(resourceInfoVoList);
    }
}
