package com.laonog.common.enums;

import org.apache.commons.lang.StringUtils;

public enum SuccessCodeEnum {

    SUCCESS("success", "操作成功"),

    PAREAM_CHEKC("success", "参数验证通过"),

    QUERY_SUCCESS("query success", "查询成功"),

    INSERT_SUCCESS("insert success", "新增成功"),

    UPDATE_SUCCESS("update success", "修改成功"),

    DELETE_SUCCESS("delete success", "删除成功"),

    LOGIN_SUCCESS("login success", "登录成功"),

    QUERY_PAGE_SUCCESS("query page success", "分页查询成功"),

    ;



    private String successCode;

    private String successMessage;
    SuccessCodeEnum(String code, String message) {
        this.successCode = code;
        this.successMessage = message;
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
        for (SuccessCodeEnum object : SuccessCodeEnum.values()) {
            if (object.getSuccessCode().equals(code)) {
                return object.getSuccessMessage();
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
    public static ErrorCodeEnum getEnumObjByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (ErrorCodeEnum object : ErrorCodeEnum.values()) {
            if (object.getErrorCode().equals(code)) {
                return object;
            }
        }
        return null;
    }

    public String getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }


}
