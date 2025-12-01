package structural.proxy;

/**
 * Printable 인터페이스는 PrintProxy 클래스와 Printer 클래스를 동일시하기 위한 것입니다.
 * setPrinterName 메서드는 이름 설정, getPrinterName는 이름 가져오기, print 출력을 위한 것입다.
 */
public interface Printable {
    public abstract void setPrinterName(String name); //이름 설정
    public abstract String getPrinterName();          //이름 취득
    public abstract void print(String string);        //문자열 표시(프린트 아웃)
}
