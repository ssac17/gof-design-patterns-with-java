package structural.bridge;

/**
 * 이 클래스는 '기능의 클래스 계층' 취상위에 있는 클래스입니다.
 * impl 필드는 Display 클래스의 '구현'을 나타내는 인스턴스입니다. 생성자에는 구현을 나타내느 클래스의 인스턴스를 전달합니다.
 * 인수로 전달된 인스턴스는 impl 필드에 저장되며 이후 처리에 사용됩니다(이 필드가 두 클래스 계층의 '다리'가 됩니다).
 */
public class Display {
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}


