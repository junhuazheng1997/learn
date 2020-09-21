package com.junhuazheng.tree.util;

import com.junhuazheng.tree.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author kris
 * @since 2020-09-21
 */
public class TreeUtil {

    private static final List<TreeNode> list = new ArrayList<>();

    public static void printTree(TreeNode root) {
        list.clear();
        addElement(root);
        StringBuilder str = new StringBuilder().append("[");
        list.stream().map(x -> x.val).forEach(x -> str.append(x).append(","));
        System.out.println(str.delete(str.lastIndexOf(","), str.lastIndexOf(",") + 1).append("]").toString());
    }

    /**
     * 前序遍历添加元素
     * @param root
     */
    private static void addElement(TreeNode root) {
        if (null == root) return;
        list.add(root);
        addElement(root.left);
        addElement(root.right);
    }

}
