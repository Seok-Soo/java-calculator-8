package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = add(input);
        System.out.println("결과 : " + result);
    }

    private static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");
            if (index == -1) {
                throw new IllegalArgumentException("[ERROR] 커스텀 구분자 형식이 잘못되었습니다. (예: //;\\n1;2;3)");
            }

            String customDelimiter = input.substring(2, index);
            delimiter = delimiter + "|" + Pattern.quote(customDelimiter); // 정규식 특수문자 처리
            numbers = input.substring(index + 2);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) continue; // 빈 값 방지
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
