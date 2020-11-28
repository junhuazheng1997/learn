package com.junhuazheng.tree.simple.convertGreaterTree;

import com.junhuazheng.tree.pojo.TreeNode;
import com.junhuazheng.tree.util.TreeUtil;

/**
 * 二叉搜索树转换累加树
 *
 * @author kris
 * @since 2020-09-21
 */
public class ConvertGreaterTree02 {

    private static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;

        TreeNode result = execute(root);
        TreeUtil.printTree(result);
    }


    // 反序中序遍历
    public static TreeNode execute(TreeNode root) {
        if (null == root) return root;
        execute(root.right);
        sum += root.val;
        root.val = sum;
        execute(root.left);
        return root;
    }

}
