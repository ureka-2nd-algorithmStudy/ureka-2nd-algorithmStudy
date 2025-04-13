package simulation;

import java.util.Arrays;

public class p_공원 {

    // Solution 클래스
    static class Solution {
        public int solution(int[] mats, String[][] park) {

            // 매트 크기  오름차순 정렬 후 뒤에서부터 탐색
            Arrays.sort(mats);

            // 공원 전체 크기 
            int x = park.length;
            int y = park[0].length;
            
            

            for (int m = mats.length - 1; m >= 0; m--) { // 매트 오름차순 정렬 했으니 제일 큰 매트부터 확인
                int size = mats[m];

                for (int i = 0; i <= x - size; i++) {
                    for (int j = 0; j <= y - size; j++) {
                        if (can(park, i, j, size)) {
                            return size;
                        }
                    }
                }
            }

            return -1; // 깔 수 있는 돗자리가 없음
        }

        // 정사각형 크기만큼 "-1"이 연속으로 있는지 확인
        private boolean can(String[][] park, int x, int y, int size) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (!park[i][j].equals("-1")) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    // Main 메서드
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] mats = {5, 3, 2};
        String[][] park = {
            {"-1", "-1", "-1", "1", "-1"},
            {"-1", "-1", "-1", "1", "-1"},
            {"-1", "-1", "-1", "-1", "-1"},
            {"1", "1", "-1", "-1", "-1"},
            {"-1", "-1", "-1", "-1", "-1"}
        };

        int result = sol.solution(mats, park);
        System.out.println(result);  // 출력: 3
    }
}
