package structural.bridge;

/**
 * CountDisplay 클래스에서는 Display 클래스에서 상속받은 open, print, close 메서드를 사용하여
 * multiDisplay라는 새로운 메서드를 추가했습니다.
 */
public class CountDisplay extends Display{

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
