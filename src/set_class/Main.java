package set_class;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		
		Set<Integer> set = new TreeSet<>();
		set.add(3);
		set.add(8);
		set.add(5);
		set.remove(4);
		
		for(int i: set) {
			System.out.println(i);
		}
		
	}
}
