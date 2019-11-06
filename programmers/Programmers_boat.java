import java.util.Arrays;

public class Programmers_boat {

	public static void main(String[] args) {
		int[] people = { 70, 80, 50 };
		int limit = 100;

		int ans = solution(people, limit);

		System.out.println(ans);
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);

		int end = people.length - 1;
		int index = 0;
		for (int i = index; i < end; end--) {
			if(people[i]+people[end] > limit) {
				// 최소 + 최대를 더한 값이 제한 값보다 크다면,
				answer++;
			}else {
				answer++;
				i++;
				index++;
			}
		}
		if( index == end ) {
			answer++;
		}
		return answer;
	}

}
