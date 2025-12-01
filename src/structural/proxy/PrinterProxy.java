package structural.proxy;

/**
 * PrinterProxy 클래스는 대리인 역할을 하며, Printable 인터페이스를 구현합니다. name 필드는 이름을 저장,
 * real 필드는 '본인'을 저장합니다. 생성자에서는 이름을 설정합니다(이 시점에서는 아직 '본인'이 만들어지지 않습니다).
 * setPrinterName 메서드는 새로 이름을 설정합니다. 만약 real이 null이 아니라면(이미 만들어져 있다면) 본인에 대해서도
 * 그 이름을 설정합니다. 하지만 real이 null이면, 그냥 자신(PrinterProxy의 인스턴스)의 name 필드에 이름을 설정합니다.
 * print 메서드는 대리인이 할수 있는 범위를 넘어서는 처리이므로, realize 메서드를 호춣하여 본인은 생성합니다.
 * realize란 '현실화하다'라는 의미이므로 realize 메서드를 실행한 후 real 필드에는 본인(Printer 클래스의 인스턴스)
 * 이 저장되어 있으므로 real.print를 호출합니다. 이는 '위임'입니다. setPrinterName, getPrinterName 메서드를
 * 여러번 호출해도 Printer 인스턴스는 생성되지 않습니다. Printer 인스턴스'본인'이 정말로 필요할 때 생성됩니다.
 * 반면 PrinterProxy 클래스는 Printer 클래스를 알고 있습니다. PrinterProxy 클래스의 real 필드는 Printer형이고,
 * PrinterProxy 클래스는 Printer 클래스와 고정적으로 결합된 부품 인것입니다.
 */
public class PrinterProxy implements Printable{
    private String name;  //이름
    private Printer real; //본인

    //생성자
    public PrinterProxy() {
        this.name = "No Name";
        this.real = null;
    }

    //생성자(이름 지정)
    public PrinterProxy(String name) {
        this.name = name;
        this.real = null;
    }

    //이름 설정
    @Override
    public void setPrinterName(String name) {
        if(real != null) {
            //본인에게도 설정
            real.setPrinterName(name);
        }
        this.name = name;
    }

    //이름 가져오기
    @Override
    public String getPrinterName() {
        return name;
    }

    //출력
    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    //본인 생성
    private synchronized void realize() {
        if(real == null) {
            real = new Printer(name);
        }
    }
}
