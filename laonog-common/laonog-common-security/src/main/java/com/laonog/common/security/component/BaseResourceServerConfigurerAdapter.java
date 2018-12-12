package com.laonog.common.security.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.client.RestTemplate;

/**
 *
 * <p>
 * 1. 支持remoteTokenServices 负载均衡
 * 2. 支持 获取用户全部信息
 */
public abstract class BaseResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {
	@Autowired
	protected ResourceAuthExceptionEntryPoint resourceAuthExceptionEntryPoint;
	@Autowired
	protected PigAccessDeniedHandler pigAccessDeniedHandler;
	@Autowired
	protected RemoteTokenServices remoteTokenServices;
	@Autowired
	protected UserDetailsService userDetailsService;


	/**
	 * 默认的配置，对外暴露
	 *
	 * @param http
	 * @throws Exception
	 */
	@Override
	public abstract void configure(HttpSecurity http) throws Exception;

	/**
	 * 提供子类重写
	 * <p>
	 * 1. 不重写，默认支持获取雍熙
	 * 2. 重写notGetUser，提供性能
	 * <p>
	 * see codegen ResourceServerConfigurer
	 *
	 * @param resources
	 */
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		canGetUser(resources);
	}

	@Bean
	@LoadBalanced
	public RestTemplate lbRestTemplate() {
		return new RestTemplate();
	}


	/**
	 * 不获取用户详细 只有用户名
	 *
	 * @param resources
	 */
	protected void notGetUser(ResourceServerSecurityConfigurer resources) {
		DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
		DefaultUserAuthenticationConverter userTokenConverter = new DefaultUserAuthenticationConverter();
		accessTokenConverter.setUserTokenConverter(userTokenConverter);

		remoteTokenServices.setRestTemplate(lbRestTemplate());
		remoteTokenServices.setAccessTokenConverter(accessTokenConverter);
		resources.authenticationEntryPoint(resourceAuthExceptionEntryPoint)
			.accessDeniedHandler(pigAccessDeniedHandler)
			.tokenServices(remoteTokenServices);
	}


	/**
	 * 上下文中获取用户全部信息，两次调用userDetailsService，影响性能
	 *
	 * @param resources
	 */
	private void canGetUser(ResourceServerSecurityConfigurer resources) {
		DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
		DefaultUserAuthenticationConverter userTokenConverter = new DefaultUserAuthenticationConverter();
		userTokenConverter.setUserDetailsService(userDetailsService);
		accessTokenConverter.setUserTokenConverter(userTokenConverter);

		remoteTokenServices.setRestTemplate(lbRestTemplate());
		remoteTokenServices.setAccessTokenConverter(accessTokenConverter);
		resources.authenticationEntryPoint(resourceAuthExceptionEntryPoint)
			.accessDeniedHandler(pigAccessDeniedHandler)
			.tokenServices(remoteTokenServices);
	}

}
