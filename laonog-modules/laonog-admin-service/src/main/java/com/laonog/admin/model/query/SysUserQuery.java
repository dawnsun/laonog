package com.laonog.admin.model.query;


import com.laonog.common.query.BaseQuery;

import java.util.Date;

/**
 * 查询条件
 *
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-09 18:45:59
 */
public class SysUserQuery extends BaseQuery {

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

    /**
     * set用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * set密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * set手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * get手机号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * set地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * set头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * get头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * set昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * get昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * set二维码名片
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    /**
     * get二维码名片
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * set0-女 1-男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * get0-女 1-男
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * set生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * get生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * set用户状态 0-正常 1-锁定
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * get用户状态 0-正常 1-锁定
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * set创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * get创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * set修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * get修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * set创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * get创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * set修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * get修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * set0-有效 1-删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * get0-有效 1-删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
