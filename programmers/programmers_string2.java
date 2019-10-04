
public class programmers_string2 {

	public static void main(String[] args) {
		String s = "pPoooyY";

		boolean answer = solution(s);

		System.out.println(answer);
	}

	static boolean solution(String s) {
		int pnum = 0;
		int ynum = 0;

		String str = "";
		for (int i = 0; i < s.length(); i++) {
			str += s.charAt(i);
			if (str.equalsIgnoreCase("p")) {
				pnum++;
			}
			if (str.equalsIgnoreCase("y")) {
				ynum++;
			}
			str = "";
		}

		if (pnum == ynum) {
			return true;
		} else {
			return false;
		}
	}
}
