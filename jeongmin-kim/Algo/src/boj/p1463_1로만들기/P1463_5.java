package boj.p1463_1로만들기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463_5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] cnt = new int[N + 1];
		cnt[1] = 0;
		cnt[2] = 1;
		cnt[3] = 1;
		
		for (int i = 4; i <= N; i++) {
			cnt[i] = cnt[i - 1] + 1;
			if (i % 2 == 0) cnt[i] = Math.min(cnt[i], cnt[i / 2] + 1);
			if (i % 3 == 0) cnt[i] = Math.min(cnt[i], cnt[i / 3] + 1);
		}

		System.out.println(cnt[N]);
	}
}
