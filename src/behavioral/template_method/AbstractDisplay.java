package behavioral.template_method;

/**
 * AbstractDisplay 클래스에는 open, print, close는 추상 메서드이고 display만 구현되어 있습니다.
 * 실제론 display 메서드가 무슨 일을 처리하는지 알수 없습니다.
 * 실제로 무슨일을 하는지 open, print, close를 구현하는 하위 클래스에서 확인해 봐야 합니다.
 */
public abstract class AbstractDisplay {
    //open, print, close는 하위 클래스에 구현을 맡기는 추상 메서드
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
