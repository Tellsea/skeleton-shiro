package ${package.Controller};

import ${package.Service}.${table.serviceName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * ${table.comment!} 前端控制器
 *
 * @author ${author}
 * @Description Created on ${date}
 */
@Controller
@RequestMapping("${table.xmlName}")
public class ${table.controllerName} {

    @Autowired
    private ${table.serviceName} ${table.xmlName}Service;

}
