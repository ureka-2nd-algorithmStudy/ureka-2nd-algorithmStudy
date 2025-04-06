package p1094_bitmasking_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1094_2 {
	
	static int idxShortest = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		List<Integer> sticks = new ArrayList<>();
		sticks.add(64);
		
		while (sum(sticks) > X) {
			// 가장 짧은 막대를 찾아서 절반으로 자르기
			int shortest = getShortest(sticks);
			sticks.remove(idxShortest); // 가장 짧은 막대 제거
			
			int half = shortest / 2;
			sticks.add(half);
			sticks.add(half); // 반으로 나눈 두 막대 추가
			
			// 하나를 버려도 여전히 X 이상이면 하나 제거
			if (sum(sticks) - half >= X) {
				sticks.remove(sticks.indexOf(half));
			}
		}
		
		System.out.println(sticks.size());
	}
	
	static int getShortest(List<Integer> sticks) {
		int min = sticks.get(0);
		idxShortest = 0; // 초기화
		for (int i = 1; i < sticks.size(); i++) {
			if (sticks.get(i) < min) {
				min = sticks.get(i);
				idxShortest = i;
			}
		}
		return min;
	}

	static int sum(List<Integer> sticks) {
		int sum = 0;
		for (int len : sticks) {
			sum += len;
		}
		return sum;
	}
}
