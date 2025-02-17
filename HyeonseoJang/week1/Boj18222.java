import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj18222 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        long size = 1;

        // k 번째 수를 구할 수 있을 때까지만 size를 증가
        while (size < k) {
            size *= 2;
        }

        System.out.println(solution(k, size));
    }

    private static int solution(long k, long size) {
		    // 첫번째 문자는 0임
        if (size == 1) return 0;

        long mid = size / 2;

        if (k > mid) {
            k -= mid;
            return (solution(k, mid) == 0) ? 1 : 0;
        } else return solution(k, mid);
    }
}
