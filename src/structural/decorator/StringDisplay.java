package structural.decorator;

/**
 * 케이크에 비유하면 StringDisplay 클래스는 생일 케이크의 중심에 있는 스펀지 케이크에 해당합니다.
 * StringDisplay 클래스는 문자열을 한 줄 표시합니다. StringDisplay 클래스는 Display 클래스의 하위 클래스로,
 * Display 클래스에서 선언된 추상 메서드를 구현할 책임이 있습니다.
 */
public class StringDisplay extends Display{
    private String string; //표시 문자열

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.length();
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if(row != 0) {
            throw new IndexOutOfBoundsException();
        }
        return string;
    }
}
