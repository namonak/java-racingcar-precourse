package racingcar.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private static void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("0 이상의 위치값을 입력해주세요.");
        }
    }

    public void move() {
        this.position++;
    }

    public boolean isBiggerPosition(Position position) {
        return this.position >= position.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return this.position;
    }
}
