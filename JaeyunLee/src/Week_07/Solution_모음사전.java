package Week_07;

import java.util.*;

public class Solution_모음사전 {

    private int indexCount = 0;
    private final int BREAK_DEPTH = 5;
    private final char[] words = {'A', 'E', 'I', 'O', 'U'};
    private final Map<String, Integer> map = new HashMap<>();

    public int solution(String word) {
        dfs("", 0);
        return map.get(word) + 1;
    }

    private void dfs(String word, int depth) {
        if (depth == BREAK_DEPTH) {
            return;
        }

        for (char c : words) {
            map.put(word + c, indexCount++);
            dfs(word + c, depth + 1);
        }
    }
}
