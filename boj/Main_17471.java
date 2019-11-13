package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {

	static int N; // 구역의 개수
	static Area[] areas;
	static int[][] matrix;
	static ArrayList<Integer> zone1, zone2;
	static boolean[] isvisited;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		areas = new Area[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			areas[i - 1] = new Area(i, Integer.parseInt(st.nextToken()));
		}

		matrix = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int adjust_count = Integer.parseInt(st.nextToken());

			for (int j = 0; j < adjust_count; j++) {
				int adjust_area = Integer.parseInt(st.nextToken());
				matrix[i][adjust_area] = 1;
			}
		}

		min = Integer.MAX_VALUE;
		// 1. 2개의 구역으로 나누기
		divideZone();
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}

	private static void divideZone() {
		for (int i = 0; i < (1 << N); i++) {
			zone1 = new ArrayList<>();
			zone2 = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					zone1.add(areas[j].num);
				} else {
					zone2.add(areas[j].num);
				}
			}
			if (isPossible(zone1, zone2)) {
				int z1_sum = 0;
				int z2_sum = 0;
				
				for (int j = 0; j < zone1.size(); j++) {
					z1_sum += areas[zone1.get(j)-1].people;
				}
				for (int j = 0; j < zone2.size(); j++) {
					z2_sum += areas[zone2.get(j)-1].people;
				}
				
				int diff = Math.abs(z1_sum - z2_sum);
				
				if(min > diff) {
					min = diff;
				}
			}
		}
	}

	private static boolean isPossible(ArrayList<Integer> zone12, ArrayList<Integer> zone22) {
		int count = 0;
		isvisited = new boolean[N + 1];

		if (zone12.size() == 0 || zone22.size() == 0) {
			return false;
		} else {
			// 첫번째 구역에 대한 BFS
			for (int i = 0; i < zone12.size(); i++) {
				if (!isvisited[zone12.get(i)]) {
					Queue<Integer> queue = new LinkedList<Integer>();
					queue.add(zone12.get(i));

					isvisited[zone12.get(i)] = true;
					count++;

					while (!queue.isEmpty()) {
						int site = queue.poll();
						for (int j = 0; j < zone12.size(); j++) {
							if (!isvisited[zone12.get(j)] && matrix[site][zone12.get(j)] == 1) {
								isvisited[zone12.get(j)] = true;
								queue.add(zone12.get(j));
							}
						}
					}
				}
			}
			// 두번째 구역에 대한 BFS
			for (int i = 0; i < zone22.size(); i++) {
				if (!isvisited[zone22.get(i)]) {
					Queue<Integer> queue = new LinkedList<Integer>();
					queue.add(zone22.get(i));

					isvisited[zone22.get(i)] = true;
					count++;

					while (!queue.isEmpty()) {
						int site = queue.poll();
						for (int j = 0; j < zone22.size(); j++) {
							if (!isvisited[zone22.get(j)] && matrix[site][zone22.get(j)] == 1) {
								isvisited[zone22.get(j)] = true;
								queue.add(zone22.get(j));
							}
						}
					}
				}
			}

			if (count == 2) {
				return true;
			} else {
				return false;
			}
		}
	}

	static class Area {
		int num;
		int people;

		Area(int n, int p) {
			this.num = n;
			this.people = p;
		}
	}
}
