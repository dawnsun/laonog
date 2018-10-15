package com.laonog.admin.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserDO implements Serializable {

    //
    private Long id;

    //用户名
    private String username;

    //密码
    private String password;

    //手机号码
    private String phoneNumber;

    //地址
    private String address;

    //头像
    private String avatar;

    //昵称
    private String nickname;

    //二维码名片
    private String qrCode;

    //0-女 1-男
    private Integer sex;

    //生日
    private String birthday;

    //用户状态 0-正常 1-锁定
    private Integer userStatus;

    //创建时间
    private Date gmtCreate;

    //修改时间
    private Date gmtModified;

    //创建人
    private String creator;

    //修改人
    private String modifier;

    //0-有效 1-删除
    private Integer isDelete;

}
