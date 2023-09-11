package baseball;

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

