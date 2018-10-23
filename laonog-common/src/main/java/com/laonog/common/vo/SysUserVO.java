package com.laonog.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户vo
 */
@Data
public class SysUserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 随机盐
     */
    private String salt;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 0-正常，1-删除
     */
    private String delFlag;
    /**
     * 简介
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;

    //手机号码
    private String phoneNumber;

    //地址
    private String address;

    //昵称
    private String nickname;

    //二维码名片
    private String qrCode;

    //0-女 1-男
    private String sex;

    //生日
    private String birthday;

    //用户状态 0-正常 1-锁定
    private String userStatus;

    //0-有效 1-删除
    private String isDelete;

    //创建时间
    private Date gmtCreate;

    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 角色列表
     */
    private List<SysRole> roleList;
}
