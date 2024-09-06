package hugospring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

//* 해당 인터페이스를 구현하는 클래스들은 공통된 타입을 갖게되고 구현하는 메소드명도 동일해짐
public interface ExRateProvider {
    //? 인터페이스는 기본적으로 모든 메소드가 public
    BigDecimal getExRate(String currency) throws IOException;
}
