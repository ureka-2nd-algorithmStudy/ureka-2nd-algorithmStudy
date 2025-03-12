package Week_05;

import java.util.*;

public class Solution_단어_변환 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean targetExists = false;
        for (String word : words) {
            if (word.equals(target)) {
                targetExists = true;
                break;
            }
        }

        if (!targetExists) return 0;

        return solve(begin, target, words);
    }

    private int solve(String begin, String target, String[] words) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.word.equals(target)) {
                return node.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && check(node.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], node.count + 1));
                }
            }
        }

        return 0;
    }

    private boolean check(String a, String b) {
        int difference = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                difference++;
            }
        }

        return difference == 1;
    }

    static class Node {
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
