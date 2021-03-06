package com.laonog.common.security.exception;

import org.springframework.http.HttpStatus;

/**
 * ServerErrorException
 */
public class ServerErrorException extends PigxAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
