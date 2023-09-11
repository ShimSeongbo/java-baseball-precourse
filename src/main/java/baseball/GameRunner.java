package baseball;

import java.util.List;
import java.util.Scanner;

public class GameRunner {
    private final Scanner scanner;

    public GameRunner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void runGame() {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> computerNumbers = generator.generateNumbers();
        GuessChecker guessChecker = new GuessChecker(computerNumbers);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int guess = scanner.nextInt();
            if (!InputValidator.isValid(guess)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            List<Integer> userGuess = InputParser.parse(guess);
            GuessResult result = guessChecker.checkGuess(userGuess);

            if (result.isGameWon()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }

            result.showHint();
        }
    }
}
