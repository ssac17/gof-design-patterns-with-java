package behavioral.template_method;

/**
 * open: 문자열 "+-----+"를 표시
 * print: 생성자에서 주어진 문자열을 "| |"사이에 표시
 * close: 문자열 "+-----+"를 표시
 */
public class StringDisplay extends AbstractDisplay{
    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
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