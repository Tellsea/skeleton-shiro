package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import ${package.Entity}.${entity};
import cn.tellsea.skeleton.core.global.dto.ResponseResult;
import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
* ${table.comment!} 前端控制器
*
* @author ${author}
* @Description Created on ${date}
*/
@Controller
@RequestMapping("${table.xmlName}")
public class ${table.controllerName} extends ${superControllerClass}<${entity}> {

    /**
     * 新增
     *
     * @param ${table.xmlName}
     * @return
     */
    @PostMapping("save${entity}")
    @ResponseBody
    public ResponseResult save${entity}(${entity} ${table.xmlName}) {
        baseService.insertSelective(${table.xmlName});
        return ResponseResult.build(StatusEnums.SAVE_SUCCESS);
    }

    /**
     * 更新
     *
     * @param ${table.xmlName}
     * @return
     */
    @PostMapping("update${entity}")
    @ResponseBody
    public ResponseResult update${entity}(${entity} ${table.xmlName}) {
        baseService.updateByPrimaryKeySelective(${table.xmlName});
        return ResponseResult.build(StatusEnums.UPDATE_SUCCESS);
    }
}
