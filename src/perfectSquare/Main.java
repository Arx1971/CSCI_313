package perfectSquare;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);
	static Random random = new Random();
	
	public static void main(String args[]) {
		
		int num = input.nextInt();
		System.out.println(prefect_squere(num));
	}
	
	
	public static boolean prefect_squere(int key) {
		
		int arr[] = new int[key+1];
		
		for(int i=0; i<=key; i++) {
			arr[i] = i;
		}
		
		int left = 0, right = key;
		
		int middle;
		
		while(left<=right) {
			
			middle = (left+right)/2;

			if(arr[middle]*arr[middle] == key) {
				return true;
			}
			else if(arr[middle]*arr[middle] > key) {
				right = middle - 1;
			}
			else {
				left = middle+1;
			}
		}
		
		return false;
	}
	
}
