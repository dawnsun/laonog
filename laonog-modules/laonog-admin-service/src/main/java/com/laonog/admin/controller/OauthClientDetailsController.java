package com.laonog.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.laonog.admin.facede.entity.SysOauthClientDetails;
import com.laonog.admin.service.SysOauthClientDetailsService;
import com.laonog.common.core.util.Query;
import com.laonog.common.core.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 *
 * 前端控制器
 *
 */
@RestController
@RequestMapping("/client")
public class OauthClientDetailsController {
	@Autowired
	private SysOauthClientDetailsService sysOauthClientDetailsService;

	/**
	 * 通过ID查询
	 *
	 * @param id ID
	 * @return SysOauthClientDetails
	 */
	@GetMapping("/{id}")
	public SysOauthClientDetails get(@PathVariable Integer id) {
		return sysOauthClientDetailsService.selectById(id);
	}


	/**
	 * 分页查询信息
	 *
	 * @param params 分页对象
	 * @return 分页对象
	 */
	@GetMapping("/page")
	public Page page(@RequestParam Map<String, Object> params) {
		return sysOauthClientDetailsService.selectPage(new Query<>(params), new EntityWrapper<>());
	}

	/**
	 * 添加
	 *
	 * @param sysOauthClientDetails 实体
	 * @return success/false
	 */
	@PostMapping
	@PreAuthorize("@pms.hasPermission('sys_client_add')")
	public R<Boolean> add(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
		return new R<>(sysOauthClientDetailsService.insert(sysOauthClientDetails));
	}

	/**
	 * 删除
	 *
	 * @param id ID
	 * @return success/false
	 */
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('sys_client_del')")
	public R<Boolean> delete(@PathVariable String id) {
		return new R<>(sysOauthClientDetailsService.deleteClientDetailsById(id));
	}

	/**
	 * 编辑
	 *
	 * @param sysOauthClientDetails 实体
	 * @return success/false
	 */
	@PutMapping
	@PreAuthorize("@pms.hasPermission('sys_client_edit')")
	public R<Boolean> edit(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
		return new R<>(sysOauthClientDetailsService.updateClientDetailsById(sysOauthClientDetails));
	}
}
