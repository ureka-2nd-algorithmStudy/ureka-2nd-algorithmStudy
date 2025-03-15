package baekjoon.완전_이진_트리_9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 완전_이진_트리 {

    static int depth;
    static int[] input;
    static List<List<Integer>> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        depth = Integer.parseInt(br.readLine());
        int N = (int) Math.pow(2, depth) - 1;
        input = new int[N];
        answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < depth; i++) {
            answer.add(new ArrayList<>());
        }

        search(0, N - 1, 0);
        for (List<Integer> e : answer) {
            for (Integer ans : e) {
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }

    private static void search(int l, int r, int depth) {
        if (l > r) {
            return;
        }

        int mid = (l + r) / 2;
        answer.get(depth).add(input[mid]);

        search(l,mid-1,depth+1); // 좌측 트리
        search(mid + 1, r, depth + 1); // 우측 트리
    }
}
