import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_5585 {

	static int count;
	static int[] coins = { 500, 100, 50, 10, 5, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		int pay = Integer.parseInt(st.nextToken());
		int money = 1000;
		int remind = money - pay;

		for (int i = 0; i < coins.length; i++) {
			if( coins[i] <= remind ) {
				count += (remind/coins[i]);
				remind %= coins[i];
			}
		}
		
		System.out.println(count);
	}
}