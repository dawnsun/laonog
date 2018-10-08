package com.laonog.admin.mapper;

import com.laonog.admin.model.entity.SysUser;
import com.laonog.admin.model.query.SysUserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    /**
     * 新增
     * @param sysUserDO
     * @return
     */
    Long insertSysUser(SysUser sysUserDO);

    /**
     * 删除
     * @param sysUserDO
     * @return
     */
    Integer deleteSysUser(SysUser sysUserDO);

    /**
     * 修改
     * @param sysUserDO
     * @return
     */
    Integer updateSysUser(SysUser sysUserDO);

    /**
     * 查询单个
     * @param sysUserQuery
     * @return
     */
    SysUser getSysUser(SysUserQuery sysUserQuery);

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
    List<SysUser> getSysUserList(SysUserQuery sysUserQuery);

    /**
     * 查询分页
     * @param sysUserQuery
     * @return
     */
    List<SysUser> getSysUserPage(SysUserQuery sysUserQuery);
}
