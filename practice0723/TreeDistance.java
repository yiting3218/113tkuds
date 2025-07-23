package practice0723;

import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 計算兩個節點的距離
    public static int distanceBetween(TreeNode root, int val1, int val2) {
        TreeNode lca = findLCA(root, val1, val2);
        return depthFrom(lca, val1, 0) + depthFrom(lca, val2, 0);
    }

    // 找 LCA（最低共同祖先）
    private static TreeNode findLCA(TreeNode node, int val1, int val2) {
        if (node == null) return null;
        if (node.data == val1 || node.data == val2) return node;

        TreeNode left = findLCA(node.left, val1, val2);
        TreeNode right = findLCA(node.right, val1, val2);

        if (left != null && right != null) return node;
        return (left != null) ? left : right;
    }

    // 計算從某節點到目標值的深度
    private static int depthFrom(TreeNode node, int target, int depth) {
        if (node == null) return -1;
        if (node.data == target) return depth;

        int left = depthFrom(node.left, target, depth + 1);
        if (left != -1) return left;

        return depthFrom(node.right, target, depth + 1);
    }

    // 計算樹的直徑（任意兩點間最大距離）
    static class DiameterResult {
        int diameter = 0;
    }

    public static int findDiameter(TreeNode root) {
        DiameterResult result = new DiameterResult();
        depthAndUpdateDiameter(root, result);
        return result.diameter;
    }

    private static int depthAndUpdateDiameter(TreeNode node, DiameterResult result) {
        if (node == null) return 0;

        int leftDepth = depthAndUpdateDiameter(node.left, result);
        int rightDepth = depthAndUpdateDiameter(node.right, result);

        result.diameter = Math.max(result.diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 找出距離根節點距離為 k 的所有節點
    public static List<Integer> findNodesAtDistanceK(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        dfsFindDistance(root, 0, k, result);
        return result;
    }

    private static void dfsFindDistance(TreeNode node, int currentDepth, int targetDepth, List<Integer> result) {
        if (node == null) return;
        if (currentDepth == targetDepth) {
            result.add(node.data);
            return;
        }
        dfsFindDistance(node.left, currentDepth + 1, targetDepth, result);
        dfsFindDistance(node.right, currentDepth + 1, targetDepth, result);
    }

    // 測試用 main
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println("節點 7 和 5 之間的距離: " + distanceBetween(root, 7, 5)); // 4
        System.out.println("節點 4 和 6 之間的距離: " + distanceBetween(root, 4, 6)); // 4

        System.out.println("樹的直徑: " + findDiameter(root)); 

        System.out.println("距離根節點距離為 2 的節點有: " + findNodesAtDistanceK(root, 2)); // [4,5,6]
    }
}
