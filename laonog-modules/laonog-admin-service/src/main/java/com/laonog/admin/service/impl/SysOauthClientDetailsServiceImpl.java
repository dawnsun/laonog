package com.laonog.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.laonog.admin.facede.entity.SysOauthClientDetails;
import com.laonog.admin.mapper.SysOauthClientDetailsMapper;
import com.laonog.admin.service.SysOauthClientDetailsService;
import com.laonog.common.core.constant.SecurityConstants;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 *
 * 服务实现类
 *
 */
@Service
public class SysOauthClientDetailsServiceImpl extends ServiceImpl<SysOauthClientDetailsMapper, SysOauthClientDetails> implements SysOauthClientDetailsService {

	/**
	 * 通过ID删除客户端
	 *
	 * @param id
	 * @return
	 */
	@Override
	@CacheEvict(value = SecurityConstants.CLIENT_DETAILS_KEY, key = "#id")
	public Boolean deleteClientDetailsById(String id) {
		return this.deleteById(id);
	}

	/**
	 * 根据客户端信息
	 *
	 * @param clientDetails
	 * @return
	 */
	@Override
	@CacheEvict(value = SecurityConstants.CLIENT_DETAILS_KEY, key = "#clientDetails.clientId")
	public Boolean updateClientDetailsById(SysOauthClientDetails clientDetails) {
		return this.updateById(clientDetails);
	}
}
