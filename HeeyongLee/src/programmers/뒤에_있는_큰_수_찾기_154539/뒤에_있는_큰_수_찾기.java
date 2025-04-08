package programmers.뒤에_있는_큰_수_찾기_154539;

import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[numbers.length];

        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            // 스택이 비어있지 않으면서 현재 스택이 바라보고 있는 값보다 number의 값이 크면
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        // 모든 index를 탐색 후 뒤에 있는 큰 수가 없는 경우 -1
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
