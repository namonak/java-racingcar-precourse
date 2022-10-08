package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("Car 객체 생성 및 play 테스트")
    @Test
    void set() {
        Car car = new Car("pobi");
        car.play(3);
        car.play(4);
        assertThat(car).isEqualTo(new Car("pobi", 1));
    }
}
