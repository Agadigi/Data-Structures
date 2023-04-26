package praktis1;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = null;
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Node");
            System.out.println("2. In-order Traversal");
            System.out.println("3. Pre-order Traversal");
            System.out.println("4. Post-order Traversal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to add: ");
                    int val = scan.nextInt();
                    if (root == null) {
                        root = new BinaryTreeNode<Integer>(val);
                    } else {
                        root.addNode(val);
                    }
                    break;
                case 2:
                    System.out.println("In-order Traversal");
                    root.inOrder();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Pre-order Traversal");
                    root.preOrder();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Post-order Traversal");
                    root.postOrder();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);
    }

    public void addNode(T val) {
        Queue<BinaryTreeNode<T>> q = new LinkedList<>();
        q.add(this);
        while (!q.isEmpty()) {
            BinaryTreeNode<T> temp = q.poll();
            if (temp.left == null) {
                temp.left = new BinaryTreeNode<T>(val);
                break;
            } else {
                q.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new BinaryTreeNode<T>(val);
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    // Function for in-order traversal
    public void inOrder() {
        if (this != null) {
            if (this.left != null) {
                this.left.inOrder();
            }
            System.out.print(this.data + " ");
            if (this.right != null) {
                this.right.inOrder();
            }
        }
    }

    // Function for pre-order traversal
    public void preOrder() {
        if (this != null) {
            System.out.print(this.data + " ");
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }
    }

    // Function for post-order traversal
    public void postOrder() {
        if (this != null) {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.print(this.data + " ");
        }
    }
}

