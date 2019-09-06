package com.zyxx.skeleton.assembly.layui;

import lombok.Data;

import java.util.List;

/**
 * Layui 树形组件
 *
 * @author: Tellsea
 * @date: 2019/08/05
 */
@Data
public class LayuiTree {

    /**
     * 节点唯一索引，用于对指定节点进行各类操作
     */
    private int id;

    /**
     * 节点标题
     */
    private String title;

    /**
     * 点击节点弹出新窗口对应的 url。需开启 isJump 参数
     */
    private String href;

    /**
     * 节点是否初始展开，默认 false
     */
    private Boolean spread;

    /**
     * 节点是否初始为选中状态（如果开启复选框的话），默认 false
     */
    private Boolean checked;

    /**
     * 节点是否为禁用状态。默认 false
     */
    private Boolean disabled;

    /**
     * 子节点。支持设定选项同父节点
     */
    private List<LayuiTree> children;

}
