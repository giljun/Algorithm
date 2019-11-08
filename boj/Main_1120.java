import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_1120 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();

		int loop = b.length() - a.length();

		int min_diff = Integer.MAX_VALUE;
		for (int i = 0; i <= loop; i++) {
			int diff = 0;
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) != b.charAt(j + i)) {
					diff++;
				}
			}
			if (min_diff > diff) {
				min_diff = diff;
			}
		}
		System.out.println(min_diff);
	}
}