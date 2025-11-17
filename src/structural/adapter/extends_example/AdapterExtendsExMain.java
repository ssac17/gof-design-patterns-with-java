package structural.adapter.extends_example;

/**
 * showWithParen, showWithAster 메서드는 Main 클래스에서는 완전히 숨겨져 있습니다.
 * PrintBanner 클래스가 어떻게 구현되어 있는지는 Main 클래스는 모릅니다, Main 클래스를
 * 전혀 변경하지 않고도 PrintBanner 클래스의 구현을 바꿀수 있습니다.
 */
public class AdapterExtendsExMain {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printString();
    }
}
/*
실행 결과
(Hello)
*Hello*
 */