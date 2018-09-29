package com.laonog.common.response;

public class ObjectRestResponse<T> {

    /** 数据 **/
    private T data;
    /** 返回消息 **/
    private String msg;
    /** 结果状态 **/
    private boolean rel = false;
    /** 错误编码 */
    private String errorCode ;
    /** 系统状态 **/
    private int status = 200;

    /**
     * 正确状态数据返回
     * @param msg
     * @param data
     */
    public ObjectRestResponse(String msg, T data) {
        this.rel = true;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 无业务数据错误信息返回
     * @param errorCode
     * @param msg
     */
    public ObjectRestResponse(String errorCode, String msg) {
        this.msg = msg;
        this.errorCode = errorCode;
    }

    /**
     * 带系统状态的错误信息返回
     * @param status
     * @param errorCode
     * @param msg
     */
    public ObjectRestResponse(int status, String errorCode, String msg) {
        this.status = status;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    /**
     * 带业务数据的错误信息返回
     * @param errorCode
     * @param msg
     * @param data
     */
    public ObjectRestResponse(String errorCode, String msg, T data) {
        this.msg = msg;
        this.errorCode = errorCode;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
