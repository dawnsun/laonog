package com.laonog.common.security.exception;

import org.springframework.http.HttpStatus;

/**
 * UnauthorizedException
 */
public class UnauthorizedException extends PigxAuth2Exception {

	public UnauthorizedException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "unauthorized";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.UNAUTHORIZED.value();
	}

}
