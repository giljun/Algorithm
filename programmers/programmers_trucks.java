package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_trucks {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

		int time = solution(bridge_length, weight, truck_weights);

		System.out.println(time);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		int weightLeft = weight;
		
		Queue<Truck> out = new LinkedList<>();
		ArrayList<Truck> in = new ArrayList<>();

		for (int t : truck_weights) {
			out.add(new Truck(t, bridge_length));
		}

		while (!(out.isEmpty() && in.isEmpty())) {
			time++;
			
			if(!in.isEmpty() && in.get(0).distance == 0) {
				weightLeft += in.get(0).weight;
				in.remove(0);
			}
			
			if(!out.isEmpty() && out.peek().weight <= weightLeft ) {
				weightLeft -= out.peek().weight;
				in.add(out.poll());
			}
			
			for (int i = 0; i < in.size(); i++) {
				in.get(i).distance--;
			}
		}
		
		return time;
	}

	static class Truck {
		int weight;
		int distance;

		Truck(int w, int d) {
			this.weight = w;
			this.distance = d;
		}
	}
}
