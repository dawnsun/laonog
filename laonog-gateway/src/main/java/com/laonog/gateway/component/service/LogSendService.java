package com.laonog.gateway.component.service;

import com.netflix.zuul.context.RequestContext;

/**
 * 日志服务
 */
public interface LogSendService {
    /**
     * 往消息通道发消息
     *
     * @param requestContext requestContext
     */
    void send(RequestContext requestContext);
}
