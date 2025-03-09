import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        System.out.println(solution(x, y));
    }

    private static long solution(long x, long y) {
        long lt = 0;
        long rt = 1_000_000_000;
        long originalWinPercentage = (100 * y / x);
        long minGame = Integer.MAX_VALUE;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            long winPercentage = calculWinPercentage(mid, x, y);

            if (winPercentage > originalWinPercentage) {
                rt = mid - 1;
                minGame = Math.min(minGame, mid);
            } else {
                lt = mid + 1;
            }
        }

        if (minGame == Integer.MAX_VALUE) return -1;
        else return minGame;
    }

    private static long calculWinPercentage(long mid, long x, long y) {
        x+=mid;
        y+=mid;
        return (100*y/x);
    }
}
