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

        // 추후 add() 메서드로 분리 예정
        System.out.println("입력값: " + input);
    }
}
