package practice0723;

import java.util.*;

public class TreeLevelTraversal {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    level.addLast(node.data);
                } else {
                    level.addFirst(node.data);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void printLastNodesPerLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode last = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                last = node;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (last != null) {
                System.out.println("這層最後一個節點: " + last.data);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("=== 每層節點（之字形） ===");
        List<List<Integer>> levels = zigzagLevelOrder(root);
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("第 " + (i + 1) + " 層: " + levels.get(i));
        }

        System.out.println("\n=== 每層最後一個節點 ===");
        printLastNodesPerLevel(root);
    }
}
