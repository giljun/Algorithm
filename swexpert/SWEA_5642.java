package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5642 {

	static boolean result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			String[] numbers = str.split(" ");
			
			int[] arr = new int[numbers.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(numbers[i]);
			}
			
			int max = Integer.MIN_VALUE;
			int sum = 0;
			
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
				if( sum > max ) {
					max = sum;
				}
				if( sum < 0 ) {
					sum = 0;
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
