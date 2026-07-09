import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class IterativePostorder {
    static Scanner sc = new Scanner(System.in);
    static Node createTree() {
        int data = sc.nextInt();

        if (data == -1)
            return null;

        Node root = new Node(data);

        root.left = createTree();
        root.right = createTree();

        return root;
    }
    static void postOrder(Node root) {

        if (root == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            Node node = s1.pop();
            s2.push(node);

            if (node.left != null)
                s1.push(node.left);

            if (node.right != null)
                s1.push(node.right);
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter tree values in preorder (-1 for NULL):");

        Node root = createTree();

        System.out.println("Postorder Traversal:");

        postOrder(root);
    }
}