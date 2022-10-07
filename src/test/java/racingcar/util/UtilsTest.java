package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {
    @DisplayName("알파벳 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void isAlphabet(String given) {
        assertThat(Utils.isAlphabet(given)).isTrue();
    }
}
