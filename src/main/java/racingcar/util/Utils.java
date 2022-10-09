package racingcar.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Utils {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    public static boolean isAlphabet(String str) {
        return str.matches("^[a-zA-Z]*$");
    }

    public static int generateRandomNumber() {
        return pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
