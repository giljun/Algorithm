import java.util.HashSet;
import java.util.Set;

public class Solution_FindPrime {
	
	static int cnt;
	static Set<Integer> set;
	
	public static void main(String[] args) {
		String numbers = "011";

		int res = solution(numbers);

		System.out.println(res);
	}

	public static int solution(String numbers) {
		int answer = 0;

		int[] narr = new int[numbers.length()];

		for (int i = 0; i < narr.length; i++) {
			narr[i] = numbers.charAt(i) - '0';
		}
		
		set = new HashSet<>();
		cnt = 0;
		int n = narr.length;
		String num = "";
		for (int i = 0; i < (1 << n); i++) {
			num = "";
			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) != 0) {
					num += narr[j];
				}
			}
			if (num == "") {
				continue;
			} else {
				calc(num);
			}
		}
		
		answer = set.size();
		
		return answer;
	}

	private static void calc(String num) {
		boolean[] visited = new boolean[num.length()];
		
		dfs(num, visited, 0, num.length(), "");
	}

	private static void dfs(String n, boolean[] visited, int depth, int k, String res) {
		if( depth == k ) {
			isPrime(res);
			return;
		}
		
		for (int i = 0; i < n.length(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				res += n.charAt(i);
				dfs(n, visited, depth+1, k, res);
				res = res.substring(0, res.length()-1);
				visited[i] = false;
			}
		}
	}

	private static void isPrime(String num) {
		int n = Integer.parseInt(num);
		boolean isok = true;

		if (n > 1) {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					isok = false;
				}
			}
		} else {
			isok = false;
		}
		
		if(isok) {
			set.add(n);
		}
	}
}
