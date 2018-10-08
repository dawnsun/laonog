package com.laonog.admin.service;

import com.laonog.common.entity.SysLog;
import com.laonog.common.response.TableResultResponse;

public interface SysLogService {
    /**
     * 新增
     * @param sysLog
     * @return
     */
    Boolean insertSysLog(SysLog sysLog);

    /**
     * 删除
     * @param sysLog
     * @return
     */
    Boolean deleteSysLog(SysLog sysLog);

    /**
     * 修改
     * @param sysLog
     * @return
     */
    Boolean updateSysLog(SysLog sysLog);


    /**
     * 查询分页
     * @param sysLog
     * @return
     */
    TableResultResponse<SysLog> getSysLogPage(SysLog sysLog);
}
