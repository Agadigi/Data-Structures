import java.util.Scanner;
import java.io.*;

public class BALATUCANOE1 {
	static int array[] = {5,10,15,20,25};
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		


		int delete1,search1,index1,index2;
		
		System.out.print("1 = Traverse\n2 = Delete\n3 = Search\n4 = Update\nEnter : ");
		int option = s.nextInt();
		
		if (option == 1) {
			traverse(array);
		}
		else if (option == 2) {
			System.out.print("Enter you want to delete : ");
			delete1 = s.nextInt();
			delete(array,delete1);
		}
		
		else if (option ==3) {
			System.out.println("input the value to be searched:");
			search1 = s.nextInt();
			search(array,search1);
		}

		else if (option ==4) {
			System.out.println("input the value to be changed:");
			index1 = s.nextInt();
			System.out.println("input the value to be ewan ko:");
			index2 = s.nextInt();
			updateValue(array,index1,index2);
		}
	}


	public static void traverse(int arr[]) {
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}	
	}
	

	public static void delete(int arr[],int val) {
		for(int i =0;i<arr.length-1;i++) {
			if(val == arr[i]) {
				//taga adjust nung value to the left
				for(int j=i;j<arr.length-1;j++) {
					arr[j]=arr[j+1];
				}
			}
			System.out.print(arr[i]+" ");
		}	
	}
	public static int search(int arr[],int val) {
		boolean found= false;
		for(int i =0;i<arr.length;i++) {
			if(val == arr[i]) {
				System.out.println("I found the value at index: "+i);
				found= true;
			}	
		}
		if(!found) {
			System.out.println("No value found on the array");
			return 0;
		}
		return 0;
	}
	public static void updateIndex(int arr[],int ival,int val) {
		for(int i =0; i<arr.length;i++) {
			if(ival == i) {
				arr[i] = val;
			}
			System.out.print(arr[i]+" ");
		}
	}
	public static void updateValue(int arr[],int dval, int uval) {
		for(int i =0; i<arr.length;i++) {
			if(arr[i] == dval) {
				arr[i] = uval;
			}
			System.out.print(arr[i]+" ");
		}
	}
	
	
}


