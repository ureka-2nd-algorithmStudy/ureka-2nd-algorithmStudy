package programmers.숫자_문자열과_영단어_81301;

public class 숫자_문자열과_영단어 {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < numbers.length; i++) {
            if(s.contains(numbers[i])) {
                s = s.replace(numbers[i], Integer.toString(i));
                // i = 0;
            }
        }
        return Integer.parseInt(s);
    }
}
