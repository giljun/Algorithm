package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_8500 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int t_case = 1; t_case <= t; t_case++) {
			int n = Integer.parseInt(br.readLine());

			String str = br.readLine();
			String[] numbers = str.split(" ");
			
			int[] arr = new int[numbers.length];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(numbers[i]);
			}
			
			Arrays.sort(arr);
			
			int min = 0;
			for (int i = 0; i < arr.length; i++) {
				min += (arr[i]+1);
			}
			min += arr[arr.length-1];
			System.out.println("#"+t_case+" "+min);
		}
	}
}