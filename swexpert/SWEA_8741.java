package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_8741 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int t_case = 1; t_case <= t; t_case++) {
			String str = br.readLine();

			String[] words = str.split(" ");

			String result = "";
			for (int i = 0; i < words.length; i++) {
				result += words[i].charAt(0);
			}

			System.out.println("#" + t_case + " " + result.toUpperCase());
		}
	}
}