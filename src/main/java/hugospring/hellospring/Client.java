package hugospring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException { // prepare로 부터 던진 예외를 바깥으로 던짐
        // PaymentService paymentService = new PaymentService(); // 추상클래스는 인스턴스화가 불가능
        // PaymentService paymentService = new WebApiExRatePaymentService(); // getExRate를 구현한 클래스
        PaymentService paymentService = new SimpleExRatePaymentService(); // 또 따른 다른 기능 구현이 필요한 경우 - PaymentService는 변하지 않는다.
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
