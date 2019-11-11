package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_8821 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int t_case = 1; t_case <= t; t_case++) {
			// 1. 진수가 말하는 숫자
			String numbers = br.readLine();

			// 2. 동욱이가 적거나 지운다.
			String result = "";
			for (int i = 0; i < numbers.length(); i++) {
				char num = numbers.charAt(i);
				boolean isChecked = false;
				for (int j = 0; j < result.length(); j++) {
					if (result.charAt(j) == num) {
						isChecked = true;
						break;
					}
				}
				if (isChecked) {
					result = result.replaceAll(""+num, "");
				} else {
					result += num;
				}
			}
			System.out.println("#" + t_case + " " + result.length());
		}
	}
}