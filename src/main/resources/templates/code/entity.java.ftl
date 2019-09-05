package ${package.Entity};

import cn.tellsea.skeleton.core.base.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
<#if entityLombokModel>
import lombok.Data;
</#if>

import javax.persistence.*;
import java.util.Date;

/**
 * ${table.comment!} 实体类
 *
 * @author ${author}
 * @date ${date}
 */
@Data
public class ${entity} extends ${superEntityClass} {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    /**
     * ${field.comment}
     */
    <#if "id" == field.name>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    </#if>
    <#if "create_time" == field.name>
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    </#if>
    <#if "modify_time" == field.name>
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    </#if>
    <#if field.propertyType == "LocalDateTime">
    private Date ${field.propertyName};
    <#else>
    private ${field.propertyType} ${field.propertyName};
    </#if>

</#list>
<#------------  END 字段循环遍历  tinyint 转 Integer ---------->
}