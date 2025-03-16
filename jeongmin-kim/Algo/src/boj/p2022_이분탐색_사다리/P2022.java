package boj.p2022_이분탐색_사다리;

import java.io.*;

public class P2022 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        double x = Double.parseDouble(input[0]);
        double y = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);


        double left = 0, right = Math.min(x, y); //제일 큰 값이라도, 삼각형의 결정 조건에 의해 빗변의 길이를 넘지 못한다.
        //width == a1+b1
        //left : width의 최솟값, right : width의 최댓값 
        //이제 부터 width를 옮겨가면서 c를 구해보고(공식을 이용),c가 주어진 값과 일치하는, 즉 주어진 x와 y를 만족시키는 width를 찾는다.
        while (right - left >= 0.001) { //제일 작은 값과 제일 큰 값에서 오차가 0.001이하가 되는 첫번째 값을 찾아간다. 
            double width = (left + right) / 2; //가장 작은 길이와 긴 길이의 중간값
            double x_prime = Math.sqrt(Math.pow(x, 2) - Math.pow(width, 2)); //해당 width를 이용해서 구한 x건축물 높이
            double y_prime = Math.sqrt(Math.pow(y, 2) - Math.pow(width, 2)); //해당 width를 이용해서 구한 y건축물 높이
            double res = (x_prime * y_prime) / (x_prime + y_prime); //각 건축물 높이를 이용해서 c를 나타냄 -> 공식을 이용해서 나온 값
  
            if (res >= c) left = width; //width와 c는 반비례 관계 -> c(실제 값)가 구한 값보다 작으면, 실제 width를 더 오른쪽(큰) 범위에서 찾아봐야한다는 의미.  
            else right = width; 
        }
        System.out.println(String.format("%.3f", right));
    }
}

