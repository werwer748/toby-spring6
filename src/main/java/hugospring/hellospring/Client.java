package hugospring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        /**
         * BeanFactory(스프링컨테이너)는 무엇을 가지고 오브젝트를 만드는지 알 수 없음
         * => @Bean 메소드들을 없애면 에러가 난다.
         *
         * @ComponentScan, @Component 어노테이션을 통해 구성정보를 제공할 수 있다!
         */
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);

        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
