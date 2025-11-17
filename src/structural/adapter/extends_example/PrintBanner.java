package structural.adapter.extends_example;

/**
 * 상속을 사용한 예제
 * PrintBanner 클래스는 어탭터 역활을 합니다. 준비된 Banner 클래스르 확장하여 showWithParen 메서드와 showWithAster 메소드를 상속 받으며,
 * 필요한 Print 인터페이스를 구현하여 printWeak, printString 메서드를 구현합다.
 */
public class PrintBanner extends Banner implements Print{

    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printString() {
        showWithAster();
    }
}
