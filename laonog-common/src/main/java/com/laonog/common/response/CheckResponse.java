package com.laonog.common.response;


public class CheckResponse {
    /** 结果状态 **/
    private boolean rel = true;
    /** 返回消息 **/
    private String msg;
    /** 系统状态 **/
    private int status = 200;
    /** 错误编码 */
    private String errorCode;

    /**
     * 正确状态提示返回
     * @param msg
     */
    public CheckResponse(String msg) {
        this.rel = false;
        this.msg = msg;
    }

    /**
     * 错误状态信息返回
     * @param errorCode
     * @param msg
     */
    public CheckResponse(String errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    /**
     * 带系统状态的错误提示返回
     * @param status
     * @param errorCode
     * @param msg
     */
    public CheckResponse(int status, String errorCode, String msg) {
        this.status = status;
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
