package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자: pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,javaji");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    static class generateWinnerTestCase {
        public String description;
        public HashMap<String, Integer> car;
        public String winner;
    }

    @Test
    void 최종우승자_출력_테스트() {
        generateWinnerTestCase[] tests = new generateWinnerTestCase[]{
                new generateWinnerTestCase() {
                    {
                        description = "pobi, woni 우승";
                        car = new HashMap<>();
                        car.put("pobi", 2);
                        car.put("woni", 2);
                        winner = "pobi, woni";
                    }
                },
                new generateWinnerTestCase() {
                    {
                        description = "pobi 우승";
                        car = new HashMap<>();
                        car.put("pobi", 2);
                        car.put("woni", 1);
                        winner = "pobi";
                    }
                },
                new generateWinnerTestCase() {
                    {
                        description = "woni 우승";
                        car = new HashMap<>();
                        car.put("pobi", 1);
                        car.put("woni", 2);
                        winner = "woni";
                    }
                },
                new generateWinnerTestCase() {
                    {
                        description = "pobi, woni 우승";
                        car = new HashMap<>();
                        car.put("pobi", 0);
                        car.put("woni", 0);
                        winner = "pobi, woni";
                    }
                },
        };

        Application.RacingCarGameModel racingCarGameModel = new Application.RacingCarGameModel();

        for (generateWinnerTestCase test : tests) {
            String winner = racingCarGameModel.generateWinner(test.car);

            assertEquals(winner, test.winner, test.description);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
