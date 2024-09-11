package hugospring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//* 해당 클래스가 구성정보를 담고있는 클래스라는 것을 어노테이션을 통해 명시
@Configuration //? Bean 클래스끼리 어떤 관계를 가지는지(구성정보)를 명시하는 클래스가 된 것
@ComponentScan //? 해당 패키지 이하의 모든 클래스를 스캔하여 Bean으로 등록
public class ObjectFactory {
    /**
     * 해당 클래스의 메소드들은 각각 하나의 Bean을 만들어 내는 것.
     * (어떤 클래스를 인스턴스화하고 어떤 클래스들끼리 어떤 관계를 가지게 할 것인지)
     *
     * 그렇기 떄문에 Bean을 만들어내는 메소드라는 것을 어노테이션을 통해 명시
     */

    /*@Bean //? Bean을 만들어내는 메소드
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean //? Bean을 만들어내는 메소드
    public ExRateProvider exRateProvider() {
        //* PaymentService의 생성자에 넘길 오브젝트를 생성
        return new SimpleExRateProvider();
    }*/
}
