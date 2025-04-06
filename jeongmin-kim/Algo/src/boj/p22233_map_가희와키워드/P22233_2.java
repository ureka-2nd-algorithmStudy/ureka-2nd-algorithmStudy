package boj.p22233_map_가희와키워드;

import java.util.*;

public class P22233_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄 입력
        int n = scanner.nextInt();  // 키워드 개수
        int m = scanner.nextInt();  // 블로그 글 개수
        scanner.nextLine(); // 개행 문자 소비

        // 키워드 저장 (검색 및 삭제 최적화를 위해 HashSet 사용)
        Set<String> keywordSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            keywordSet.add(scanner.nextLine());
        }

        // 블로그 글에서 키워드 제거
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(scanner.nextLine(), ",");
            while (st.hasMoreTokens()) {
                keywordSet.remove(st.nextToken()); // O(1) 연산
            }
            System.out.println(keywordSet.size());
        }
    }
}
