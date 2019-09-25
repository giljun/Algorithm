
public class programmers_number {

	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		
		int[] ans = solution(arr);
		
		print(ans);
	}
	
	private static void print(int[] ans) {
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]);
		}
	}

	public static int[] solution(int []arr) {
        int[] answer = {};
        
        int n = arr.length;
        boolean[] checked = new boolean[n];
        
        for (int i = 0; i < arr.length; i++) {
			if(!checked[i]) {
				for (int j = i+1; j < arr.length; j++) {
					if(arr[i] == arr[j]) {
						checked[j] = true;
					}else {
						break;
					}
				}
			}
		}
        
        int cnt = 0;
        for (int i = 0; i < checked.length; i++) {
			if(!checked[i]) {
				cnt++;
			}
		}
        
        answer = new int[cnt];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
			if(!checked[i]) {
				answer[idx++] = arr[i];
			}
		}
        
        return answer;
	}
}
