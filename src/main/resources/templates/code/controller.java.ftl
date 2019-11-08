package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import ResponseResult;
import StatusEnums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${table.comment!} 前端控制器
 *
 * @author ${author}
 * @date ${date}
 */
@Controller
@RequestMapping("${table.xmlName}")
public class ${table.controllerName} extends ${superControllerClass}<${table.serviceName}> {

    @GetMapping("init")
    public String init() {
        return "admin/${cfg.tableName}";
    }

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
