package com.junhuazheng.tree.simple.convertGreaterTree;

import com.junhuazheng.tree.pojo.TreeNode;
import com.junhuazheng.tree.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个二叉树，把他转换为累加树，使得每个节点的值是原来的节点值加上所有大于它的节点值之和
 *
 * 暴力解法；递归遍历将节点放入list，再双层遍历赋值
 * @author kris
 * @since 2020-09-21
 */
public class ConvertGreaterTree01 {

    private static final List<TreeNode> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(13);
        root.left = l;
        root.right = r;

        TreeNode result = execute(root);
        TreeUtil.printTree(result);
    }

    public static TreeNode execute(TreeNode root) {
        if (null == root) return root;
        list.clear();
        addElement(root);
        List<Integer> vals = list.stream().map(x -> x.val).collect(Collectors.toList());
        list.stream().forEach(x -> {
            int tmp = x.val;
            tmp += vals.stream().filter(y -> y > x.val).mapToInt(y -> y).sum();
            x.val = tmp;
        });
        return root;
    }

    private static void addElement(TreeNode node) {
        if (null == node) return;
        list.add(node);
        addElement(node.left);
        addElement(node.right);
    }

}
