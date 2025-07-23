package practice0723;

import java.util.ArrayList;

public class BSTRangeQuery {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void rangeQuery(TreeNode root, int min, int max, ArrayList<Integer> result) {
        if (root == null) return;

        if (root.data > min) {
            rangeQuery(root.left, min, max, result);
        }

        if (root.data >= min && root.data <= max) {
            result.add(root.data);
        }

        if (root.data < max) {
            rangeQuery(root.right, min, max, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int val : values) {
            root = insert(root, val);
        }

        int min = 12;
        int max = 27;
        ArrayList<Integer> result = new ArrayList<>();
        rangeQuery(root, min, max, result);

        System.out.println("範圍 [" + min + ", " + max + "] 查詢結果: " + result);
    }
}
