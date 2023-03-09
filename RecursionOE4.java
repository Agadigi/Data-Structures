package praktis1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionOE4{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int option;

        do {
            System.out.println("APPLICATION OF RECURSION");
            System.out.println("[1] Fibonacci series");
            System.out.println("[2] Factorial of a number");
            System.out.println("[3] Reverse a number");
            System.out.println("[4] Reverse a word");
            System.out.println("[5] Tower of Hanoi");
            System.out.println("[0] Exit");
            System.out.print("Select your choice:");

            option = Integer.parseInt(reader.readLine());

            if (option == 1) {
                System.out.print("Enter a series number: ");
                int n = Integer.parseInt(reader.readLine());

                System.out.print("Series are: ");
                for (int i = 0; i < n; i++) {
                    System.out.print(fibonacci(i) + " ");
                }
                System.out.println();
            } else if (option == 2) {
                System.out.print("Enter a number: ");
                int num = Integer.parseInt(reader.readLine());

                System.out.println(num + "! = " + factorial(num));
            } else if (option == 3) {
                System.out.print("Enter a number: ");
                int number = Integer.parseInt(reader.readLine());

                System.out.println("Reverse of " + number + " is " + reverseNumber(number));
            } else if (option == 4) {
                System.out.print("Enter a word: ");
                String word = reader.readLine();

                System.out.println("Reverse of " + word + " is " + reverseWord(word));
            } else if (option == 5) {
                System.out.print("Enter a number: ");
                int disks = Integer.parseInt(reader.readLine());

                System.out.println("Moves to solve the problem:");
                towerOfHanoi(disks, 'A', 'C', 'B');
            } else if (option == 6) {
                System.out.println("Exiting program...");
            } else {
                System.out.println("Invalid choice.");
            }
        } while (option != 6);
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int reverseNumber(int n) {
        if (n < 10) {
            return n;
        } else {
            int lastDigit = n % 10;
            int remainingDigits = n / 10;
            int reversed = reverseNumber(remainingDigits);

            return (int) (lastDigit * Math.pow(10, (int) Math.log10(remainingDigits) + 1)) + reversed;
        }
    }

    public static String reverseWord(String word) {
        if (word.isEmpty()) {
            return word;
        } else {
            return reverseWord(word.substring(1)) + word.charAt(0);
        }
    }

    public static void towerOfHanoi(int disks, char source, char destination, char auxiliary) {
        if (disks == 1) {
            System.out.println(source + " -> " + destination);
        } else {
        	towerOfHanoi(disks - 1, source, auxiliary, destination);
        	System.out.println(source + " -> " + destination);
        	towerOfHanoi(disks - 1, auxiliary, destination, source);
        }
    }	
}   
