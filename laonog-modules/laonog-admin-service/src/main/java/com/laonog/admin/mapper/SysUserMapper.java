package com.laonog.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.laonog.admin.facede.entity.SysUser;
import com.laonog.admin.facede.vo.UserVO;
import com.laonog.common.core.datascope.DataScope;
import com.laonog.common.core.util.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 用户表 Mapper 接口
 *
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
	/**
	 * 通过用户名查询用户信息（含有角色信息）
	 *
	 * @param username 用户名
	 * @return userVo
	 */
	UserVO selectUserVoByUsername(String username);

	/**
	 * 分页查询用户信息（含角色）
	 *
	 * @param query     查询条件
	 * @param username  用户名
	 * @param dataScope
	 * @return list
	 */
	List selectUserVoPage(Query query, @Param("username") Object username, DataScope dataScope);

	/**
	 * 通过ID查询用户信息
	 *
	 * @param id 用户ID
	 * @return userVo
	 */
	UserVO selectUserVoById(Integer id);

	/**
	 * 通过用户名查找已经删除的用户
	 *
	 * @param username 用户名
	 * @return 用户对象
	 */
	SysUser selectDeletedUserByUsername(@Param("username") String username);

	/**
	 * 根据用户名删除用户（真实删除）
	 *
	 * @param username username
	 * @param userId   userId
	 * @return
	 */
	Boolean deleteSysUserByUsernameAndUserId(@Param("username") String username, @Param("userId") Integer userId);

}
