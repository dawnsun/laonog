package com.laonog.admin.model.entity;


import lombok.Data;

import java.io.Serializable;

/**
 *
 * 用户角色表
 *
 */
@Data
public class SysUserRoleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	private Integer userId;
    /**
     * 角色ID
     */
	private Integer roleId;

	@Override
	public String toString() {
		return "SysUserRoleDO{" +
			", userId=" + userId +
			", roleId=" + roleId +
			"}";
	}
}
