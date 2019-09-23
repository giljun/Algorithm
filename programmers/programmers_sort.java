import java.util.Arrays;

public class programmers_sort {

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] res = solution(array, commands);
		
		print(res);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int cnt = 0;
		for (int i = 0; i < commands.length; i++) {
			int lenth = (commands[i][1]-commands[i][0])+1;
			int[] temp = new int[lenth];
			
			int start = commands[i][0];
			int end = commands[i][1];
			int idx = 0;
			for (int j = start-1; j < end; j++) {
				temp[idx] = array[j];
				idx++;
			}
			
			Arrays.sort(temp);
			
			int k = commands[i][2]-1;
			answer[cnt++] = temp[k];
		}
		return answer;
	}

	private static void print(int[] temp) {
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]+" ");
		}
		System.out.println();
	}
}
