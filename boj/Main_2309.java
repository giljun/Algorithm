import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_2309 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int[] dwarf = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}
		
		boolean ischecked = false;
		for (int i = 0; i < dwarf.length; i++) {
			for (int j = 0; j < dwarf.length; j++) {
				if (i != j && sum - (dwarf[i] + dwarf[j]) == 100) {
					dwarf[i] = Integer.MIN_VALUE;
					dwarf[j] = Integer.MIN_VALUE;
					ischecked = true;
					break;
				}
			}
			if (ischecked) {
				break;
			}
		}
		
		Arrays.sort(dwarf);
		
		for (int i = 2; i < dwarf.length; i++) {
			System.out.println(dwarf[i]);
		}
	}

}