package com.laonog.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.laonog.admin.facede.entity.SysUserRole;
import com.laonog.admin.mapper.SysUserRoleMapper;
import com.laonog.admin.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 *
 * 用户角色表 服务实现类
 *
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

	/**
	 * 根据用户Id删除该用户的角色关系
	 *
	 * @param userId 用户ID
	 * @return boolean
	 *
	 */
	@Override
	public Boolean deleteByUserId(Integer userId) {
		return baseMapper.deleteByUserId(userId);
	}
}
