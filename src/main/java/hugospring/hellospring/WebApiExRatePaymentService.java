package hugospring.hellospring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * 상속을 통해 클래스를 만들때는 super-class의 이름을 따서 작명을 많이한다.
 * web api를 통해 환율을 가져오는 PaymentService를 상속받은 클래스
 */
public class WebApiExRatePaymentService extends PaymentService{

    @Override
    BigDecimal getExRate(String currency) throws IOException {
        //* 환율을 가져오는데 뜬급없이 URL?? - 헷갈릴수 있으니 이런경우는 코멘트를 유지
        // 환율 가져오기 -> https://open.er-api.com/v6/latest/USD (환율 사이트)
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        //? HttpURLConnection: http가 가지는 추가 기능을 사용할 수 있다.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //? inputStream: 파일이나 네트워크를 통해서 들어오는 데이터를 바이트 형태로 읽어온다. -> 사람이 읽을 수 있는 형태로 한번 더 변환해줘야함
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // 읽어온 데이터를 문자열 한번에 변환
        String response = br.lines().collect(Collectors.joining());

        // 모든 stream은 열면 꼭 닫아주어야 한다.
        br.close();

        // 잭슨에 들어있는 ObjectMapper를 사용해서 json을 객체로 변환
        ObjectMapper mapper = new ObjectMapper();
        //? readValue: json을 객체로 변환
        ExRateData data = mapper.readValue(response, ExRateData.class);
        //? record로 만들어져서 기존의 getter 패턴이 아닌 필드명으로 값을 꺼내올 수 있다.
        BigDecimal exRate = data.rates().get("KRW");
        return exRate;
    }
}
