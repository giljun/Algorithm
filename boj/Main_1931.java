import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		Meeting[] m = new Meeting[n];

		for (int i = 0; i < m.length; i++) {
			st = new StringTokenizer(br.readLine());
			m[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(m, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				if (o1.end == o2.end) {
					return o1.start - o2.start;
				} else {
					return o1.end - o2.end;
				}
			}
		});

		int count = 0;
		Meeting cur = new Meeting(0, -1);
		for (int i = 0; i < m.length; i++) {
			if (cur.end <= m[i].start) {
				cur.end = m[i].end;
				count++;
			}
		}

		System.out.println(count);

	}

	static class Meeting {
		int start;
		int end;

		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
