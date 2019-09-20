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
	
	// �� �� ���� ������ �����ϰ�� ��� ������ �������� ����.
	// ���� ���� ���� ������ �̸��� ����ϴ� ���α׷��� �ۼ��Ѵ�.
	// ������ ��⿡ �����ϴ� ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
	// completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
	// �������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
	// ������ �߿��� ���������� ���� �� �ֽ��ϴ�.
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        // �Է� �Ϸ�
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
