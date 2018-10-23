package com.laonog.admin.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: sunchenguang
 * @Date: 2018/10/23 15:40
 * @Description:
 */
@Data
public class SysMenuDO implements Serializable {

    /**
     * 菜单ID
     */
    private Long id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单权限标识
     */
    private String permission;
    /**
     * 请求链接
     */
    private String url;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 父菜单ID
     */
    private Long parentId;
    /**
     * 图标
     */
    private String icon;
    /**
     * VUE页面
     */
    private String component;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private String type;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 0--正常 1--删除
     */
    private String delFlag;
    /**
     * 前端URL
     */
    private String path;

    @Override
    public String toString() {
        return "SysMenu{" +
            ", id=" + id +
            ", name=" + name +
            ", permission=" + permission +
            ", url=" + url +
            ", method=" + method +
            ", parentId=" + parentId +
            ", icon=" + icon +
            ", component=" + component +
            ", sort=" + sort +
            ", type=" + type +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", delFlag=" + delFlag +
            "}";
    }
}
