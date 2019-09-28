package boj;

import java.util.Arrays;

public class programmers_stickers {
	public static void main(String[] args) {
		int[] sticker = { 12, 12, 12, 12, 12 };

		int max = solution(sticker);

		System.out.println(max);
	}

	public static int solution(int[] sticker) {
		int[] dp = new int[sticker.length];

		dp[0] = sticker[0];
		if (sticker[0] > sticker[1]) {
			dp[1] = sticker[0];
		} else {
			dp[1] = sticker[1];
		}
		
		for (int i = 2; i < sticker.length; i++) {
			if( dp[i-2] + sticker[i] > dp[i-1]) {
				dp[i] = dp[i-2] + sticker[i];
			}else {
				dp[i] = dp[i-1];
			}
		}

		return dp[dp.length - 1];
	}
}
