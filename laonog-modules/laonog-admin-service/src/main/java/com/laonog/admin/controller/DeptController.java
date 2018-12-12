package com.laonog.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.laonog.admin.facede.dto.DeptTree;
import com.laonog.admin.facede.entity.SysDept;
import com.laonog.admin.service.SysDeptService;
import com.laonog.common.core.constant.CommonConstant;
import com.laonog.common.core.util.R;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * 部门管理 前端控制器
 *
 */
@RestController
@RequestMapping("/dept")
@AllArgsConstructor
public class DeptController {
	private final SysDeptService sysDeptService;

	/**
	 * 通过ID查询
	 *
	 * @param id ID
	 * @return SysDept
	 */
	@GetMapping("/{id}")
	public SysDept get(@PathVariable Integer id) {
		return sysDeptService.selectById(id);
	}


	/**
	 * 返回树形菜单集合
	 *
	 * @return 树形菜单
	 */
	@GetMapping(value = "/tree")
	public List<DeptTree> getTree() {
		SysDept condition = new SysDept();
		condition.setDelFlag(CommonConstant.STATUS_NORMAL);
		return sysDeptService.selectListTree(new EntityWrapper<>(condition));
	}

	/**
	 * 添加
	 *
	 * @param sysDept 实体
	 * @return success/false
	 */
	@PostMapping
	@PreAuthorize("@pms.hasPermission('sys_dept_add')")
	public R<Boolean> add(@Valid @RequestBody SysDept sysDept) {
		return new R<>(sysDeptService.insertDept(sysDept));
	}

	/**
	 * 删除
	 *
	 * @param id ID
	 * @return success/false
	 */
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('sys_dept_del')")
	public R<Boolean> delete(@PathVariable Integer id) {
		return new R<>(sysDeptService.deleteDeptById(id));
	}

	/**
	 * 编辑
	 *
	 * @param sysDept 实体
	 * @return success/false
	 */
	@PutMapping
	@PreAuthorize("@pms.hasPermission('sys_dept_edit')")
	public Boolean edit(@Valid @RequestBody SysDept sysDept) {
		sysDept.setUpdateTime(LocalDateTime.now());
		return sysDeptService.updateDeptById(sysDept);
	}
}
