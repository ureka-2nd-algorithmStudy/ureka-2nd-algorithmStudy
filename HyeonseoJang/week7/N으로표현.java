import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int N, int number) {
        // N이 바로 정답인 경우
        if (N == number) {
            return 1;
        }

        // 1~8까지 사용 횟수별로 만들 수 있는 숫자들을 저장할 배열
        Set<Integer>[] sets = new HashSet[9];

        // 초기화
        for (int i = 1; i <= 8; i++) {
            sets[i] = new HashSet<>();
        }

        // N을 1번 사용해서 만들 수 있는 숫자는 N 자체
        sets[1].add(N);

        // 2~8번 사용해서 만들 수 있는 숫자들 계산
        for (int i = 2; i <= 8; i++) {
            // N을 i번 이어붙인 숫자 추가 (예: 5, 55, 555, ...)
            int concatenated = 0;
            for (int j = 0; j < i; j++) {
                concatenated = concatenated * 10 + N;
            }
            sets[i].add(concatenated);

            // 1~(i-1)번 사용한 결과와 (i-j)번 사용한 결과를 조합
            for (int j = 1; j < i; j++) {
                for (int op1 : sets[j]) {
                    for (int op2 : sets[i - j]) {
                        sets[i].add(op1 + op2);
                        sets[i].add(op1 - op2);
                        sets[i].add(op1 * op2);
                        if (op2 != 0) {
                            sets[i].add(op1 / op2);
                        }
                    }
                }
            }

            // i번 사용해서 만든 숫자 중에 목표 숫자가 있는지 확인
            if (sets[i].contains(number)) {
                return i;
            }
        }

        // 8번 이하로 만들 수 없는 경우
        return -1;
    }
}
