import java.util.*;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class Binarytree {
    Node root;

    Binarytree(int key) {
        root = new Node(key);
    }

    Binarytree() {
        root = null;
    }
    public Node constructBinaryTree(int[] arr, int index) {
        Node temp = null;

        if (index < arr.length) {
            temp = new Node(arr[index]);
            temp.left = constructBinaryTree(arr, 2 * index + 1);
            temp.right = constructBinaryTree(arr, 2 * index + 2);
        }
        return temp;
    }

    public void traversePreOrder(Node node) {
        if (node == null)
            return;
        System.out.print(" " + node.key);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    /*public void traversePostOrder(Node node) {
        if (node == null)
            return;
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.print(" " + node.key);
    }

    public void traverseInOrder(Node node) {
        if (node == null)
            return;
        traverseInOrder(node.left);
        System.out.print(" " + node.key);
        traverseInOrder(node.right);
    }*/

    public void printTree(Node node, int level) {
        if (node == null)
            return;
        printTree(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + node.key);
        } else
            System.out.println(node.key);
        printTree(node.left, level + 1);
    }

    public static void main(String[] args) {
        Binarytree tree = new Binarytree();
        Scanner sc = new Scanner(System.in);
        /*tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);*/;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n; arr[i]=sc.nextInt(),i++);
        tree.root = tree.constructBinaryTree(arr,0);
        System.out.println("Pre order Traversal: ");
        tree.traversePreOrder(tree.root);
        /*System.out.println("\n\nPost order Traversal: ");
        tree.traversePostOrder(tree.root);
        System.out.println("\n\nIn order Traversal: ");
        tree.traverseInOrder(tree.root);*/
        System.out.println("\n\nBinary Tree Structure:");
        tree.printTree(tree.root, 0);
    }
}
