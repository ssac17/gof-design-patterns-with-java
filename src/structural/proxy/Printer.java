package structural.proxy;

/**
 * Printer 클래스는 '본인'을 나타내는 클래스입니다.
 * 생성자에서는 앞서 말한 것처럼 가짜 '무거운 작업'인 heavyJob을 실행하고 있습니다.
 */
public class Printer implements Printable {
    private String name; //이름

    //생성자
    public Printer() {
        heavyJob("Printer 인스턴스 생성 중");
    }

    //생성자(이름 지정)
    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 인스턴스("+ name + ") 생성 중");
    }

    //이름 설정
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return "";
    }

    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {

            }
            System.out.print(".");
        }
        System.out.println("완료");
    }
}
