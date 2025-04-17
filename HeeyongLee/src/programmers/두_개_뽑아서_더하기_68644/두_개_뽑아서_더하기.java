package programmers.두_개_뽑아서_더하기_68644;

import java.util.HashSet;
import java.util.Set;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int temp = numbers[i-1] + numbers[j];
                set.add(temp);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
