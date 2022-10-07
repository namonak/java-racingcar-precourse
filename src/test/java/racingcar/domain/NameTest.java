package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @DisplayName("이름이 5자 이하인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 이름이_5자_이하인_경우(String given) {
        Name name = new Name(given);
        assertThat(name).isEqualTo(new Name(given));
    }

    @DisplayName("이름이 빈 문자열이거나 공백인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", "pobi ", "po bi", " pobi", "p  bi", "p b i"})
    void 이름이_빈_문자열이거나_공백인_경우(String given) {
        assertThatThrownBy(() -> new Name(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 빈 문자열이거나 공백이 있습니다.");
    }

    @DisplayName("이름이 5자 초과인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pororo", "tongtongi", "crongcrong", "Hannah", "Christina", "Joannes"})
    void 이름이_5자_초과인_경우(String given) {
        assertThatThrownBy(() -> new Name(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5글자 이하만 가능합니다.");
    }
}
