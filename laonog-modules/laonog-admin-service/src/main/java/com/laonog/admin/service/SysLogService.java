package com.laonog.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.laonog.admin.facede.entity.SysLog;
import com.laonog.admin.facede.vo.PreLogVo;

import java.util.List;

/**
 *
 * 日志表 服务类
 *
 */
public interface SysLogService extends IService<SysLog> {

	/**
	 * 通过ID删除日志（逻辑删除）
	 *
	 * @param id 日志ID
	 * @return true/false
	 */
	Boolean updateByLogId(Long id);

	/**
	 * 批量插入前端错误日志
	 *
	 * @param preLogVoList 日志信息
	 * @return true/false
	 */
	Boolean insertLogs(List<PreLogVo> preLogVoList);
}
