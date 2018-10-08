package com.laonog.common.enums.sysuser;

import org.apache.commons.lang.StringUtils;

/**
 *
 *
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-12 21:20:48
 */
public enum SysUserCodeEnum {

    ID_EMPTY("Id empty", "ID为空"),

    USERNAME_EMPTY("Username empty", "用户名为空"),

    PASSWORD_EMPTY("Password empty", "密码为空"),

    PHONE_NUMBER_EMPTY("PhoneNumber empty", "手机号码为空"),

    QR_CODE_EMPTY("QrCode empty", "二维码名片为空"),

    USER_STATUS_EMPTY("UserStatus empty", "用户状态 0-正常 1-锁定为空"),

    GMT_CREATE_EMPTY("GmtCreate empty", "创建时间为空"),

    GMT_MODIFIED_EMPTY("GmtModified empty", "修改时间为空"),

    CREATOR_EMPTY("Creator empty", "创建人为空"),

    MODIFIER_EMPTY("Modifier empty", "修改人为空"),

    IS_DELETE_EMPTY("IsDelete empty", "0-有效 1-删除为空"),;

    private String code;

    private String message;

    SysUserCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据code获取message
     *
     * @param code
     * @return
     */
    public static String getDescByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (SysUserCodeEnum object : SysUserCodeEnum.values()) {
            if (object.getCode().equals(code)) {
                return object.getMessage();
            }
        }
        return null;
    }

    /**
     * 根据code获取枚举对象
     *
     * @param code
     * @return
     */
    public static SysUserCodeEnum getEnumObjByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (SysUserCodeEnum object : SysUserCodeEnum.values()) {
            if (object.getCode().equals(code)) {
                return object;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
