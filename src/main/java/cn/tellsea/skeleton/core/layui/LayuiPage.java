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

    @Getter
    @Setter
    private int page;

    @Setter
    private int offset;

    @Getter
    @Setter
    private int limit;

    public int getOffset() {
        return (page - 1) * limit;
    }
}
