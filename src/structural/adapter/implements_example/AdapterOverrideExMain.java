package structural.adapter.implements_example;

public class AdapterOverrideExMain {
    public static void main(String[] args) {
        PrintBanner p = new PrintBanner("Hello");
        p.printWeak();
        p.printString();
    }
}
/*
실행결과
(Hello)
*Hello*
 */
