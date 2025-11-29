package structural.decorator;

/**
 * Display 클래스 는 여러 행으로 이루어진 문자열을 표시하는 추상 클래스입니다.
 */
public abstract class Display {
    public abstract int getColumns(); //가로 문자 수
    public abstract int getRows(); //세로 문자 수
    public abstract String getRowText(int row); //row행째 문자열

    //모든 행을 표시
    public void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
