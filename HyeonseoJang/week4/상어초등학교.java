package algo.study.week3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 상어초등학교 {
    static int n, answer;
    static Student[][] classRoom;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        classRoom = new Student[n][n];

        List<Student> studentList =  input(br);

        // 학생 배치 시작
        for(int i=0;i<studentList.size();i++){
            Student nowStudent = studentList.get(i);
            // 탐색 후 가장 우선인 곳 반환
            Point p = searchMap(nowStudent);
            classRoom[p.y][p.x] = nowStudent;
        }

        // 만족도 계산
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Student now = classRoom[i][j];
                int likeCnt = 0;
                for(int k=0;k<4;k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < n && now.likes.contains(classRoom[ny][nx].num)){
                        likeCnt++;
                    }
                }
                switch(likeCnt){
                    case 1 : answer++; break;
                    case 2 : answer += 10;break;
                    case 3 : answer +=100; break;
                    case 4 : answer +=1000; break;
                }
            }
        }

        System.out.println(answer);
    }

    private static Point searchMap(Student student){
        PriorityQueue<Point> pQ = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(classRoom[i][j] != null) continue;
                // 사방탐색으로 빈 좌표랑 인접한 좋아하는 학생 계산
                int stuCnt=0;
                int emptyCnt=0;
                for(int k=0;k<4;k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < n){
                        if(classRoom[ny][nx] == null) emptyCnt++;
                        else if(student.likes.contains(classRoom[ny][nx].num)) stuCnt++;
                    }
                }
                pQ.offer(new Point(stuCnt, emptyCnt, i, j));
            }
        }
        return pQ.poll();
    }

    private static List<Student> input(BufferedReader br) throws IOException {
        ArrayList<Student> list = new ArrayList<>();
        for(int i=0;i<n*n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Student stu = new Student(Integer.parseInt(st.nextToken()));
            for(int j=0;j<4;j++){
                stu.likes.add(Integer.parseInt(st.nextToken()));
            }
            list.add(stu);
        }
        return list;
    }


    static class Student{
        int num;
        List<Integer> likes;

        Student(int num){
            this.num = num;
            this.likes = new ArrayList<>();
        }
    }

    static class Point implements Comparable<Point>{
        int studentCnt;
        int emptyCnt;
        int y, x;

        Point(int studentCnt, int emptyCnt, int y, int x){
            this.studentCnt = studentCnt;
            this.emptyCnt = emptyCnt;
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Point o){
            if(this.studentCnt != o.studentCnt) return o.studentCnt - this.studentCnt;
            else if(this.emptyCnt != o.emptyCnt) return o.emptyCnt - this.emptyCnt;
            else if(this.y != o.y) return this.y - o.y;
            else return this.x - o.x;
        }
    }
}
