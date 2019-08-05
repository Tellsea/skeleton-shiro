package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import ${package.Entity}.${entity};
import org.springframework.stereotype.Controller;
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

}
