package com.laonog.admin.mapper;

import com.laonog.admin.model.entity.SysUserDO;
import com.laonog.admin.model.query.SysUserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    /**
     * 新增
     * @param sysUserDODO
     * @return
     */
    Long insertSysUser(SysUserDO sysUserDODO);

    /**
     * 删除
     * @param sysUserDODO
     * @return
     */
    Integer deleteSysUser(SysUserDO sysUserDODO);

    /**
     * 修改
     * @param sysUserDODO
     * @return
     */
    Integer updateSysUser(SysUserDO sysUserDODO);

    /**
     * 查询单个
     * @param sysUserQuery
     * @return
     */
    SysUserDO getSysUser(SysUserQuery sysUserQuery);

    /**
     * 查询数量
     * @param sysUserQuery
     * @return
     */
    Long getSysUserCount(SysUserQuery sysUserQuery);

    /**
     * 查询列表
     * @param sysUserQuery
     * @return
     */
    List<SysUserDO> getSysUserList(SysUserQuery sysUserQuery);

    /**
     * 查询分页
     * @param sysUserQuery
     * @return
     */
    List<SysUserDO> getSysUserPage(SysUserQuery sysUserQuery);
}
