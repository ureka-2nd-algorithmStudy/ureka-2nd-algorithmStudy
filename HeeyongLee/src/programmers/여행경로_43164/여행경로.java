package programmers.여행경로_43164;

import java.util.ArrayList;
import java.util.Collections;

public class 여행경로 {
    static ArrayList<String> result = new ArrayList<>();
    static boolean[] visited;
    static int tSize;

    public static void main(String[] args) {
        String[] result1 = new 여행경로().solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
    }

    public String[] solution(String[][] tickets) {
        tSize = tickets.length;
        visited = new boolean[tSize];

        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(result);

        String[] answer = result.get(0).split(" ");
        return answer;
    }

    static void dfs(int idx, String start, String current, String[][] tickets) {
        if (idx == tSize) {
            result.add(current);
            return;
        }

        for (int i = 0; i < tSize; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(idx + 1, tickets[i][1], current + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
        return;
    }
}
