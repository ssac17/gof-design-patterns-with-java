package structural.proxy;

/**
 * ProxyMain 클래스는 PrinterProxy를 경유해서 Printer를 이용하는 클래스입니다. 이 클래스는 처음
 * PrinterProxy를 생성하고, getPrinterName으로 이름을 표시합니다. 다음 setPrinterName으로 이름을 설정합니다.
 * 그리고 print로 "Hello, world."라고 표시합니다.
 * 실행 결과 이름을 설정하고 표시하는 동안에는 Printer 인스턴스가 생성되지 않고, print 메서드를
 * 호출한 후에 생성되는 것을 확인할수 있습니다.
 */
public class ProxyMain {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("이름은 현재 [" + p.getPrinterName() + "] 입니다.");
        p.setPrinterName("Bob");
        System.out.println("이름은 현재 [" + p.getPrinterName() + "] 입니다.");
        p.print("Hello, world.");
    }
}
/*
실행 결과
이름은 현재 [Alice] 입니다.
이름은 현재 [Bob] 입니다.
Printer 인스턴스(Bob) 생성 중.....완료
=== Bob ===
Hello, world.
 */
