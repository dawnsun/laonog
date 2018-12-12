package com.laonog.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.laonog.admin.facede.entity.SysDept;
import com.laonog.admin.facede.entity.SysDeptRelation;

/**
 *
 * 服务类
 *
 */
public interface SysDeptRelationService extends IService<SysDeptRelation> {

	/**
	 * 新建部门关系
	 *
	 * @param sysDept 部门
	 */
	void insertDeptRelation(SysDept sysDept);

	/**
	 * 通过ID删除部门关系
	 *
	 * @param id
	 */
	void deleteAllDeptRealtion(Integer id);

	/**
	 * 更新部门关系
	 *
	 * @param relation
	 */
	void updateDeptRealtion(SysDeptRelation relation);
}
