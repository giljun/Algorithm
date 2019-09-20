import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class programmers_hash1 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		String ans = solution(participant, completion);
		
		System.out.println(ans);
	}
	
	// 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주.
	// 완주 하지 못한 선수의 이름을 출력하는 프로그램을 작성한다.
	// 마라톤 경기에 참여하는 선수의 수는 1명 이상 100,000명 이하입니다.
	// completion의 길이는 participant의 길이보다 1 작습니다.
	// 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
	// 참가자 중에는 동명이인이 있을 수 있습니다.
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        // 입력 완료
        for (int i = 0; i < participant.length; i++) {
        	if(hashmap.containsKey(participant[i])) {
        		int cnt = hashmap.get(participant[i]);
        		hashmap.put(participant[i], cnt+1);	
        	}else {
        		hashmap.put(participant[i], 1);
        	}
		}
        
        for (int i = 0; i < completion.length; i++) {
        	if(hashmap.containsKey(completion[i])) {
        		int cnt = hashmap.get(completion[i])-1;
        		hashmap.put(completion[i], cnt);
        	}
		}
        
        for (String key : hashmap.keySet()) {
			if(hashmap.get(key)==1) {
				answer = key;
				break;
			}
		}
        return answer;
    }
	
}
