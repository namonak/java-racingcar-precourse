package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        static void checkDuplicateCarName(String[] carName) {}

        static void checkCarNameLength(String[] carNames) {}

        static String[] isContainComma(String carNames) {
            return null;
        }

        static boolean isNumber(String input) {
            return false;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
