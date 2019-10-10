import java.util.HashSet;
import java.util.Iterator;

public class programmers_divisor2 {

	public static void main(String[] args) {
		int n = 12;
		
		int answer = solution(n);
		
		System.out.println(answer);
	}

	public static int solution(int n) {
		int answer = 0;

		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				int m = n / i;

				set.add(i);
				set.add(m);
			}
		}

		for(Iterator<Integer> it = set.iterator(); it.hasNext();) {
			answer += it.next();
		}

		return answer;
	}
}
