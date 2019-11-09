import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		String[] ex = br.readLine().split("\\-");
		
		String[] e = ex[0].split("\\+");
		int sum = 0;
		for (int i = 0; i < e.length; i++) {
			sum += Integer.parseInt(e[i]);
		}
		
		for (int i = 1; i < ex.length; i++) {
			e = ex[i].split("\\+");
			for (int j = 0; j < e.length; j++) {
				sum -= Integer.parseInt(e[j]);
			}
		}
		
		System.out.println(sum);
	}
}
