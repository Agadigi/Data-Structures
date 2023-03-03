package praktis1;
import java.util.Scanner;

public class tryy {

    static class Node {
        int value;
        Node next;

        public Node(int data) {
            this.value = data;
            this.next = null;
        }
    }

    static Node head = null;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println(" Choose operation:\n 1 to insert node at the beginning\n 2 at the end\n 3 after specified node\n 4 to exit");
            System.out.print(" Enter your choice: ");
            int option = s.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Input value for new node:");
                    int data = s.nextInt();
                    insertAtBeginning(data);
                    printLinkedList();
                    break;
                case 2:
                    System.out.println("Input value for new node:");
                    data = s.nextInt();
                    insertAtEnd(data);
                    printLinkedList();
                    break;
                case 3:
                    System.out.println("Input value for new node:");
                    data = s.nextInt();
                    System.out.println("Enter data of the node after which the new node should be inserted:");
                    int afterData = s.nextInt();
                    insertAfter(data, afterData);
                    printLinkedList();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Node with data " + data + " added at the beginning.");
    }

    static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println("Node with data " + data + " added at the end.");
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        System.out.println("Node with data " + data + " added at the end.");
    }

    static void insertAfter(int data, int afterData) {
        Node newNode = new Node(data);
        Node curr = head;
        while (curr != null && curr.value != afterData) {
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Node with data " + afterData + " not found in the linked list");
            return;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        System.out.println("Node with data " + data + " added after the node with data " + afterData);
    }

    static void printLinkedList() {
        System.out.print("Current list: ");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
