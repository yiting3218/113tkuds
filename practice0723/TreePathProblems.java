package practice0723;

import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void printAllPaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        System.out.println("所有根到葉的路徑：");
        dfsPrintPaths(root, path);
    }

    private static void dfsPrintPaths(TreeNode node, List<Integer> path) {
        if (node == null) return;

        path.add(node.data);

        if (node.left == null && node.right == null) {
            System.out.println(path);
        } else {
            dfsPrintPaths(node.left, path);
            dfsPrintPaths(node.right, path);
        }

        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.data == targetSum;
        }

        int remaining = targetSum - root.data;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }

    public static int maxPathSum(TreeNode root) {
        return maxPathHelper(root).maxSum;
    }

    private static class PathInfo {
        int maxSum;
        List<Integer> path;

        public PathInfo(int sum, List<Integer> path) {
            this.maxSum = sum;
            this.path = path;
        }
    }

    private static PathInfo maxPathHelper(TreeNode node) {
        if (node == null) return new PathInfo(0, new ArrayList<>());

        PathInfo left = maxPathHelper(node.left);
        PathInfo right = maxPathHelper(node.right);

        if (left.maxSum > right.maxSum) {
            left.path.add(0, node.data);
            return new PathInfo(left.maxSum + node.data, left.path);
        } else {
            right.path.add(0, node.data);
            return new PathInfo(right.maxSum + node.data, right.path);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        printAllPaths(root);

        int target = 22;
        System.out.println("是否存在總和為 " + target + " 的路徑: " + hasPathSum(root, target));

        PathInfo maxPath = maxPathHelper(root);
        System.out.println("最大總和: " + maxPath.maxSum);
        System.out.println("最大總和路徑: " + maxPath.path);
    }
}
