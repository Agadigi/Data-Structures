// BALATUCAN ADRIAN M.
// BSCS 2-1
// OOP EXAMINATION STACK-SORT
// 29/07/2023

import java.util.Arrays;
import java.util.Scanner;

public class BALATUCAN_STACK_SORT {
    static final int MAXSIZE = 5;
    static int[] stack = new int[MAXSIZE];
    static int top = -1;

    static boolean isempty() {
        return top == -1;
    }

    static boolean isfull() {
        return top == MAXSIZE - 1;
    }

    static void push(int data) {
        if (!isfull()) {
            stack[++top] = data;
            System.out.println("Element pushed to the stack.");
        } else {
            System.out.println("Could not insert data, Stack is full.");
        }
    }

    static int pop() {
        if (!isempty()) {
            return stack[top--];
        } else {
            System.out.println("Could not retrieve data, Stack is empty.");
            return -1; 
        }
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                  
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Stack");
            System.out.println("2. Sort");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int stackChoice;
                    do {
                        System.out.println("\nStack Menu:");
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        stackChoice = scanner.nextInt();

                        switch (stackChoice) {
                            case 1:
                                if (isfull()) {
                                    System.out.println("Stack is full. Cannot push element.");
                                } else {
                                    System.out.print("Enter the element to push: ");
                                    int num = scanner.nextInt();
                                    push(num);
                                }
                                break;

                            case 2:
                                if (isempty()) {
                                    System.out.println("Stack is empty. Cannot pop.");
                                } else {
                                    int numPopped = pop();
                                    System.out.println("Element popped from the stack: " + numPopped);
                                }
                                break;

                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (stackChoice != 0);
                    break;

                case 2:
                    if (isempty()) {
                        System.out.println("Stack is empty. Please push elements to the stack.");
                    } else {
                        int[] userArray = Arrays.copyOf(stack, top + 1);

                        System.out.println("Original Stack: " + Arrays.toString(stack));

                        bubbleSort(userArray);

                        System.out.println("Sorted Stack: " + Arrays.toString(userArray));
                        System.out.println("Stack sorted using Bubble Sort.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
