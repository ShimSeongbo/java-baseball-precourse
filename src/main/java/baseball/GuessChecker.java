package baseball;

import java.util.List;

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