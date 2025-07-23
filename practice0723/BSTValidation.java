package practice0723;

import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validate(node.left, min, node.data) &&
               validate(node.right, node.data, max);
    }

    public static List<TreeNode> findViolations(TreeNode root) {
        List<TreeNode> violations = new ArrayList<>();
        inOrderCheck(root, new TreeNodeWrapper(null), violations);
        return violations;
    }

    private static class TreeNodeWrapper {
        TreeNode prev;

        TreeNodeWrapper(TreeNode prev) {
            this.prev = prev;
        }
    }

    private static void inOrderCheck(TreeNode node, TreeNodeWrapper prev, List<TreeNode> violations) {
        if (node == null) return;

        inOrderCheck(node.left, prev, violations);

        if (prev.prev != null && node.data <= prev.prev.data) {
            violations.add(node);
        }

        prev.prev = node;
        inOrderCheck(node.right, prev, violations);
    }

    public static int minRemovalsToBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        buildInOrder(root, inorder);

        int lis = lengthOfLIS(inorder);
        return inorder.size() - lis;
    }

    private static void buildInOrder(TreeNode root, List<Integer> inorder) {
        if (root != null) {
            buildInOrder(root.left, inorder);
            inorder.add(root.data);
            buildInOrder(root.right, inorder);
        }
    }

    private static int lengthOfLIS(List<Integer> nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(dp, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == dp.size()) dp.add(num);
            else dp.set(idx, num);
        }
        return dp.size();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(12); 
        root.right.right = new TreeNode(20);

        System.out.println("是否為合法BST: " + isValidBST(root));

        List<TreeNode> violations = findViolations(root);
        System.out.print("違規節點值: ");
        for (TreeNode node : violations) {
            System.out.print(node.data + " ");
        }
        System.out.println();

        int removals = minRemovalsToBST(root);
        System.out.println("最少需要移除的節點數: " + removals);
    }
}
