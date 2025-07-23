package practice0723;

public class BSTConversion {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static class DLLResult {
        TreeNode head;
        TreeNode prev;
    }

    public static TreeNode bstToDoublyLinkedList(TreeNode root) {
        DLLResult result = new DLLResult();
        convertToDLL(root, result);
        return result.head;
    }

    private static void convertToDLL(TreeNode node, DLLResult result) {
        if (node == null) return;

        convertToDLL(node.left, result);

        if (result.prev == null) {
            result.head = node;  // 最左節點為 head
        } else {
            result.prev.right = node;
            node.left = result.prev;
        }
        result.prev = node;

        convertToDLL(node.right, result);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBalancedBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBalancedBST(nums, left, mid - 1);
        root.right = buildBalancedBST(nums, mid + 1, right);

        return root;
    }

    public static void convertToGreaterTree(TreeNode root) {
        int[] sum = new int[1]; // 使用陣列包裝 sum 以便遞迴修改
        reverseInOrder(root, sum);
    }

    private static void reverseInOrder(TreeNode node, int[] sum) {
        if (node == null) return;

        reverseInOrder(node.right, sum);
        sum[0] += node.data;
        node.data = sum[0];
        reverseInOrder(node.left, sum);
    }

    // 中序列印（用於驗證）
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // 印出雙向鏈表
    public static void printDLL(TreeNode head) {
        TreeNode current = head;
        System.out.print("雙向鏈表: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 建立 BST
        TreeNode bst = new TreeNode(20);
        bst.left = new TreeNode(10);
        bst.right = new TreeNode(30);
        bst.left.left = new TreeNode(5);
        bst.left.right = new TreeNode(15);
        bst.right.right = new TreeNode(40);

        // 轉成雙向鏈表
        TreeNode dllHead = bstToDoublyLinkedList(bst);
        printDLL(dllHead);

        // 從排序陣列建 BST
        int[] sortedArray = {1, 3, 5, 7, 9, 11};
        TreeNode balancedBST = sortedArrayToBST(sortedArray);
        System.out.print("平衡 BST 中序遍歷: ");
        inOrder(balancedBST);
        System.out.println();

        // BST 節點值改為 >= 自己的總和
        TreeNode sumBST = new TreeNode(5);
        sumBST.left = new TreeNode(2);
        sumBST.right = new TreeNode(13);
        convertToGreaterTree(sumBST);
        System.out.print("轉換後 BST 中序遍歷: ");
        inOrder(sumBST);
        System.out.println();
    }
}
