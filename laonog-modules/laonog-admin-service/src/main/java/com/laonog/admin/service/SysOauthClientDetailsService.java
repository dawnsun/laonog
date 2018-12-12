package com.laonog.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.laonog.admin.facede.entity.SysOauthClientDetails;

/**
 *
 * 服务类
 *
 */
public interface SysOauthClientDetailsService extends IService<SysOauthClientDetails> {

	/**
	 * 通过ID删除客户端
	 *
	 * @param id
	 * @return
	 */
	Boolean deleteClientDetailsById(String id);

	/**
	 * 根据客户端信息
	 *
	 * @param sysOauthClientDetails
	 * @return
	 */
	Boolean updateClientDetailsById(SysOauthClientDetails sysOauthClientDetails);
}
