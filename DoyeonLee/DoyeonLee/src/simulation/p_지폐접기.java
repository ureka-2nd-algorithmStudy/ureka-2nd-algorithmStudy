package simulation;

public class p_지폐접기 {
    static class Solution {
        public int solution(int[] wallet, int[] bill) {
            int w1 = wallet[0];
            int w2 = wallet[1];
            int b1 = bill[0];
            int b2 = bill[1];
            int answer = 0;

            while (true) {
                if ((b1 <= w1 && b2 <= w2) || (b2 <= w1 && b1 <= w2)) { // 크기 조건, 회전 가능
                    return answer;
                }

                if (b1 >= b2) { // 들어가지 않는 경우  긴 쪽 길이를 반으로 나누기
                    b1 = b1 / 2;
                } else {
                    b2 = b2 / 2;
                }

                answer++; // 접근 횟수 ++
            }
        }
    }

    public static void main(String[] args) {
        // 입력 하드코딩
        int[] wallet = {30, 15}; 
        int[] bill = {26, 17};   

        Solution sol = new Solution();
        int result = sol.solution(wallet, bill);

        System.out.println(result);
    }
}
