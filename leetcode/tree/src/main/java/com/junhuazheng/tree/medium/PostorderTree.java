package com.junhuazheng.tree.medium;

import com.junhuazheng.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后续遍历二叉树
 * 例:
 * 输入 [1, null, 2, 3]
 * 输出 [3, 2, 1]
 */
public class PostorderTree {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == list) return list;
        return execute(root, list);
    }


    public static List<Integer> execute(TreeNode root, List<Integer> list) {
        if (null == root) return list;
        execute(root.left, list);
        execute(root.right, list);
        list.add(root.val);
        return list;
    }
}
