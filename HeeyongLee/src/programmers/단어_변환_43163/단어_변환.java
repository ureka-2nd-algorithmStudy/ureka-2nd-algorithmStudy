package programmers.단어_변환_43163;

import programmers.같은_숫자는_싫어_12906.같은_숫자는_싫어;

public class 단어_변환 {

    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) {
        int answer1 = new 단어_변환().solution("hit", "cog", new String[]{"hot","dot", "dog", "lot", "log", "cog"});
        int answer2 = new 단어_변환().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});

        System.out.println(answer1);
        System.out.println(answer2);
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = 0;

        dfs(begin, target, words, 0);

        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }

    }
}
