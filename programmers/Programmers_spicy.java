import java.util.PriorityQueue;

class Programmers_spicy {

	public static void main(String args[]) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;

		int ans = solution(scoville, K);

		System.out.println(ans);
	}

	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			queue.add(scoville[i]);
		}

		int count = 0;
		while (true) {
			if (queue.peek() >= K) {
				break;
			}
			if (queue.size() == 1 && queue.peek() < K) {
				count = -1;
				break;
			}
			queue.add(queue.poll() + (queue.poll() * 2));
			count++;
		}

		return count;
	}
}