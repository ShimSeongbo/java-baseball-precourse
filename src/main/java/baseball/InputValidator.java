package baseball;

import java.util.HashSet;
import java.util.Set;

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