package baekjoon.쇠막대기_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 쇠막대기 {

    public static void main(String[] args) throws IOException {
        Deque<Character> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                continue;
            }
            // ( 가 아닐 경우 쇠막대기의 끝이거나, 레이저가 지나가는 지점이다
            stack.pop();
            // 만약 현재 위치에서 한칸 앞 입력이 ( 라면 레이저가 지나가는 지점
            if (input.charAt(i - 1) == '(') {
                answer += stack.size();
            } else {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
