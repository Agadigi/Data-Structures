package praktis1;
import java.util.Scanner;

class Node {
    int a;
    Node next;
    Node prev;

    Node(int data) {
        this.a = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head = null;

    void create(int item) {
        Node node1 = new Node(item);
        if (head == null) {
            head = node1;
        } else {
        	node1.next = head;
            head.prev = node1;
            head = node1;
        }
        System.out.println("\nNode Inserted");
    }

    void search() {
        if (head == null) {
            System.out.println("\nEmpty List");
            return;
        }

        System.out.println("\nEnter item you want to search?");
        Scanner s = new Scanner(System.in);
        int item = s.nextInt();

        Node ptr = head;
        int i = 0;
        boolean flag = false;
        while (ptr != null) {
            if (ptr.a == item) {
                System.out.println("\nitem found at location " + (i + 1));
                flag = true;
                break;
            }
            i++;
            ptr = ptr.next;
        }

        if (!flag) {
            System.out.println("\nItem not found");
        }
    }

    void delete(int item) {
        if (head == null) {
            System.out.println("\nEmpty List");
            return;
        }

        Node new1 = head;
        Node prev = null;
        boolean flag = false;
        while (new1 != null) {
            if (new1.a == item) {
                flag = true;
                if (new1 == head) {
                    head = new1.next;
                } else {
                    prev.next = new1.next;
                    if (new1.next != null) {
                    	new1.next.prev = prev;
                    }
                }
                System.out.println("\nNode Deleted");
                break;
            }
            prev = new1;
            new1 = new1.next;
        }

        if (!flag) {
            System.out.println("\nItem not found");
        }
    }
}

public class DsaPT2 {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner s = new Scanner(System.in);

        int choice, item;
        do {
            System.out.println("\n1.Create\n2.Search\n3.Delete\n4.Exit\nEnter your choice?");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nEnter the item");
                    item = s.nextInt();
                    dll.create(item);
                    break;
                case 2:
                    dll.search();
                    break;
                case 3:
                    System.out.println("\nEnter the item to delete");
                    item = s.nextInt();
                    dll.delete(item);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("\nPlease enter valid choice");
            }
        } while (choice != 4);
    }
}


