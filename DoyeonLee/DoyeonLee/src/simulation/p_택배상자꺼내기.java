package simulation;

public class p_택배상자꺼내기 {
	
    public int solution(int n, int w, int num) {
    	 
        int cnt = 0;
        while(num <= n) {
            num += (w - ((num-1) % w) -1) * 2 + 1; // 현재 번호 + 바로 윗칸 번호 
            cnt++;
        }

        // 반환
        int answer = cnt;
        return answer;
    }
}


