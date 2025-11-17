package behavioral.template_method;

/**
 * d1, d2 모두 같은 AbstractDisplay 클래스의 하위 클래스의 인스턴스이므로
 * 실제 동작은 CharDisplay, StringDisplay 메서드에서 구현된 코드로 실행됩니다.
 */
public class templateMethodMain {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello, world");

        d1.display();
        d2.display();
    }
}
/*
실행 결과
<<HHHHH>>
+------------+
|Hello, world|
|Hello, world|
|Hello, world|
|Hello, world|
|Hello, world|
+------------+
 */