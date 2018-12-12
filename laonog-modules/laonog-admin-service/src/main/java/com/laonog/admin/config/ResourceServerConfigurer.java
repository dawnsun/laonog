package com.laonog.admin.config;

import com.laonog.common.security.component.BaseResourceServerConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * ResourceServerConfigurer
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfigurer extends BaseResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/actuator/**"
				, "/user/info/*"
				, "/social/info/**"
				, "/log/**"
				, "/v2/api-docs").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable();
	}


}
