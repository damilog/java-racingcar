package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private int tryCount;
    private List<String> racingCarList;
    private String[] racingResults;
    private List<String> winners;

    private static final Random RANDOM = new Random();
    private final int MIN_MOVE = 0;
    private final int MAX_MOVE = 9;
    private final int MOVABLE = 4;

    public RacingCarGame(int tryCount, List<String> racingCarList) {
        this.tryCount = tryCount;
        this.racingCarList = racingCarList;
        racingResults = new String[racingCarList.size()];
        Arrays.fill(racingResults, "");
        winners = new ArrayList<>();
    }

    private int getRandomMove() {
        return MIN_MOVE + RANDOM.nextInt(MAX_MOVE - MIN_MOVE + 1);
    }

    private boolean checkMovable(int move) {
        return MOVABLE <= move;
    }

    public void playRacingCarGame() {
        System.out.println("실행 결과");

        do {
            controlRacingCar();

            tryCount--;

        } while (tryCount > 0);
    }

    private void controlRacingCar() {

        for (int i = 0; i < racingCarList.size(); ++i) {
            int move = getRandomMove();

            setRacingResults(i, move);
        }
    }

    private void setRacingResults(int carNumber, int move) {
        if (!checkMovable(move)) {
            printMoveState(carNumber);
            return;
        }

        racingResults[carNumber] += "-";
        printMoveState(carNumber);
    }

    private void printMoveState(int carNumber) {
        System.out.println(racingCarList.get(carNumber) + " : " + racingResults[carNumber]);

        if (carNumber == racingCarList.size() - 1) {
            System.out.println();
        }
    }