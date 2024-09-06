package hugospring.hellospring;

public class ObjectFactory {

    //* 메소드 하나안에 두개의 오브젝트를 만들기보다는 각각의 메소드로 분리하면 좋다
    public PaymentService paymentService() { //? 메서드 시그니처는 메서드 명과 파라미터의 순서, 타입, 개수를 의미한다.
        /**
         * exRateProvider() 메소드를 호출해서 생성자에 넣어줄 오브젝트를 받아옴
         * 이 경우 exRateProvider 구현 클래스를 바꾸고 싶을 때 찾아가기가 쉬워진다.
         */
        return new PaymentService(exRateProvider());
    }

    public ExRateProvider exRateProvider() {
        //* PaymentService의 생성자에 넘길 오브젝트를 생성
        return new WebApiExRateProvider();
    }
}
