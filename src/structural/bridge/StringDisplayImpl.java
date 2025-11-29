package structural.bridge;

/**
 * StringDisplayImpl 클래스는 문자열을 표시하는 클래스입니다.
 * 다만, 그냥 표시하는것이 아니라, DisplayImpl 클래스의 하위 클래스로서
 * rawOpen, rawPrint, rawClose라는 메서드를 사용합니다.
 */
public class StringDisplayImpl extends DisplayImpl{
    private String string;
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println(STR."|\{string}|");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
