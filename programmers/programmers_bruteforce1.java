import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class programmers_bruteforce1 {
	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };

		int[] ans = solution(answers);

		System.out.println(ans.toString());
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};
		
		answer = new int[3];

		ArrayList<Student> students = new ArrayList<>();

		int[] stu1 = { 1, 2, 3, 4, 5 };
		int[] stu2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] stu3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;

		int idx1 = 0;
		int idx2 = 0;
		int idx3 = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == stu1[idx1]) {
				cnt1++;
			}
			idx1++;
			if (stu1.length == idx1) {
				idx1 = 0;
			}

			if (answers[i] == stu2[idx2]) {
				cnt2++;
			}
			idx2++;
			if (stu2.length == idx2) {
				idx2 = 0;
			}

			if (answers[i] == stu3[idx3]) {
				cnt3++;
			}
			idx3++;
			if (stu3.length == idx3) {
				idx3 = 0;
			}
		}

		System.out.println(cnt1 + " " + cnt2 + " " + cnt3);

		students.add(new Student(1, cnt1));
		students.add(new Student(2, cnt2));
		students.add(new Student(3, cnt3));

		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o2.cnt > o1.cnt) {
					return 1;
				}else if( o2.cnt < o1.cnt ) {
					return -1;
				}else {
					return o1.num - o2.num;
				}
			}
		});
		
		int win = students.get(0).cnt;
		
		ArrayList<Student> winner = new ArrayList<>();
		
		for (int i = 0; i < students.size(); i++) {
			if( win == students.get(i).cnt ) {
				winner.add(students.get(i));
			}
		}
		
		answer = new int[winner.size()];
		
		for (int i = 0; i < winner.size(); i++) {
			answer[i] = winner.get(i).num;
		}
		
		return answer;
	}

	static class Student {
		int num;
		int cnt;

		public Student(int n, int c) {
			this.num = n;
			this.cnt = c;
		}
	}
}
