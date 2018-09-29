package com.laonog.common.response;

import com.laonog.common.constant.CommonConstant;

import java.util.List;

public class TableResultResponse<T> {

    private TableData<T> data;

    /**
     * 返回消息
     **/
    private String msg;
    /**
     * 结果状态
     **/
    private boolean rel = false;
    /**
     * 错误编码
     */
    private String errorCode;
    /**
     * 系统状态
     **/
    private int status = 200;

    /**
     * 正确状态数据返回
     *
     * @param msg   提示信息
     * @param totalDataNum 总数
     * @param rows  数据
     */
    public TableResultResponse(String msg, int pageNo, int pageSize, long totalDataNum, List<T> rows) {
        this.rel = true;
        this.msg = msg;
        this.data = new TableData<T>(pageNo, pageSize, totalDataNum, rows);
    }

    /**
     * 带系统状态的错误信息返回
     *
     * @param status
     * @param errorCode
     * @param msg
     */
    public TableResultResponse(int status, String errorCode, String msg) {
        this.status = status;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    /**
     * 无业务数据错误信息返回
     *
     * @param errorCode
     * @param msg
     */
    public TableResultResponse(String errorCode, String msg) {
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public TableResultResponse() {
        this.data = new TableData<T>();
    }

    TableResultResponse<T> total(int totalDataNum) {
        this.data.setTotalDataNum(totalDataNum);
        return this;
    }

    TableResultResponse<T> total(List<T> pageData) {
        this.data.setPageData(pageData);
        return this;
    }

    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
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

    class TableData<T> {

        /**
         * 当前页码
         */
        private int pageNo;

        /**
         * 每页条数
         */
        private int pageSize;

        /**
         * 总条数
         */
        private long totalDataNum;

        /**
         * 总页数
         */
        private int totalPageNum;

        /**
         * 当前页数据
         */
        private List<T> pageData;

        /**
         * 构造函数
         */
        public TableData() {
            pageNo = CommonConstant.DEFAULT_PAGE_NO;
            pageSize = CommonConstant.DEFAULT_PAGE_SIZE;
            totalDataNum = 0;
            totalPageNum = 0;
        }

        /**
         * 构造函数
         */
        public TableData(long totalDataNum, List<T> pageData) {
            this.totalDataNum = totalDataNum;
            this.pageData = pageData;
        }

        /**
         * 构造函数
         *
         * @param pageNo
         * @param pageSize
         * @param totalDataNum
         */
        public TableData(int pageNo, int pageSize, long totalDataNum) {
            this.pageNo = pageNo;
            this.pageSize = pageSize == 0 ? CommonConstant.DEFAULT_PAGE_SIZE : pageSize;
            this.totalDataNum = totalDataNum;
            this.totalPageNum = (int)((totalDataNum + pageSize - 1) / pageSize);
        }

        /**
         * 构造函数
         *
         * @param pageNo
         * @param pageSize
         * @param totalDataNum
         * @param pageData
         */
        public TableData(int pageNo, int pageSize, long totalDataNum, List<T> pageData) {
            this.pageNo = pageNo;
            this.pageSize = pageSize == 0 ? CommonConstant.DEFAULT_PAGE_SIZE : pageSize;
            this.totalDataNum = totalDataNum;
            this.totalPageNum = (int)((totalDataNum + pageSize - 1) / pageSize);
            this.pageData = pageData;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize == 0 ? CommonConstant.DEFAULT_PAGE_SIZE : pageSize;
            this.totalPageNum = (int) ((totalDataNum + pageSize - 1) / pageSize);
        }

        public void setTotalDataNum(long totalDataNum) {
            this.totalDataNum = totalDataNum;
            pageSize = this.pageSize == 0 ? CommonConstant.DEFAULT_PAGE_SIZE : this.pageSize;
            this.totalPageNum = (int) ((totalDataNum + pageSize - 1) / pageSize);
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public long getTotalDataNum() {
            return totalDataNum;
        }

        public int getTotalPageNum() {
            return totalPageNum;
        }

        public void setTotalPageNum(int totalPageNum) {
            this.totalPageNum = totalPageNum;
        }

        public List<T> getPageData() {
            return pageData;
        }

        public void setPageData(List<T> pageData) {
            this.pageData = pageData;
        }
    }
}
