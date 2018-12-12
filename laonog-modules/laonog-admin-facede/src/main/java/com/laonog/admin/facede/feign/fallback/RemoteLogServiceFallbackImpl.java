package com.laonog.admin.facede.feign.fallback;


import com.laonog.admin.facede.entity.SysLog;
import com.laonog.admin.facede.feign.RemoteLogService;
import com.laonog.common.core.util.R;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lengleng
 * @date 2018/6/26
 */
@Slf4j
@Component
public class RemoteLogServiceFallbackImpl implements RemoteLogService {
	@Setter
	private Throwable cause;

	/**
	 * 保存日志
	 *
	 * @param sysLog
	 * @return R
	 */
	@Override
	public R<Boolean> saveLog(SysLog sysLog) {
		log.error("feign 插入日志失败", cause);
		return null;
	}
}
