package com.laonog.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.laonog.admin.facede.entity.SysDeptRelation;

/**
 *
 * Mapper 接口
 *
 */
public interface SysDeptRelationMapper extends BaseMapper<SysDeptRelation> {
	/**
	 * 删除部门关系表数据
	 *
	 * @param id 部门ID
	 */
	void deleteAllDeptRealtion(Integer id);

	/**
	 * 更改部分关系表数据
	 *
	 * @param deptRelation
	 */
	void updateDeptRealtion(SysDeptRelation deptRelation);
}
