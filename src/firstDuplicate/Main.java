package firstDuplicate;

import java.util.Scanner;

public class Main {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		int tc = input.nextInt();
		
		int arr[] = new int [tc];
		
		for(int i=0; i<tc; i++) {
			arr[i] = input.nextInt();
		}
		int num = first_duplicate(arr);
		System.out.println(num);
	}
	
	public static int first_duplicate(int arr[]) {
		
		for(int i=0; i<arr.length; i++) {
			int temp = arr[i];
			for(int j=i+1; j<arr.length; j++) {
				if(temp == arr[j]) {
					return temp;
				}
			}
		}
		
		return -1;
	}
	
}
