package behavioral.observer;

/**
 * GraphObserver 클래스도 Observer 인터페이스를 구현한 클래스 입니다.
 * 이 클래스는 관찰한 수를 *****처럼 '간이 그래프'로 표현합니다.
 */
public class GraphObserver implements Observer{
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("GraphObserver:");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
    }
}
/*
실행 결과
DigitObserver: 31
GraphObserver:
*******************************
DigitObserver: 9
GraphObserver:
*********
DigitObserver: 3
GraphObserver:
***
... 생략
 */