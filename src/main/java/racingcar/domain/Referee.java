package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public static List<String> getWinners(List<Car> cars) {
        int maxMovingDistance = getMaxMovingDistance(cars);

        return cars.stream()
            .filter(car -> car.isWinner(maxMovingDistance)).map(Car::getName)
            .collect(Collectors.toList());
    }

    private static int getMaxMovingDistance(List<Car> cars) {
        int maxMovingDistance = 0;

        for (Car car : cars) {
            if (car.isFartherThan(maxMovingDistance)) {
                maxMovingDistance = car.getPosition();
            }
        }
        return maxMovingDistance;
    }
}
