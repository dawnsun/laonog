package com.laonog.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.laonog.admin.facede.entity.SysLog;
import com.laonog.admin.facede.vo.PreLogVo;
import com.laonog.admin.mapper.SysLogMapper;
import com.laonog.admin.service.SysLogService;
import com.laonog.common.core.constant.CommonConstant;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 日志表 服务实现类
 *
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

	@Override
	public Boolean updateByLogId(Long id) {

		SysLog sysLog = new SysLog();
		sysLog.setId(id);
		sysLog.setDelFlag(CommonConstant.STATUS_DEL);
		sysLog.setUpdateTime(LocalDateTime.now());
		return updateById(sysLog);
	}

	/**
	 * 批量插入前端错误日志
	 *
	 * @param preLogVoList 日志信息
	 * @return true/false
	 */
	@Override
	public Boolean insertLogs(List<PreLogVo> preLogVoList) {
		List<SysLog> sysLogList = preLogVoList.stream()
			.map(pre -> {
				SysLog log = new SysLog();
				log.setType(CommonConstant.STATUS_LOCK);
				log.setTitle(pre.getInfo());
				log.setException(pre.getStack());
				log.setParams(pre.getMessage());
				log.setCreateTime(LocalDateTime.now());
				log.setRequestUri(pre.getUrl());
				log.setCreateBy(pre.getUser());
				return log;
			}).collect(Collectors.toList());
		return this.insertBatch(sysLogList);
	}
}
