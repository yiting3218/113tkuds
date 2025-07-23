package practice0723;

public class TreeComparison {
    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    // 判斷兩棵樹是否完全相同
    public static boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.data != b.data) return false;
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

    // 判斷 b 是否為 a 的子樹
    public static boolean isSubtree(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        if (isIdentical(a, b)) return true;
        return isSubtree(a.left, b) || isSubtree(a.right, b);
    }

    static class Result {
        TreeNode node;
        int size;
        Result(TreeNode node, int size) {
            this.node = node;
            this.size = size;
        }
    }

    // 找出最大公共子樹（包含節點最多的相同結構與資料子樹）
    public static TreeNode findLargestCommonSubtree(TreeNode a, TreeNode b) {
        Result result = findLargestCommonSubtreeHelper(a, b);
        return result.node;
    }

    private static Result findLargestCommonSubtreeHelper(TreeNode a, TreeNode b) {
        if (a == null || b == null) return new Result(null, 0);

        if (a.data == b.data && isIdentical(a, b)) {
            int totalSize = size(a);
            return new Result(a, totalSize);
        }

        Result[] candidates = new Result[] {
            findLargestCommonSubtreeHelper(a.left, b),
            findLargestCommonSubtreeHelper(a.right, b),
            findLargestCommonSubtreeHelper(a, b.left),
            findLargestCommonSubtreeHelper(a, b.right),
            findLargestCommonSubtreeHelper(a.left, b.left),
            findLargestCommonSubtreeHelper(a.right, b.right),
            new Result(null, 0)
        };

        Result best = candidates[0];
        for (Result r : candidates) {
            if (r.size > best.size) {
                best = r;
            }
        }
        return best;
    }

    // 計算子樹大小
    private static int size(TreeNode node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    // 中序遍歷
    public static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // 測試程式
    public static void main(String[] args) {
        // 樹 A
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);

        // 樹 B（完全相同）
        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(2);
        B.right = new TreeNode(3);
        B.left.left = new TreeNode(4);
        B.left.right = new TreeNode(5);

        // 樹 C（是 A 的子樹）
        TreeNode C = new TreeNode(2);
        C.left = new TreeNode(4);
        C.right = new TreeNode(5);

        // 樹 D（與 A 有部分重疊）
        TreeNode D = new TreeNode(2);
        D.left = new TreeNode(4);
        D.right = new TreeNode(5);

        // 測試結果輸出
        System.out.println("A 和 B 是否完全相同: " + isIdentical(A, B));
        System.out.println("C 是否為 A 的子樹: " + isSubtree(A, C));
        System.out.println("D 是否為 A 的子樹: " + isSubtree(A, D));

        TreeNode common = findLargestCommonSubtree(A, D);
        System.out.print("最大公共子樹（中序）: ");
        inOrder(common);
        System.out.println();
    }
}
