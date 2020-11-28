package com.junhuazheng.tree.simple.convertGreaterTree;

import com.junhuazheng.tree.pojo.TreeNode;

/**
 * 使用Morris遍历解决二叉搜索树转换为累加树
 *
 * Morris遍历的核心思想是利用树的空闲指针，实现空间开销的缩减
 *
 * 个人理解：
 * 举个例子
 * 当仅使用一个节点的右节点指针进行遍历时，那么左节点指针就是空闲的
 * 利用这个空闲指针进行算法的实现，可以极大地减少空间开销
 *
 * @author kris
 * @since 2020-09-21
 */
public class ConvertGreaterTreeMorris {

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left; // 返回当前根节点
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node; // 空闲指针指向当前根
                    node = node.right;
                } else {
                    succ.left = null; // 清除无效(使用过)引用 恢复树结构
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }

}
