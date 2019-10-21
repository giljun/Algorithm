import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_10610 {

	static String n;
	static int[] arr;
	static String num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		n = st.nextToken();
		
		int len = n.length();
		
		arr = new int[len];
		
		for (int i = 0; i < n.length(); i++) {
			arr[i] = n.charAt(i)-'0';
		}
		
		Arrays.sort(arr);
		
		num = "";
		if(arr[0] == 0) {
			// ³ª¸ÓÁö
			int m = 0;
			int tmp = 0;
			for (int i = 1; i < arr.length; i++) {
				m = arr[i]%3;
				tmp += m;
			}
			if( tmp % 3 == 0) {
				for (int i = arr.length-1; i >= 0; i--) {
					num += arr[i];
				}
			}else {
				num += -1;
			}
		}else {
			num += -1;
		}
		
		System.out.println(num);

	}

	private static void print() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	
}
