package hugospring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

//? ExRateProvider 인터페이스를 구현
public class SimpleExRateProvider implements  ExRateProvider{
    @Override // public 메소드를 구현했기때문에 접근자를 써줘야 함.
    public BigDecimal getExRate(String currency) throws IOException {
        if (currency.equals("USD")) return BigDecimal.valueOf(1000);

        throw new IllegalArgumentException("지원되지 않는 통화입니다.");
    }
}
