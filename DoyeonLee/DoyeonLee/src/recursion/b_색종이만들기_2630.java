package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_색종이만들기_2630 {

	   public static int white = 0; // 하얀색 종이 개수 변수
	   public static int blue = 0; // 파란색 종이 개수 변수
	   public static int[][] paper; // 종이의 색을 나타내는 데이터

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 사용자 입력
	        int N = Integer.parseInt(br.readLine());
	        paper = new int[N][N];
	        for (int i = 0; i < N; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < N; j++) {
	                paper[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
	        divide(0,0,N); // 종이 나누는 작업
	        System.out.println(white); // 하얀색 종이 개수
	        System.out.println(blue); // 파란색 종이 개수 
	    }

	    public static void divide(int row,int col,int size) { // 색깔이 같으면 해당 색 증가 시키기, 색깔이 다른 경우 나누기
	           if(checkColor(row,col,size)){ //1 색깔이 같은 지 확인
	            if(paper[row][col]==0){ //2 checkColor 에서 색깔이 같아 true를 반환하여 어떤 색인지 확인
	                white++; //3 0 이면 하얀색 개수 증가
	            }else{ //4 
	                blue++; //5 0 이 아니면 파란색 개수 증가
	            }
	            return; //6
	        }
	        int newSize = size/2; //7 checkCoplor false 반환되는 경우 사이즈 반으로 나눠서 구역을 나눈다.
	        divide(row,col,newSize); //8 n=4, row,col (0,0)이면 newSize=4/2=2 (0,0,2) 왼쪽상단
	        divide(row,col+newSize,newSize); //9 (0,2,0) 오른쪽 상단
	        divide(row+newSize,col,newSize); //10 (2,0,2) 왼쪽 하단
	        divide(row+newSize,col+newSize,newSize); //11 (2,2,0) 오른쪽 하단
	    }
	    public static boolean checkColor(int row, int col, int size){ // 1-1 선택된 구역이 같은 색으로 되어 있는지 확인
	        int color = paper[row][col]; //기준 좌표의 색 지정
	        for(int i=row; i<row+size; i++){ //세로방향 확인
	            for(int j=col; j<col+size; j++){ // 가로방향 확인
	                if(paper[i][j]!=color){ // 기준 좌표의 색 이랑 다른게 있는 경우 false 반환
	                    return false; 
	                }
	            }
	        }
	        return true; // 기준 좌표의 색이랑 비교한 구욕의 칸이 모두 동일하면 true 반환
	    }
	}

