package cn.tellsea.skeleton.core.layui;

import lombok.Getter;
import lombok.Setter;

/**
 * Layui Page 分页参数
 *
 * @author Tellsea
 * @Description Created on 2019/8/4
 */
public class LayuiPage {

    /**
     * 页数
     */
    @Setter
    private int page;

    /**
     * 条数
     */
    @Getter
    @Setter
    private int limit;

    public int getPage() {
        return (page - 1) * limit;
    }
}
