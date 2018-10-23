package com.laonog.admin.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点树
 */
@Data
public class TreeNode {
    protected long id;
    protected long parentId;
    protected List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
