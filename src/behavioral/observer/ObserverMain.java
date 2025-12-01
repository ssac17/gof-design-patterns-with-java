package behavioral.observer;

/**
 * ObserverMain 클래스에서는 RandomNumberGenerator의 인스턴스를 1개 만들고, 그 관찰를 2개 만듭니다.
 * observer1은 DigitObserver의 인스턴스이고, observer2는 GraphObserver의 인스턴스 입니다.
 * addObserver 메서드를 사용하여 관찰자를 등록한 후 generator.execute를 사용하여 수를 생성합니다.
 */
public class ObserverMain {
    public static void main(String[] args) {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        DigitObserver observer1 = new DigitObserver();
        GraphObserver observer2 = new GraphObserver();

        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
