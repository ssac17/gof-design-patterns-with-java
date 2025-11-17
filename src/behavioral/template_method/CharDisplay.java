package behavioral.template_method;

/**
 * AbstractDisplay 클래스에서 추상 메서드로 선언된 open, print, close 메서드가 구현되어 있습니다.
 * open: 시작 문자열 '<<'을 표시
 * print: 문자열 1회 표시
 * close: 종료 문자열 '>>'을 표시
 */
public class CharDisplay extends AbstractDisplay{

    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
