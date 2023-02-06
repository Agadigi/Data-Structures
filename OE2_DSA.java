package praktis1;
import java.util.Scanner;

public class OE2_DSA
{
	   public static void main(String[] args)
	   {
	      Scanner in = new Scanner(System.in);
	      
	      System.out.print(" Input array size : ");
	      int f = in.nextInt();
	      
	      int[] arr = new int[f];
	      
	      System.out.print("Enter " +f+" Elements in Random Order: ");
	      for(int i=0; i<f; i++)
	         arr[i] = in.nextInt();
	      
	      System.out.println("\nSorting the array...");
	      for(int i=0; i<(f-1); i++)
	      {
	         for(int j=0; j<(f-i-1); j++)
	         {
	            if(arr[j]>arr[j+1])
	            {
	               int temp = arr[j];
	               arr[j] = arr[j+1];
	               arr[j+1] = temp;
	            }
	         }
	         System.out.print("\nIteration # " +(i+1)+ " ,,,  ");
	         for(int j=0; j<f; j++)
	            System.out.print(arr[j]+ " ");
	      }
	      
	      System.out.println("\nThe Final sorted array : ");
	      for(int i=0; i<f; i++)
	         System.out.print(arr[i]+ " ");
	   }
	}