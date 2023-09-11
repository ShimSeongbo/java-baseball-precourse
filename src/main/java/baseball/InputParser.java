package baseball;

import java.util.ArrayList;
import java.util.List;

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