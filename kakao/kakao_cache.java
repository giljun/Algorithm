import java.util.LinkedList;
import java.util.Queue;


public class kakao_cache {

	public static void main(String[] args) {
		
	}
}

class Solution {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;

		Queue<String> cache = new LinkedList<String>();

		for (int i = 0; i < cities.length; i++) {
			// 1. ť�� �ش��ϴ� ���ø��� �����ϸ�, hit
			// 2. ť�� �ش��ϴ� ���ø��� �������� �ʴ´ٸ�, miss
			String city = cities[i].toLowerCase();
			
			if(cache.contains(city)) {
				answer += 1;
				cache.remove(city);
				cache.add(city);
			}else {
				if(cache.size() < cacheSize) {
					cache.add(city);
				}else {
					cache.poll();
					if(cache.size() < cacheSize){
						cache.add(city);
					}
				}
				answer += 5;
			}
		}
		return answer;
	}
}