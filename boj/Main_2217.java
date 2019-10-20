import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] rope;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		rope = new int[n];
		
		for (int i = 0; i < rope.length; i++) {
			st = new StringTokenizer(br.readLine());
			rope[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(rope);
		
		int k = rope.length;
		
		int max_weight = 0;
		
		for (int i = 1; i <= k; i++) {
			int weight = rope[k-i]*i;
			if(max_weight < weight) {
				max_weight = weight; 
			}
		}
		System.out.println(max_weight);
	}

}
