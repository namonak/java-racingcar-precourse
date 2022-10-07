package racingcar.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if (name.isEmpty() || name.contains(" ")) {
            throw new IllegalArgumentException("이름이 빈 문자열이거나 공백이 있습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
