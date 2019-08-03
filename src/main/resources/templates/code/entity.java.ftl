package ${package.Entity};

import com.alibaba.fastjson.annotation.JSONField;
<#if entityLombokModel>
import lombok.Data;
</#if>

import javax.persistence.Id;
import java.util.Date;

/**
 * ${table.comment!} 实体类
 *
 * @author ${author}
 * @Description Created on ${date}
 */
@Data
public class ${entity} {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    /**
     * ${field.comment}
     */
    <#if "id" == field.name>
    @Id
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
<#------------  END 字段循环遍历  ---------->
}
