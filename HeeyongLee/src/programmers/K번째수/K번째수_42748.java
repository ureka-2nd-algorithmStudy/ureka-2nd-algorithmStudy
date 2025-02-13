package programmers.K번째수;

import java.util.Arrays;

public class K번째수_42748 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new K번째수_42748().solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
        ))); // {5, 6, 3}
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] splitArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(splitArr);
            answer[i] = splitArr[commands[i][2] - 1];
        }
        return answer;
    }
}
