package hugospring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

abstract public class PaymentService {

    public Payment prepare(
            Long orderId, String currency, BigDecimal foreignCurrencyAmount
    ) throws IOException {
        /**
         * 각 코드들이 변경이 되야하는 시점이 다름 - 관심사가 다르다고 볼 수 있다.
         * 이런 경우 적절히 코드를 분리하여 작성!
         */
        BigDecimal exRate = getExRate(currency);

        //* 코드를 이해하는데 문제없다면 코멘트는 삭제!
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);

        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

    /**
     * 관심사가 다른 코드는 분리하여 작성하는게 보기도 좋고 유지보수하기도 좋다.
     * 해당 메소드는 기술적인 부분으로 변화가 생길 수 있는 부분이기 때문에 따로 분리
     * 환율을 어떻게 가져올 것인가~ 가 관심사
     *
     * 이제 상속을 통해 해당 코드를 구현하게끔 업그레이드
     * getExRate를 구현하는 클래스를 만들어서 해당 클래스를 상속받아서 사용하게끔 변경
     * 상속은 확장성있는 코드를 만들때 사용할 수 있다.
     * 템플릿 메소드패턴, 팩토리 메소드 패턴 -> 상속을 통해서 기존의 코드를 건들지 않고 어떤 코드의 기능을 확장해서 사용할 수 있도록
     * 만들어주는 디자인 패턴
     *
     * abstract: 추상적인 기능으로 정의만해두고 서브 클래스에서 정의할 수 있도록 하는 키워드
     */
    abstract BigDecimal getExRate(String currency) throws IOException;

    //* 환율 정보를 가져오는 방식이 바뀌더라도 변경되지않고 유지될 수 있는 재사용성이 뛰어난 코드로 만들꺼니까 main 메소드는 분리!
}
