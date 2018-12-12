package com.laonog.common.core.constant;

/**
 *
 * 服务名称
 */
public interface ServiceNameConstant {
	/**
	 * 认证服务的SERVICEID（zuul 配置的对应）
	 */
	String AUTH_SERVICE = "laonog-auth";

	/**
	 * UMPS模块
	 */
	String UMPS_SERVICE = "laonog-admin";

	/**
	 * 分布式事务协调服务
	 */
	String  TX_MANAGER = "laonog-tx-manager";
}
