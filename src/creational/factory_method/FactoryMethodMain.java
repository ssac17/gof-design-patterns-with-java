package creational.factory_method;

import creational.factory_method.framework.Product;
import creational.factory_method.idcard.IDCardFactory;

/**
 * framework의 패키지 내용을 수정하지 않고도 전혀 다른 제품과 공장을 만들수 있습니다.
 * framework 패키지 내용을 수정할 필요가 없습니다.
 */
public class FactoryMethodMain {
    public static void main(String[] args) {
        IDCardFactory factory = new IDCardFactory();
        Product card1 = factory.create("Kim");
        Product card2 = factory.create("Make");
        Product card3 = factory.create("Diana");

        card1.use();
        card2.use();
        card3.use();
    }
}
/*
실행 결과
Kim의 카드를 만듭니다.
[IDCard: Kim]을 등록 했습니다.
Make의 카드를 만듭니다.
[IDCard: Make]을 등록 했습니다.
Diana의 카드를 만듭니다.
[IDCard: Diana]을 등록 했습니다.
[IDCard: Kim]을 사용합니다.
[IDCard: Make]을 사용합니다.
[IDCard: Diana]을 사용합니다.
 */
