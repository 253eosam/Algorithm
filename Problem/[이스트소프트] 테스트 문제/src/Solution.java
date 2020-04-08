import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		
		HashMap<String, Integer >map = new HashMap<>();
		
		Collections.sort(map,new Comparable<HashMap<String, Integer>>() {

			@Override
			public int compareTo(HashMap<String, Integer> o) {
				return 0;
			}
		});
	}

	
}
