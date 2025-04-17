package programmers;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값_만들기_12941 {

    public int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] BI = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(A);
        Arrays.sort(BI, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * BI[i];
        }

        return answer;
    }
}
