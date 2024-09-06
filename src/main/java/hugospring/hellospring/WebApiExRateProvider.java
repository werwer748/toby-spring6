package hugospring.hellospring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

//? ExRateProvider 인터페이스를 구현
public class WebApiExRateProvider  implements ExRateProvider {

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        // 환율 가져오기 -> https://open.er-api.com/v6/latest/USD (환율 사이트)
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        // 잭슨에 들어있는 ObjectMapper를 사용해서 json을 객체로 변환
        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(response, ExRateData.class);
        return data.rates().get("KRW");
    }
}
