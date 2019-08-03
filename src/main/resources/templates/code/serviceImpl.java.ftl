package ${package.ServiceImpl};

import ${package.Mapper}. ${table.mapperName};
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;
import cn.tellsea.skeleton.business.dao.${entity}Dao;

/**
 * ${table.comment!} Service接口实现类
 *
 * @author ${author}
 * @Description Created on ${date}
 */
@Service
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Autowired
    private ${entity}Dao ${table.xmlName}Dao;
    @Autowired
    private ${table.mapperName} ${table.xmlName}Mapper;

}

