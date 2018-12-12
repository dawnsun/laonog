package com.laonog.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.laonog.admin.facede.dto.UserInfo;
import com.laonog.admin.facede.entity.SysSocialDetails;
import com.laonog.admin.service.SysSocialDetailsService;
import com.laonog.admin.service.SysUserService;
import com.laonog.common.core.util.Query;
import com.laonog.common.core.util.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


/**
 * 系统社交登录账号表
 *
 */
@RestController
@RequestMapping("/social")
@AllArgsConstructor
public class SysSocialDetailsController {
	private final SysUserService sysUserService;
	private final SysSocialDetailsService sysSocialDetailsService;


	/**
	 * 列表
	 *
	 * @param params
	 * @return
	 */
	@GetMapping("/page")
	public Page page(@RequestParam Map<String, Object> params) {
		return sysSocialDetailsService.selectPage(new Query<>(params), new EntityWrapper<>());
	}


	/**
	 * 信息
	 *
	 * @param id
	 * @return R
	 */
	@GetMapping("/{id}")
	public R info(@PathVariable("id") Integer id) {
		SysSocialDetails sysSocialDetails = sysSocialDetailsService.selectById(id);
		return new R<>(sysSocialDetails);
	}

	/**
	 * 保存
	 *
	 * @param sysSocialDetails
	 * @return R
	 */
	@PostMapping
	public R save(@Valid @RequestBody SysSocialDetails sysSocialDetails) {
		sysSocialDetailsService.insert(sysSocialDetails);
		return new R<>(Boolean.TRUE);
	}

	/**
	 * 修改
	 *
	 * @param sysSocialDetails
	 * @return R
	 */
	@PutMapping
	public R update(@Valid @RequestBody SysSocialDetails sysSocialDetails) {
		sysSocialDetailsService.updateById(sysSocialDetails);
		return new R<>(Boolean.TRUE);
	}

	/**
	 * 删除
	 *
	 * @param id
	 * @return R
	 */
	@DeleteMapping("/{id}")
	public R delete(@PathVariable Integer id) {
		return new R<>(sysSocialDetailsService.deleteById(id));
	}

	/**
	 * 通过社交账号查询用户、角色信息
	 *
	 * @param inStr appid@code
	 * @return
	 */
	@GetMapping("/info/{inStr}")
	public R<UserInfo> social(@PathVariable String inStr) {
		Map<String, String> result = sysSocialDetailsService.findOpenId(inStr);
		return new R<>(sysUserService.findUserInfo(result.get("type"), result.get("openId")));
	}

	/**
	 * 绑定社交账号
	 *
	 * @param state 类型
	 * @param code  code
	 * @return
	 */
	@PostMapping("/bind")
	public R<Boolean> bind(String state, String code) {
		return new R<>(sysSocialDetailsService.bindSocial(state, code));
	}
}
