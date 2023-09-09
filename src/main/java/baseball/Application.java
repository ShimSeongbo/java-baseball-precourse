package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameRunner gameRunner = new GameRunner(scanner);

        while (true) {
            gameRunner.runGame();
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = scanner.nextInt();
            if (choice == 2) {
                break;
            } else if (choice != 1) {
                throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
            }
        }

        scanner.close();
    }
}

class GameRunner {
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

class NumberGenerator {
    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = (int) (Math.random() * 9) + 1;
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }
}

class InputValidator {
    public static boolean isValid(int number) {
        return number >= 100 && number <= 999 && hasUniqueDigits(number);
    }

    private static boolean hasUniqueDigits(int number) {
        Set<Integer> digits = new HashSet<>();
        while (number > 0) {
            if (!digits.add(number % 10)) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}

class InputParser {
    public static List<Integer> parse(int number) {
        List<Integer> parsedNumbers = new ArrayList<>();
        while (number > 0) {
            parsedNumbers.add(0, number % 10);
            number /= 10;
        }
        return parsedNumbers;
    }
}

class GuessChecker {
    private final List<Integer> correctNumbers;

    public GuessChecker(List<Integer> correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public GuessResult checkGuess(List<Integer> guess) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < guess.size(); i++) {
            if (correctNumbers.get(i).equals(guess.get(i))) {
                strikeCount++;
            } else if (correctNumbers.contains(guess.get(i))) {
                ballCount++;
            }
        }

        return new GuessResult(strikeCount, ballCount);
    }
}

class GuessResult {
    private final int strikeCount;
    private final int ballCount;

    public GuessResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isGameWon() {
        return strikeCount == 3;
    }

    public void showHint() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else {
            if (strikeCount > 0) {
                System.out.print(strikeCount + "스트라이크 ");
            }
            if (ballCount > 0) {
                System.out.print(ballCount + "볼 ");
            }
            System.out.println();
        }
    }
}
