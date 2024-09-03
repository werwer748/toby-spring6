package hugospring.hellospring;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    //* private으로 설정해서 내부 메소드나 생성자를 통해서만 접근이 가능하도록 제한
    private Long orderId;
    // 통화단위
    private String currency;
    // 소수를 사용해 값을 저장하는 경우 Double, Float은 부동소수점 문제로 인해 오차가 발생할 수 있다. - 적당한 근사치값을 넣는다면 사용 가능
    private BigDecimal foreignCurrencyAmount;
    private BigDecimal exRate;
    private BigDecimal convertedAmount;
    // 특정 시간대로 지정
    private LocalDateTime validUntil;

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExRate() {
        return exRate;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exRate=" + exRate +
                ", convertedAmount=" + convertedAmount +
                ", validUntil=" + validUntil +
                '}';
    }

    public Payment( // 같은 타입의 파라미터가 많을때는 신경써서 생성자를 사용해야함 - 빌더를 통해 해결 가능
        Long orderId, String currency, BigDecimal foreignCurrencyAmount,
        BigDecimal exRate, BigDecimal convertedAmount, LocalDateTime validUntil
    ) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exRate = exRate;
        this.convertedAmount = convertedAmount;
        this.validUntil = validUntil;
    }
}
