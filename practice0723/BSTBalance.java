package practice0723;

public class BSTBalance {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 計算高度
    public static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // 判斷是否為平衡樹
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    // 回傳 -1 表示不平衡，否則回傳高度
    private static int checkBalance(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkBalance(node.left);
        int rightHeight = checkBalance(node.right);

        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // 計算平衡因子（左子樹高度 - 右子樹高度）
    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // 找出最不平衡的節點（平衡因子絕對值最大）
    static class Result {
        TreeNode node;
        int maxImbalance;
    }

    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        Result result = new Result();
        result.node = null;
        result.maxImbalance = -1;
        findImbalance(root, result);
        return result.node;
    }

    private static void findImbalance(TreeNode node, Result result) {
        if (node == null) return;

        int balance = getBalanceFactor(node);
        if (Math.abs(balance) > result.maxImbalance) {
            result.maxImbalance = Math.abs(balance);
            result.node = node;
        }

        findImbalance(node.left, result);
        findImbalance(node.right, result);
    }

    // 測試
    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(40);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);

        System.out.println("是否為平衡樹: " + isBalanced(root));
        System.out.println("根節點平衡因子: " + getBalanceFactor(root));

        TreeNode unbalanced = findMostUnbalancedNode(root);
        System.out.println("最不平衡的節點值: " + (unbalanced != null ? unbalanced.data : "無"));
        System.out.println("該節點平衡因子: " + getBalanceFactor(unbalanced));
    }
}
