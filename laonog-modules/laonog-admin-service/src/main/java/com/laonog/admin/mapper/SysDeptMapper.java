package com.laonog.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.laonog.admin.facede.entity.SysDept;

import java.util.List;

/**
 *
 * 部门管理 Mapper 接口
 *
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

	/**
	 * 关联dept——relation
	 *
	 * @param delFlag 删除标记
	 * @return 数据列表
	 */
	List<SysDept> selectDeptDtoList(String delFlag);
}
