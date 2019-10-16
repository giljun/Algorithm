import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int[] p = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < p.length; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(p);
		
		int sum = 0;
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j <= i; j++) {
				sum += p[j];
			}
		}
		
		System.out.println(sum);
	}

}
