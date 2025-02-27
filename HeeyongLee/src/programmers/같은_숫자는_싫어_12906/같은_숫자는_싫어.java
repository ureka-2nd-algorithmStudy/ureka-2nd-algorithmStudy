package programmers.같은_숫자는_싫어_12906;

import java.util.ArrayDeque;
import java.util.Deque;

public class 같은_숫자는_싫어 {

    public static void main(String[] args) {
        int[] answer1 = new 같은_숫자는_싫어().solution(new int[]{1,1,3,3,0,1,1}); // 1,3,0,1
        int[] answer2 = new 같은_숫자는_싫어().solution(new int[]{4,4,4,3,3}); // 4,3
        for (int i : answer1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : answer2) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        int idx = stack.size()-1;
        int[] answer = new int[stack.size()];
        for (Integer i : stack) {
            answer[idx--] = i;
        }
        return answer;
    }
}
