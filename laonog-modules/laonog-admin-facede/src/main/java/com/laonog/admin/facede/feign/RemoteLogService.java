package com.laonog.admin.facede.feign;

import com.laonog.admin.facede.entity.SysLog;
import com.laonog.admin.facede.feign.factory.RemoteLogServiceFallbackFactory;
import com.laonog.common.core.constant.ServiceNameConstant;
import com.laonog.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author lengleng
 * @date 2018/6/28
 */
@FeignClient(value = ServiceNameConstant.UMPS_SERVICE, fallbackFactory = RemoteLogServiceFallbackFactory.class)
public interface RemoteLogService {
	/**
	 * 保存日志
	 *
	 * @param sysLog 日志实体
	 * @return succes、false
	 */
	@PostMapping("/log")
	R<Boolean> saveLog(@RequestBody SysLog sysLog);
}
