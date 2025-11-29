package structural.decorator;

/**
 * SideBorder 클래스는 구체적인 장식틀의 일종으로 Border 클래스의 하위 클래스입니다.
 * SideBorder 클래스는 문자열 좌우에 정해진 문자(borderChar)로 장식 합니다. 에를 들어 borderChar 필드의 값이 '|'라고 하면,
 * 다음과 같이 '내용물' 좌우에 그 문자가 붙어 show로 표시됩니다. borderChar 필드는 생성자로 지정합니다.
 * SideBorder 클래스는 춧상 클래스가 아닙니다. 상위 클래스에서 선언된 추상 메서드를 모두 구현했기 때문입니다.
 */
public class SideBorder extends Border {

    private char borderChar; //장식 문자

    //내용물이 될 Display와 장식 문자를 지정
    protected SideBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {
        //문자 수는 내용물의 양쪽에 장식 문자만큼 더한 것
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        //행수는 내용물의 행수와 같음
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        //지정 행의 내용은 내용물의 지정 행 안쪽에 장식 문자을 붙인 것
        return borderChar + display.getRowText(row) + borderChar;
    }
}
