package com.laonog.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.laonog.admin.facede.entity.SysMenu;
import com.laonog.admin.facede.vo.MenuVO;

import java.util.List;

/**
 *
 * 菜单权限表 服务类
 *
 */
public interface SysMenuService extends IService<SysMenu> {
	/**
	 * 通过角色编号查询URL 权限
	 *
	 * @param role 角色编号
	 * @return 菜单列表
	 */
	List<MenuVO> findMenuByRoleCode(String role);

	/**
	 * 级联删除菜单
	 *
	 * @param id 菜单ID
	 * @return 成功、失败
	 */
	Boolean deleteMenu(Integer id);

	/**
	 * 更新菜单信息
	 *
	 * @param sysMenu 菜单信息
	 * @return 成功、失败
	 */
	Boolean updateMenuById(SysMenu sysMenu);
}
