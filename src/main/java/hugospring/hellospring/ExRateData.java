package hugospring.hellospring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

//* record: 생성자만 지정해주면 알아서 getter 만들어줌 - 한번 생성되면 수정 불가능
@JsonIgnoreProperties(ignoreUnknown = true) //? 생성자에 없는 필드는 무시하도록 설정
public record ExRateData(String result, Map<String, BigDecimal> rates) {
}
