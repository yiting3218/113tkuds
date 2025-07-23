package practice0723;

public class TreeNodeExample {

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

    // 印出整棵樹的圖形結構
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
        TreeNode root = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(15);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        root.left = leftChild;
        root.right = rightChild;
        leftChild.left = node1;
        leftChild.right = node2;

        root.displayNode();
        leftChild.displayNode();
        rightChild.displayNode();
        node1.displayNode();
        node2.displayNode();

        // 印出整棵樹的圖形結構
        System.out.println("\n樹狀結構如下：");
        printTree(root, 0);
    }
}
