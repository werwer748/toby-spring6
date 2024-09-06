package hugospring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class PaymentService {
    //* 어떤 클래스라도 해당 인터페이스를 구현하고 있는 클래스라면 사용할 수 있다.
    private final ExRateProvider exRateProvider;

    /**
     * 관계설정 책임의 분리
     * 지금은 의존관계를 설정하는 책임을 PaymentService에서 가지고 있다.
     * (어떤 환율데이터 가져오는 기능을 쓸건지를 PaymentService가 결정하고 있다는 뜻.)
     *
     * 생성자에 의존성 주입(파라미터로 사용할 클래스를 받음)으로 해서 관계설정의 책임에서 벗어난다.
     * => 해당 관심사는 이제 이 클래스에서 완전히 사라진 것
     *
     * 이제 새로운 클래스를 만들거나 사용하는 클래스를 변경해도 PaymentService는 전혀 손댈 필요가 없다.
     * 이렇게 함으로써 완벽하게 재사용이 가능한 - 독자적으로 움직이는 코드가 된것이다.
     */
    public PaymentService(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }

    public Payment prepare(
            Long orderId, String currency, BigDecimal foreignCurrencyAmount
    ) throws IOException {

        //* 공통 인터페이스를 구현한 클래스를 주입받아 사용하기 떄문에 메소드명이 고정됨!
        BigDecimal exRate = exRateProvider.getExRate(currency);

        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }
}
