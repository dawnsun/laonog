package com.laonog.admin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.laonog.admin.facede.entity.SysLog;
import com.laonog.admin.facede.vo.PreLogVo;
import com.laonog.admin.service.SysLogService;
import com.laonog.common.core.util.Query;
import com.laonog.common.core.util.R;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 *
 * 日志表 前端控制器
 *
 */
@RestController
@RequestMapping("/log")
@AllArgsConstructor
public class LogController {
	private final SysLogService sysLogService;

	/**
	 * 分页查询日志信息
	 *
	 * @param params 分页对象
	 * @return 分页对象
	 */
	@GetMapping("/logPage")
	public Page logPage(@RequestParam Map<String, Object> params) {
		return sysLogService.selectPage(new Query<>(params), new EntityWrapper<>());
	}

	/**
	 * 根据ID
	 *
	 * @param id ID
	 * @return success/false
	 */
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('sys_log_del')")
	public R<Boolean> delete(@PathVariable Long id) {
		return new R<>(sysLogService.updateByLogId(id));
	}

	/**
	 * 插入日志
	 *
	 * @param sysLog 日志实体
	 * @return success/false
	 */
	@PostMapping
	public R<Boolean> save(@Valid @RequestBody SysLog sysLog) {
		return new R<>(sysLogService.insert(sysLog));
	}

	/**
	 * 插入前端异常日志
	 *
	 * @param preLogVoList 日志实体
	 * @return success/false
	 */
	@PostMapping("/logs")
	public R<Boolean> saveLogs(@RequestBody List<PreLogVo> preLogVoList) {
		return new R<>(sysLogService.insertLogs(preLogVoList));
	}
}
