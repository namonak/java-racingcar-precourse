package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    static class RacingCarGameModel {
        private static final int MIN_NUM = 0;
        private static final int MAX_NUM = 9;
        private static final int PIVOT_VALUE = 3;

        HashMap<String, Integer> racers = new HashMap<>();

        String generateWinner(HashMap<String, Integer> racers) {
            int maxValue = 0;
            List<String> winners = new ArrayList<>();
            for (Entry<String, Integer> entry : racers.entrySet()) {
                if (entry.getValue() >= maxValue) {
                    if (entry.getValue() != maxValue) {
                        winners.clear();
                    }
                    maxValue = entry.getValue();
                    winners.add(entry.getKey());
                }
            }
            return String.join(", ", winners);
        }

        private void setCarUsers(String[] racerNames) {
            for (String racer : racerNames) {
                this.racers.put(racer, 0);
            }
        }

        HashMap<String, Integer> run() {
            for (Entry<String, Integer> entry : racers.entrySet()) {
                if (pickNumberInRange(MIN_NUM, MAX_NUM) > PIVOT_VALUE) {
                    racers.put(entry.getKey(), entry.getValue() + 1);
                }
            }
            return racers;
        }
    }

    static class RacingCarGameView {}

    static class RacingCarGameController {}

    static class Utils {
        static void checkDuplicateCarName(String[] carName) {
            Set<String> carNameSet = new HashSet<>(Arrays.asList(carName));

            if (carNameSet.size() != carName.length) {
                throw new IllegalArgumentException("[ERROR] 입력된 자동차 이름에 중복이 있습니다.");
            }
        }

        static void checkCarNameLength(String[] carNames) {
            for (String carName : carNames) {
                if (carName.length() == 0 || carName.length() > 5) {
                    throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하입니다.");
                }
            }
        }

        static String[] isContainComma(String carNames) {
            if (!carNames.contains(",")) {
                throw new IllegalArgumentException("[ERROR] 사용자 구분을 위한 (,) 입력이 생략되었습니다.");
            }
            return carNames.split(",");
        }

        static boolean isNumber(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("[ERROR] 입력된 값은 숫자가 아닙니다.");
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
