package com.laonog.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.laonog.admin.facede.entity.SysRoleMenu;

/**
 *
 * 角色菜单表 服务类
 *
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

	/**
	 * 更新角色菜单
	 *
	 * @param role
	 * @param roleId  角色
	 * @param menuIds 菜单ID拼成的字符串，每个id之间根据逗号分隔
	 * @return
	 */
	Boolean insertRoleMenus(String role, Integer roleId, String menuIds);
}
