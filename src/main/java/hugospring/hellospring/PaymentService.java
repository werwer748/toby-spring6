package hugospring.hellospring;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Component 어노테이션을 통해 스프링 컨테이너에 빈으로 등록
 * : 정확히는 빈 오브젝트가 될 대상임을 알리는 것.
 *
 * 프로그램 실행시점에 어노테이션 정보를 데이터 처럼 읽어오는데(메타프로그래밍)
 * 이 떄 스프링 빈 팩토리가 해당 정보를 참고할 수 있다.
 */
@Component
public class PaymentService {
    private final ExRateProvider exRateProvider;

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
