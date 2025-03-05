package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class p_캐릭터의좌표 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 방향 입력
		StringTokenizer st = new StringTokenizer(br.readLine(),",");
		List<String> keyinput = new ArrayList<>();
		while(st.hasMoreTokens()) {
			keyinput.add(st.nextToken().trim());
		}
		
		// 맵 크기 입력
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] result = solution(keyinput.toArray(new String[0]), new int[] {w, h});
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] solution(String[] keyinput, int[] board) {
		int x = 0;
		int y = 0;
		int maxX = board[0] / 2; // 가로 10 이면 왼 오 각 5만큼만 이동 가능
		int maxY = board[1] / 2;
		
		HashMap<String, int[]> hashMap = new HashMap<>();
		
		hashMap.put("left", new int[] {-1, 0});
		hashMap.put("right", new int[] {1, 0});
		hashMap.put("up", new int[] {0, 1});
		hashMap.put("down", new int[] {0, -1});
		
		//
		for ( String key : keyinput ) {
			int[] move = hashMap.get(key); // up 인 경우 move = { 0, 1 } 임
			int newX = x + move[0]; // 현재 좌표에 이동한 값 더한다.
			int newY = y + move[1];
			
			if (Math.abs(newX) <= maxX && Math.abs(newY) <= maxY) { // 좌표 절대닶을 통하여 최대 범위 넘는지 확인
				x = newX; // 범위 넘지 않으면 이동한 좌표 저장
				y = newY;
			}
		}
		
		return new int[] {x, y};
	}

}


