package boj.p22233_map_가희와키워드;

import java.util.*;

public class P22233_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄 입력
        int n = scanner.nextInt();  // 키워드 개수
        int m = scanner.nextInt();  // 블로그 글 개수
        scanner.nextLine(); // 개행 문자 소비

        // 키워드 저장 (List 사용)
        List<String> keywordList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            keywordList.add(scanner.nextLine());
        }

        // 블로그 글에서 키워드 제거
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(scanner.nextLine(), ",");
            while (st.hasMoreTokens()) {
                keywordList.remove(st.nextToken()); // O(n) 연산 (리스트 탐색 및 삭제)
            }
            System.out.println(keywordList.size());
        }
    }
}
