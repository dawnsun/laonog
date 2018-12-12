package com.laonog.admin.facede.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeNode
 */
@Data
public class TreeNode {
	protected int id;
	protected int parentId;
	protected List<TreeNode> children = new ArrayList<TreeNode>();

	public void add(TreeNode node) {
		children.add(node);
	}
}
