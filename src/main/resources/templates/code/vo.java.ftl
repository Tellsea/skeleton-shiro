package ${cfg.Vo};

import ${package.Entity}.${entity};
<#if entityLombokModel>
import lombok.Getter;
import lombok.Setter;
</#if>

/**
 * ${table.comment!} Vo类
 *
 * @author ${author}
 * @date ${date}
 */
@Getter
@Setter
public class ${entity}Vo extends ${entity} {

}
