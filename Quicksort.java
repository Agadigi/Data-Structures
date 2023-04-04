package praktis1;
import java.util.Scanner;

public class Quicksort {
	public static void quicksort(int[] number, int first, int last) {
		int i, j, pivot, temp;

		    if (first < last) {
		        pivot = first;
		        i = first;
		        j = last;

		        while (i < j) {
		            while (number[i] <= number[pivot] && i < last)
		                i++;
		            while (number[j] > number[pivot])
		                j--;
		            if (i < j) {
		                temp = number[i];
		                number[i] = number[j];
		                number[j] = temp;
		            }
		        }

		        temp = number[pivot];
		        number[pivot] = number[j];
		        number[j] = temp;

		        quicksort(number, first, j - 1);
		        quicksort(number, j + 1, last);
		    }
		}

		public static void main(String[] args) {
		    int i, count, number[] = new int[25];
		    Scanner scanner = new Scanner(System.in);

		    System.out.print("Enter some elements (Max. - 25): ");
		    count = scanner.nextInt();

		    System.out.println("Enter " + count + " elements: ");
		    for (i = 0; i < count; i++)
		        number[i] = scanner.nextInt();

		    quicksort(number, 0, count - 1);

		    System.out.print("The Sorted Order is: ");
		    for (i = 0; i < count; i++)
		        System.out.print(" " + number[i]);
		}
}
