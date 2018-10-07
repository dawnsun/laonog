package com.laonog.admin.service;


import com.laonog.admin.model.query.SysUserQuery;
import com.laonog.common.response.TableResultResponse;
import com.laonog.common.vo.SysUserVO;

import java.util.List;

/**
 * 
 *
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-09 18:45:59
 */
public interface SysUserService {

    /**
     * 新增
     * @param sysUserVO
     * @return
     */
    Boolean insertSysUser(SysUserVO sysUserVO);

    /**
     * 删除
     * @param sysUserVO
     * @return
     */
    Boolean deleteSysUser(SysUserVO sysUserVO);

    /**
     * 修改
     * @param sysUserVO
     * @return
     */
    Boolean updateSysUser(SysUserVO sysUserVO);

    /**
     * 查询单个
     * @param sysUserQuery
     * @return
     */
    SysUserVO getSysUser(SysUserQuery sysUserQuery);

    /**
     * 查询列表
     * @param sysUserQuery
     * @return
     */
    public List<SysUserVO> getSysUserList(SysUserQuery sysUserQuery);

    /**
     * 查询分页
     * @param sysUserQuery
     * @return
     */
    TableResultResponse<SysUserVO> getSysUserPage(SysUserQuery sysUserQuery);
}