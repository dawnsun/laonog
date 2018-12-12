package com.laonog.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.laonog.admin.facede.dto.DeptTree;
import com.laonog.admin.facede.entity.SysDept;
import com.laonog.admin.facede.entity.SysDeptRelation;
import com.laonog.admin.facede.vo.TreeUtil;
import com.laonog.admin.mapper.SysDeptMapper;
import com.laonog.admin.service.SysDeptRelationService;
import com.laonog.admin.service.SysDeptService;
import com.laonog.common.core.constant.CommonConstant;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 部门管理 服务实现类
 *
 */
@Service
@AllArgsConstructor
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {
	private final SysDeptRelationService sysDeptRelationService;

	/**
	 * 添加信息部门
	 *
	 * @param dept 部门
	 * @return
	 */
	@Override
	public Boolean insertDept(SysDept dept) {
		SysDept sysDept = new SysDept();
		BeanUtils.copyProperties(dept, sysDept);
		this.insert(sysDept);
		sysDeptRelationService.insertDeptRelation(sysDept);
		return Boolean.TRUE;
	}


	/**
	 * 删除部门
	 *
	 * @param id 部门 ID
	 * @return 成功、失败
	 */
	@Override
	public Boolean deleteDeptById(Integer id) {
		SysDept sysDept = new SysDept();
		sysDept.setDeptId(id);
		sysDept.setUpdateTime(LocalDateTime.now());
		sysDept.setDelFlag(CommonConstant.STATUS_DEL);
		this.deleteById(sysDept);
		sysDeptRelationService.deleteAllDeptRealtion(id);
		return Boolean.TRUE;
	}

	/**
	 * 更新部门
	 *
	 * @param sysDept 部门信息
	 * @return 成功、失败
	 */
	@Override
	public Boolean updateDeptById(SysDept sysDept) {
		//更新部门状态
		this.updateById(sysDept);
		//更新部门关系
		SysDeptRelation relation = new SysDeptRelation();
		relation.setAncestor(sysDept.getParentId());
		relation.setDescendant(sysDept.getDeptId());
		sysDeptRelationService.updateDeptRealtion(relation);
		return Boolean.TRUE;
	}

	/**
	 * 查询部门树
	 *
	 * @param sysDeptEntityWrapper
	 * @return 树
	 */
	@Override
	public List<DeptTree> selectListTree(EntityWrapper<SysDept> sysDeptEntityWrapper) {
		sysDeptEntityWrapper.orderBy("order_num", false);
		return getDeptTree(this.selectList(sysDeptEntityWrapper));
	}


	/**
	 * 构建部门树
	 *
	 * @param depts 部门
	 * @return
	 */
	private List<DeptTree> getDeptTree(List<SysDept> depts) {

		List<DeptTree> treeList = depts.stream()
			.filter(dept -> !dept.getDeptId().equals(dept.getParentId()))
			.map(dept -> {
				DeptTree node = new DeptTree();
				node.setId(dept.getDeptId());
				node.setParentId(dept.getParentId());
				node.setName(dept.getName());
				return node;
			}).collect(Collectors.toList());
		return TreeUtil.bulid(treeList, 0);
	}
}
