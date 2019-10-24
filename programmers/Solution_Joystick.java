package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution_Joystick {
	static boolean[] visited;
	static ArrayList<String> arr;

	public static void main(String[] args) {
		int[] numbers = { 0, 0, 6, 6 };
		String answer = "";

		answer = solution(numbers);
		
		System.out.println(answer);
	}

	public static String solution(int[] numbers) {
		String answer = "";

		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			arr.add(String.valueOf(numbers[i]));
		}
		
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		if(arr.get(0).charAt(0)=='0') return "0";
		
		for (int i = 0; i < arr.size(); i++) {
			answer += arr.get(i);
		}
		
		return answer;
	}

}
