package kitchenpos.products.tobe.vo;

import kitchenpos.products.infra.PurgomalumClient;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProductName {

    @Column(name = "name", nullable = false)
    private String value;

    protected ProductName() {

    }

    public ProductName(String value) {
        if (Objects.isNull(value) || value.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해 주세요.");
        }
        this.value = value;
    }

    public ProductName(String value, PurgomalumClient purgomalumClient) {
        this(value);
        if (purgomalumClient.containsProfanity(value)) {
            throw new IllegalArgumentException("비속어가 포함되어 있습니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductName that = (ProductName) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
