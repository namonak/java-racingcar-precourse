package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(String input) {
        validateInputName(input);
        this.cars = new Cars(makeCarList(separateInput(input)));
    }

    private void validateInputName(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해 주세요.");
        }
    }

    private List<String> separateInput(String input) {
        List<String> carNames = new ArrayList<>();
        for (String carName : input.split(",")) {
            carNames.add(carName.trim());
        }
        return carNames;
    }

    private static ArrayList<Car> makeCarList(List<String> cars) {
        ArrayList<Car> carList = new ArrayList<>();
        for (String car : cars) {
            carList.add(new Car(car));
        }
        return carList;
    }

    public List<Car> start() {
        return this.cars.play();
    }

    public List<Car> getWinners() {
        return this.cars.getWinners();
    }
}
