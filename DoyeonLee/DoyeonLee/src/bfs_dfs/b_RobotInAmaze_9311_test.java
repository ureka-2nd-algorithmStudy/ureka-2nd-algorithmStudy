package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_RobotInAmaze_9311_test {

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int M = Integer.parseInt(br.readLine());
	        for(int i = 0; i < M; i++) { // 미로 총 개수(케이스) M개, 예제 3개
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int R = Integer.parseInt(st.nextToken()); // rows , 예제 7
	            int C = Integer.parseInt(st.nextToken()); // columns, 예제 8
	            
	            char[][] maze = new char[R][C];
	            int startX = -1, startY = -1; // 시작지점 초기화
//	            int startX = 0, startY = 0;  // 0,0 이 시작점일 가능성 존재
	            
	            for ( int j = 0; j < R; j++) {
	                String line = br.readLine();
	                for ( int k = 0; k < C; k++) {
	                    maze[j][k] = line.charAt(k);
	                    if (maze[j][k] == 'S') { //S는 시작지점으로 지정
	                        startX = j;
	                        startY = k;
	                    }
	                }
	            }
	            
	    
	            
	            int result = bfs(maze, startX, startY, R, C);
	            
	            if (result == -1) { // 이동하지 않았으면 -1 이면
	                System.out.println("No Exit");
	            } else { // 이동하였으면 거리 출력
	                System.out.println("Shortest Path: " + result);
	            }
	        
	            
	        }
	    }
	    public static int bfs(char[][] maze, int startX, int startY, int R, int C) {
	    	int[] dx = {-1, 1, 0, 0}; // 위 아래
	    	int[] dy = {0, 0, -1, 1}; // 왼 오
	    	
	    	boolean[][] visited = new boolean[R][C]; // 방문 
	    	visited[startX][startY] = true; // 시작지점
	    	
	    	// 큐 생성
	    	 Queue<int[]> queue = new LinkedList<>();
	         queue.offer(new int[]{startX, startY, 0}); // (startx, starty) 위치에서 시작, 거리 0 (시작칸은 0로 시작)
	    	
	    	while (!queue.isEmpty()) {
	    		int[] current = queue.poll();
	    		int x = current[0];
	    		int y = current[1];
	    		int dist = current[2];
	    		
	    		// 목표 지점에 도달 하면 거리 계싼
	    		if (maze[x][y] == 'G') {
	    			return dist;
	    		}
	    		
	    		// 상하좌우
	    		for (int i = 0; i < 4; i++) {
	               
	                int moveX = x + dx[i];
	                int moveY = y + dy[i];
	                
	                // 범위 확인 및 이미 방문했는지 확인
	                if(moveX >= 0 && moveX < R && moveY >= 0 && moveY < C && !visited[moveX][moveY] && maze[moveX][moveY] != 'X') {
	                	visited[moveX][moveY] = true;
	                	queue.offer(new int[] {moveX, moveY, dist + 1}); //  새로운 위치로 이동하고 거리는 + 1
	                }
	    		}
	    	}
	    	
	    	return -1; // 목표 지점까지 갈 수 없는 경우는 -1 반환
	    	
	    	
	    }
	}

/*
 * 
3
7 8
XXXXXXXX
XSOOXOOX
XOXOOOOX
XOXXXOOX
XOXOXXOX
XOOOXOOX
XXXXXGXX
4 4
XGXX
XSOX
XOOX
XGGX
4 4
XXXX
XSOX
XXXX
XXGX
 */
 
