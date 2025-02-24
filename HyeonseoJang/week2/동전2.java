
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dy = new int[10001];
        int[] coins = new int[n];

				// 각 동전의 가치를 배열로 저장
        for(int i=0;i<n;i++) coins[i] = Integer.parseInt(br.readLine());
				
				// 각 dy배열을 MAX값으로 초기화
        Arrays.fill(dy, Integer.MAX_VALUE);
        // 가치가 0일때는 만들 수 없음
        dy[0] = 0;
        
        // 동전의 개수만큼 반복
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=k;j++){
                if(dy[j-coins[i]] != Integer.MAX_VALUE){
                    dy[j] = Math.min(dy[j], dy[j-coins[i]]+1);
                }
            }
        }
        
        // dp배열에 아직 MAX값이면 못만드는거
        if(dy[k] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dy[k]);
    }
}
