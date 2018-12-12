package com.laonog.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.laonog.admin.facede.entity.SysDept;
import com.laonog.admin.facede.entity.SysDeptRelation;
import com.laonog.admin.mapper.SysDeptRelationMapper;
import com.laonog.admin.service.SysDeptRelationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 服务实现类
 *
 */
@Service
@AllArgsConstructor
public class SysDeptRelationServiceImpl extends ServiceImpl<SysDeptRelationMapper, SysDeptRelation> implements SysDeptRelationService {
	private final SysDeptRelationMapper sysDeptRelationMapper;

	/**
	 * 维护部门关系
	 *
	 * @param sysDept 部门
	 */
	@Override
	public void insertDeptRelation(SysDept sysDept) {
		//增加部门关系表
		SysDeptRelation condition = new SysDeptRelation();
		condition.setDescendant(sysDept.getParentId());
		List<SysDeptRelation> relationList = sysDeptRelationMapper
			.selectList(new EntityWrapper<>(condition))
			.stream().map(relation -> {
				relation.setDescendant(sysDept.getDeptId());
				return relation;
			}).collect(Collectors.toList());
		this.insertBatch(relationList);

		//自己也要维护到关系表中
		SysDeptRelation own = new SysDeptRelation();
		own.setDescendant(sysDept.getDeptId());
		own.setAncestor(sysDept.getDeptId());
		sysDeptRelationMapper.insert(own);
	}

	/**
	 * 通过ID删除部门关系
	 *
	 * @param id
	 */
	@Override
	public void deleteAllDeptRealtion(Integer id) {
		baseMapper.deleteAllDeptRealtion(id);
	}

	/**
	 * 更新部门关系
	 *
	 * @param relation
	 */
	@Override
	public void updateDeptRealtion(SysDeptRelation relation) {
		baseMapper.updateDeptRealtion(relation);
	}

}
