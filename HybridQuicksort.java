package praktis1;
import java.util.Scanner;
import java.util.Random;

public class HybridQuicksort {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    Random random = new Random();

	    boolean runAgain = true;
	    while (runAgain) {
	        System.out.println("Enter [1] to input data manually ");
	        System.out.println("Enter [2] to generate random data ");
	        System.out.print("Choose your option: ");
	        int choice = scanner.nextInt();

	        int[] arr;
	        switch (choice) {
	            case 1:
	                arr = manualInput(scanner);
	                break;
	            case 2:
	                arr = randomInput(random, scanner);
	                break;
	            default:
	                System.out.println("Invalid choice.");
	                return;
	        }

	        System.out.println("Original array:");
	        printArray(arr);

	        hybridQuickSort(arr, 0, arr.length-1);

	        System.out.println("Sorted array:");
	        printArray(arr);

	        System.out.print("Do you want to run again? [Y/N]: ");
	        char runAgainChoice = scanner.next().charAt(0);
	        if (runAgainChoice == 'Y' || runAgainChoice == 'y') {
	            runAgain = true;
	        } else {
	            runAgain = false;
	        }
	    }
	}

	public static int[] manualInput(Scanner scanner) {
	    System.out.println("Enter the size of the array:");
	    int n = scanner.nextInt();
	    int[] arr = new int[n];

	    System.out.println("Enter " + n + " integers:");
	    for (int i = 0; i < n; i++) {
	        arr[i] = scanner.nextInt();
	    }
	    return arr;
	}

	public static int[] randomInput(Random random, Scanner scanner) {
	    System.out.println("Enter the size of the array:");
	    int n = scanner.nextInt();
	    int[] arr = new int[n];

	    for (int i = 0; i < n; i++) {
	        arr[i] = random.nextInt(1000);
	    }
	    return arr;
	}

	public static void hybridQuickSort(int[] arr, int start, int end) {
	    if (start < end) {
	        if (end - start + 1 < 10) {
	            insertionSort(arr, start, end);
	        } else {
	            int pivotIndex = pivot(arr, start, end);
	            hybridQuickSort(arr, start, pivotIndex-1);
	            hybridQuickSort(arr, pivotIndex+1, end);
	        }
	    }
	}

	public static int pivot(int[] arr, int start, int end) {
	    int pivot = arr[end];
	    int i = start - 1;

	    for (int j = start; j < end; j++) {
	        if (arr[j] < pivot) {
	            i++;
	            swap(arr, i, j);
	        }
	    }

	    swap(arr, i+1, end);
	    return i+1;
	}

	public static void insertionSort(int[] arr, int start, int end) {
	    for (int i = start+1; i <= end; i++) {
	        int key = arr[i];
	        int j = i-1;
	        while (j >= start && arr[j] > key) {
	            arr[j+1] = arr[j];
	            j--;
	        }
	        arr[j+1] = key;
	    }
	}

	public static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

	