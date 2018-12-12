package com.laonog.common.log.event;

import com.laonog.admin.facede.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 *
 * 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

	public SysLogEvent(SysLog source) {
		super(source);
	}
}
