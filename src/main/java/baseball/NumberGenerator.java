package baseball;

import java.util.ArrayList;
import java.util.List;

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