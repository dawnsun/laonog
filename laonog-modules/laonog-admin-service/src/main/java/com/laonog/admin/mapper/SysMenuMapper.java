package com.laonog.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.laonog.admin.facede.entity.SysMenu;
import com.laonog.admin.facede.vo.MenuVO;

import java.util.List;

/**
 *
 * 菜单权限表 Mapper 接口
 *
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

	/**
	 * 通过角色编号查询菜单
	 *
	 * @param role 角色编号
	 * @return
	 */
	List<MenuVO> findMenuByRoleCode(String role);

	/**
	 * 通过角色ID查询权限
	 *
	 * @param roleIds Ids
	 * @return
	 */
	List<String> findPermissionsByRoleIds(String roleIds);
}
