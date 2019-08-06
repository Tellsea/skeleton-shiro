package cn.tellsea.skeleton.core.layui;

import cn.tellsea.skeleton.core.global.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Layui Table 固定格式
 *
 * @author Tellsea
 * @Description Created on 2019/8/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayuiTable {

    /**
     * 0 为成功
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 总条数
     */
    private int count;

    /**
     * 数据
     */
    private Object data;

    private static volatile LayuiTable instance;

    public static LayuiTable build(int count, Object data) {
        LayuiTable table = getInstance();
        table.code = StatusEnums.LAYUI_SUCCESS.getCode();
        table.msg = StatusEnums.LAYUI_SUCCESS.getInfo();
        table.count = count;
        table.data = data;
        return table;
    }

    public static LayuiTable getInstance() {
        if (null == instance) {
            synchronized (LayuiTable.class) {
                if (null == instance) {
                    instance = new LayuiTable();
                }
            }
        }
        return instance;
    }
}
