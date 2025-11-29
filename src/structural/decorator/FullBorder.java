package structural.decorator;

/**
 * FullBorder 클래스는 SideBorder 클래스와 마찬가지로 Border의 하위 클래스 중 하나입니다.
 * SideBorder  클래스는 좌우로만 장식이고, FullBorder 클래스는 상하좌우로 장식합니다.
 * 단, SideBorder 클래스에서는 장식 문자를 지정할수 있었지만, FullBorder 클래스에서는 장식 문자가 고정되어 있습니다.
 */
public class FullBorder extends Border{

    protected FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        //문자 수는 내용물 양쪽에 좌우 장식 문자만큼 더한 것
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        //행수는 내용물의 행수에 상하 장식 문자맘큼 더한 것
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if(row == 0) {
            //상단 테두리
            return "+" + makeLine('-', display.getColumns()) + "+";
        }else if(row == display.getRows() + 1) {
            //하단 테두리
            return "+" + makeLine('-', getColumns()) + "+";
        }else {
            //기타
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    //문자 ch로 count 수만큼 연속한 문자열을 만듬
    private String makeLine(char ch, int count) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < count; i++) {
            line.append(ch);
        }
        return line.toString();
    }
}
