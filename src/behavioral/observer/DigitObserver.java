package behavioral.observer;

/**
 * DigitObserver 클래스는 Observer 인터페이스를 구현한 클래스이고 관찰한 수를 '숫자'로 표시합니다.
 * update 메서드 안에서 인수로 주어진 NumberGenerator의 getNumber 메서드를 사용하여 수를 얻고 이를 표시합니다.
 * 여기서는 표시되는 모습이 알수 있도록 Thread.sleep로 속도를 늦췄습니다.
 */
public class DigitObserver implements Observer{

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver: " + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
    }
}
