package com.laonog.common.enums;

import org.apache.commons.lang.StringUtils;

public enum ErrorCodeEnum {

    FAILED("failed", "操作失败"),

    PARAM_ERROR("param error", "参数异常"),

    SQL_OPERATION_ERROR("sql operation error", "数据库操作异常"),

    SQL_QUERY_ERROR("sql query error", "数据库查询异常"),

    QUERY_ERROR("query error", "查询失败"),

    INSERT_ERROR("insert error", "新增失败"),

    UPDATE_ERROR("update error", "修改失败"),

    DELETE_ERROR("delete error", "删除失败"),

    SYSTEM_ERROR("system error", "系统异常"),

    PARAM_IS_EMPTY("param empty", "参数为空" ),

    QUERY_PAGE_ERROR("query page error", "分页查询失败"),

    LOGIN_ERROR("login error","用户名密码不正确")
    ;

    private String errorCode;

    private String errorMessage;

    ErrorCodeEnum(String code, String message) {
        this.errorCode = code;
        this.errorMessage = message;
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
        for (ErrorCodeEnum object : ErrorCodeEnum.values()) {
            if (object.getErrorCode().equals(code)) {
                return object.getErrorMessage();
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

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Getter method for property <tt>errorMessage</tt>.
     *
     * @return property value of errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
