package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @DisplayName("Position 객체 생성 및 이동 테스트")
    @Test
    void set() {
        Position position = new Position();
        position.move();
        assertThat(position).isEqualTo(new Position(1));
    }
}