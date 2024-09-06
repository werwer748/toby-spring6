package hugospring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        /**
         * 오브젝트 팩토리
         * 괌심사를 분리시킨다.
         * - PaymentService와 ExRateProvider의 관계 설정의 책임을 ObjectFactory로 분리
         * - 클라이언트로서의 책임만 남긴다.
         *
         * 이제 모든 클래스가 각 클래스만의 관심사와 책임에 충실한 코드가 되었다.
         * PaymentService와 ExRateProvider 인터페이스를 구현한 클래스들은
         * 서로 영향을 주지않은채로 각자의 기능에 충실한 코드가 만들어진 것.
         */
        ObjectFactory objectFactory = new ObjectFactory();
        PaymentService paymentService = objectFactory.paymentService();
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
