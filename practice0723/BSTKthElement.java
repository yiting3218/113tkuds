package practice0723;

public class BSTKthElement {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static class Counter {
        int count = 0;
        int result = -1;
    }

    public static void findKthSmallest(TreeNode root, int k, Counter counter) {
        if (root == null || counter.count >= k) return;

        findKthSmallest(root.left, k, counter);

        counter.count++;
        if (counter.count == k) {
            counter.result = root.data;
            return;
        }

        findKthSmallest(root.right, k, counter);
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);
        if (data < root.data) root.left = insert(root.left, data);
        else if (data > root.data) root.right = insert(root.right, data);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int val : values) {
            root = insert(root, val);
        }

        int k = 3;
        Counter counter = new Counter();
        findKthSmallest(root, k, counter);

        if (counter.result != -1) {
            System.out.println("BST中第 " + k + " 小的元素為: " + counter.result);
        } else {
            System.out.println("第 " + k + " 小的元素不存在");
        }
    }
}
