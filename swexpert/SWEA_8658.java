package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_8658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int t_case = 1; t_case <= t; t_case++) {
			String str = br.readLine();
			String[] numbers = str.split(" ");

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < numbers.length; i++) {
				String number = numbers[i];
				int sum = 0;
				for (int j = 0; j < number.length(); j++) {
					sum += Integer.parseInt("" + number.charAt(j));
				}
				if (max < sum) {
					max = sum;
				}
				if (min > sum) {
					min = sum;
				}
			}

			System.out.println("#" + t_case + " " + max + " " + min);
		}
	}
}