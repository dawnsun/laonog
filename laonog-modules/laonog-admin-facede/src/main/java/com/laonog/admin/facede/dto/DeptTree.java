package com.laonog.admin.facede.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门树
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends TreeNode {
	private String name;
}
