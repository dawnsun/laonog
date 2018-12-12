package com.laonog.common.security.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 自定义OAuth2Exception
 */
public class PigxAuth2Exception extends OAuth2Exception {

	public PigxAuth2Exception(String msg) {
		super(msg);
	}
}
