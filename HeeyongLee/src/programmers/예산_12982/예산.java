package programmers.예산_12982;

import java.util.*;

public class 예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        int cnt = 0;
        for (int num : d) {
            sum += num;
            if (sum > budget) {
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }
}
