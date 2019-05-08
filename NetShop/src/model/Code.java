package model;

import java.util.Objects;

public class Code {

    private long codeId;
    private long userId;
    private long orderId;
    private String value;

    public Code(long userId, long orderId, String value) {
        this.userId = userId;
        this.orderId = orderId;
        this.value = value;
    }

    public Code(long codeId, long userId, long orderId, String value) {
        this.codeId = codeId;
        this.userId = userId;
        this.orderId = orderId;
        this.value = value;
    }

    public long getCodeId() {
        return codeId;
    }

    public long getUserId() {
        return userId;
    }

    public long getOrderId() {
        return orderId;
    }

    public String getValue() {
        return value;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code = (Code) o;
        return codeId == code.codeId &&
                userId == code.userId &&
                orderId == code.orderId &&
                value.equals(code.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeId, userId, orderId, value);
    }

    @Override
    public String toString() {
        return "Code{" +
                "codeId=" + codeId +
                ", userId=" + userId +
                ", orderId=" + orderId +
                ", value='" + value + '\'' +
                '}';
    }
}
