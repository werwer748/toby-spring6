package hugospring.hellospring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
//        List<Integer> scores = Arrays.asList(5, 7, 1, 9, 2, 8);
        List<String> scores = Arrays.asList("a", "z", "java", "boom", "ebs", "spring");
        /**
         * 만약 단순 숫자 크기나 알파벳 순으로 정렬이 아닌 다른 방식으로 정렬하고 싶다면?
         * -> 순서를 결정하는 알고리즘을 집어넣어 주기만 하면 된다!
         * Collections.sort가 전략패턴이 적용된 메소드기 때문에 가능
         */
        //* 글자 길이에 따라 정렬
        Collections.sort(
                scores,
                (s1, s2) -> s1.length() - s2.length()
        ); // sort를 통해 인자로 전달받은 리스트를 정렬 - 리턴없이 리스트를 직접 변경

        scores.forEach(System.out::println);
    }
}
