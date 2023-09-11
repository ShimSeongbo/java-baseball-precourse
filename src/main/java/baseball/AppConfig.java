package baseball;

import java.util.Scanner;

public class AppConfig {
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    public GameRunner gameRunner(Scanner scanner) {
        return new GameRunner(scanner);
    }
}