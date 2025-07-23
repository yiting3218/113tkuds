package practice0723;

public class TreeMirror {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.data == b.data)
            && isMirror(a.left, b.right)
            && isMirror(a.right, b.left);
    }

    public static void mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.right.right = new TreeNode(3);

        System.out.println("樹1是否對稱: " + isSymmetric(root1));

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(20);
        root2.left.left = new TreeNode(3);
        root2.right.right = new TreeNode(25);

        System.out.print("原本中序: ");
        inOrder(root2);
        System.out.println();

        mirror(root2);

        System.out.print("鏡像中序: ");
        inOrder(root2);
        System.out.println();

        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(3);
        b.right = new TreeNode(2);

        System.out.println("a與b是否互為鏡像: " + isMirror(a, b));
    }
}
