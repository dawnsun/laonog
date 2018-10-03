package com.laonog.common.util.exception;

/**
 * LaonogDeniedException
 * 403 授权拒绝
 */
public class LaonogDeniedException extends RuntimeException {

    public LaonogDeniedException() {
    }

    public LaonogDeniedException(String message) {
        super(message);
    }

    public LaonogDeniedException(Throwable cause) {
        super(cause);
    }

    public LaonogDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LaonogDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
