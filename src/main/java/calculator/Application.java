package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 문자열을 숫자로 변환해서 더하는 함수
        // 새로운 구분자를 만드는 함수
        // 사용자가 잘못된 입력을 했을 때의 예의값 처리
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
            int index = input.indexOf("\n");
            if (index == -1) {
                throw new IllegalArgumentException("[ERROR] 커스텀 구분자 형식이 잘못되었습니다. (예: //;\\n1;2;3)");
            }
            delimiter = input.substring(2, index);
            numbers = input.substring(index + 1);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
