import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sumBoard = new int[board.length+1][board[0].length+1];
        
        // skill 정보 기록
        for(int[] now : skill){
            int sY = now[1];
            int sX = now[2];
            int eY = now[3];
            int eX = now[4];
            int degree = now[5];
            
            // 1이면 공격, 2면 치유
            if(now[0] == 1) degree*=-1;
            
            sumBoard[sY][sX] += degree;
            sumBoard[sY][eX+1] -=degree;
            sumBoard[eY+1][sX] -=degree;
            sumBoard[eY+1][eX+1] +=degree;
        }
        
        // 기록해놨던 누적합 배열에서 행 누적 합
        for(int i=0;i<sumBoard.length;i++){
            for(int j=1;j<sumBoard[i].length;j++){
                sumBoard[i][j] += sumBoard[i][j-1];
            }
        }
        
        // 열 누적 합
        for(int i=0;i<sumBoard[0].length;i++){
            for(int j=1;j<sumBoard.length;j++){
                sumBoard[j][i] += sumBoard[j-1][i];
            }
        }
        
        // 누적합 배열 원본 board에 반영
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                board[i][j] += sumBoard[i][j];
            }
        }
        
        // 0보다 작은거 카운트
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++) if(board[i][j] > 0 ) answer++;
        }
        
        return answer;
    }
}