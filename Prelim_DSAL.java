package praktis1;
import java.util.Scanner;

public class Prelim_DSAL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner input = new Scanner(System.in);
		  
	        int size;
	        System.out.print("Enter the size of the array: ");
	        size = input.nextInt();
	        String[] names = new String[size];

	        System.out.print("Enter a string: ");
	        for (int i = 0; i < size; i++) {
	            names[i] = input.next();
	        }

	        System.out.println("\nUnsorted String: ");
	        for (int i = 0; i < size; i++) {
	            System.out.println(" [ " + names[i] + " ] ");
	        }

	        System.out.println("\nSorted String after bubble sort: ");
	        bubbleSort(names, size);
	        for (int i = 0; i < size; i++) {
	            System.out.println(" [ " + names[i] + " ] ");
	        }

	        System.out.println("\nSorted String after insertion sort: ");
	        insertionSort(names, size);
	        for (int i = 0; i < size; i++) {
	            System.out.println(" [ " + names[i] + " ] ");
	        }
	    }

	    public static void bubbleSort(String[] names, int size) {
	        for (int i = 0; i < size - 1; i++) {
	            for (int j = 0; j < size - i - 1; j++) {
	                if (names[j].compareTo(names[j + 1]) > 0) {
	                    String temp = names[j];
	                    names[j] = names[j + 1];
	                    names[j + 1] = temp;
	                }
	            }
	        }
	    }

	    public static void insertionSort(String[] names, int size) {
	        for (int i = 1; i < size; i++) {
	            String key = names[i];
	            int j = i - 1;
	            while (j >= 0 && names[j].compareTo(key) > 0) {
	                names[j + 1] = names[j];
	                j = j - 1;
	            }
	            names[j + 1] = key;
	        }
	    }
	}
