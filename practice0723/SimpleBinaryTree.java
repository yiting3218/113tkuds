package practice0723;

public class SimpleBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }

        public void displayNode() {
            System.out.println("節點值: " + data);
            System.out.println("左子節點: " + (left != null ? left.data : "null"));
            System.out.println("右子節點: " + (right != null ? right.data : "null"));
        }
    }

    public static void printTree(TreeNode node, int space) {
        if (node == null) return;
        int COUNT = 5;
        space += COUNT;
        printTree(node.right, space);
        System.out.println();
        for (int i = COUNT; i < space; i++) System.out.print(" ");
        System.out.println(node.data);
        printTree(node.left, space);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("樹的結構:");
        root.displayNode();
        root.left.displayNode();
        root.right.displayNode();
        root.left.left.displayNode();
        root.left.right.displayNode();

        System.out.println("\n樹狀結構如下：");
        printTree(root, 0);
    }
}
