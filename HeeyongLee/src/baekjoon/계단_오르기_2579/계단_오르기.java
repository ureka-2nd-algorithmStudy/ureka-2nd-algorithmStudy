import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단_오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 계단의 수
        int[] stairs = new int[N + 1];  // 계단의 점수
        int[] memoi = new int[N + 1];  // 각 계단까지의 최대 점수

        // 계단 점수 입력
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());;
        }

        // 기본 케이스
        if (N == 1) {
            System.out.println(stairs[1]);
            return;
        }
        if (N == 2) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        }

        memoi[1] = stairs[1];
        memoi[2] = stairs[1] + stairs[2];  // 두 번째 계단은 첫 번째 계단 + 두 번째 계단

        // DP 배열 채우기
        for (int i = 3; i <= N; i++) {
            memoi[i] = Math.max(memoi[i - 2] + stairs[i], memoi[i - 3] + stairs[i - 1] + stairs[i]);
        }

        // 마지막 계단까지의 최대 점수 출력
        System.out.println(memoi[N]);
    }
}
