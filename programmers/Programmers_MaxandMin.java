import java.util.Arrays;

class Programmers_MaxandMin {

	public static void main(String args[]) {
		String s = "1 2 3 4";
		
		String result = solution(s);
		
		System.out.println(result);
	}

	public static String solution(String s) {
		String answer = "";
		
		String[] arr = s.split(" ");
		
		int[] array = new int[arr.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		
		Arrays.sort(array);
		
		answer = array[0] + " " + array[array.length-1];
		
		return answer;
	}
}