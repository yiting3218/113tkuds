package practice0723;

import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode buildFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = buildIndexMap(inorder);
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int preStart, int preEnd,
                                       int[] in, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inRoot = inMap.get(rootVal);
        int leftSize = inRoot - inStart;

        root.left = buildPreIn(pre, preStart + 1, preStart + leftSize, in, inStart, inRoot - 1, inMap);
        root.right = buildPreIn(pre, preStart + leftSize + 1, preEnd, in, inRoot + 1, inEnd, inMap);

        return root;
    }

    public static TreeNode buildFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = buildIndexMap(inorder);
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] post, int postStart, int postEnd,
                                        int[] in, int inStart, int inEnd,
                                        Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = post[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inRoot = inMap.get(rootVal);
        int leftSize = inRoot - inStart;

        root.left = buildPostIn(post, postStart, postStart + leftSize - 1, in, inStart, inRoot - 1, inMap);
        root.right = buildPostIn(post, postStart + leftSize, postEnd - 1, in, inRoot + 1, inEnd, inMap);

        return root;
    }

    public static void inOrderPrint(TreeNode root) {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.print(root.data + " ");
            inOrderPrint(root.right);
        }
    }

    private static Map<Integer, Integer> buildIndexMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }

    public static void main(String[] args) {
        // 測試資料
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // 前序 + 中序 重建
        TreeNode tree1 = buildFromPreIn(preorder, inorder);
        System.out.print("前序+中序建構後中序遍歷：");
        inOrderPrint(tree1);
        System.out.println();

        // 後序 + 中序 重建
        TreeNode tree2 = buildFromPostIn(postorder, inorder);
        System.out.print("後序+中序建構後中序遍歷：");
        inOrderPrint(tree2);
        System.out.println();
    }
}
