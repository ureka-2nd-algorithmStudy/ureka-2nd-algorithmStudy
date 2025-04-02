package Week_07;

import java.util.*;

public class Solution_N으로_표현 {
    public int solution(int N, int number) {
        return solve(N, number);
    }

    private int solve(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++)
            dp.add(new HashSet<>());

        dp.get(1).add(N);

        dp.get(2).add(N * 10 + N);
        dp.get(2).add(N + N);
        dp.get(2).add(N - N);
        dp.get(2).add(N * N);
        dp.get(2).add(N / N);

        for (int i = 3; i <= 8; i++) {
            int temp = 0;

            for (int j = 0; j < i; j++)
                temp = temp * 10 + N;
            dp.get(i).add(temp);

            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);

                        if (b > 0) {
                            dp.get(i).add(a / b);
                        }
                    }
                }
            }
        }

        for (int i = 0; i <= 8; i++) {
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
