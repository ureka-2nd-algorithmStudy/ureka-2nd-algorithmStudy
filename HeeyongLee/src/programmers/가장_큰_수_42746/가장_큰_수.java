package programmers.가장_큰_수_42746;

import java.io.IOException;
import java.util.Arrays;

public class 가장_큰_수 {

    public static void main(String[] args) throws IOException {
        System.out.println(new 가장_큰_수().solution(new int[]{6, 10, 2})); // "6210"
        System.out.println(new 가장_큰_수().solution(new int[]{3, 30, 34, 5, 9})); // "9534330"
        System.out.println(new 가장_큰_수().solution(new int[]{0, 0, 0})); // "0"
    }

    public String solution(int[] numbers) throws IOException {
        StringBuilder sb = new StringBuilder();
        String[] strNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        for (String strNumber : strNumbers) {
            sb.append(strNumber);
        }

        return sb.toString();
    }
}
