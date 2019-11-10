package ${package.Controller};

import ${package.Service}.${table.serviceName};
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${table.comment!} 前端控制器
 *
 * @author ${author}
 * @date ${date}
 */
@Controller
@RequestMapping("${table.xmlName}")
public class ${table.controllerName} extends ${superControllerClass}<${table.serviceName}> {

}
