package baseball;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        Scanner scanner = config.scanner();
        GameRunner gameRunner = config.gameRunner(scanner);

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



