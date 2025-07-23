package practice0723;

public class TreeStatistics {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    public static int findMin(TreeNode root) {
        if (root == null) throw new RuntimeException("空樹");
        int min = root.data;
        if (root.left != null) min = Math.min(min, findMin(root.left));
        if (root.right != null) min = Math.min(min, findMin(root.right));
        return min;
    }

    public static int findMax(TreeNode root) {
        if (root == null) throw new RuntimeException("空樹");
        int max = root.data;
        if (root.left != null) max = Math.max(max, findMax(root.left));
        if (root.right != null) max = Math.max(max, findMax(root.right));
        return max;
    }

    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        System.out.println("節點總和: " + sum(root));
        System.out.println("最小值: " + findMin(root));
        System.out.println("最大值: " + findMax(root));
        System.out.println("葉節點數量: " + countLeaves(root));
        System.out.println("樹的高度: " + height(root));
    }
}
