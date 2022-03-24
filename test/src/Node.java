public class Node {
    int root;
    Node left;
    Node right;

    Node(int value, Node left, Node right) {
        this.root = value;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree1 {
    Node root;

    BinaryTree1(Node root) {
        this.root = root;
    }

    public int countLeafNodes() {
        return countLeafNodes(this.root);
    }

    private int countLeafNodes(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return countLeafNodes(root.left) + countLeafNodes(root.right);
        }
    }
}

// Creating a tree with 3 levels => 1 -> (2(left) -> 4(left) & 3(right))
class Test1  {
    public static void main(String[] args) {
        Node leaf = new Node(4, null, null);
        Node two = new Node(2, leaf, null);
        Node three = new Node(3, null, null);
        Node one = new Node(1, two, three);

        BinaryTree1 tree = new BinaryTree1(one);
        System.out.println(tree.countLeafNodes());
    }
}



