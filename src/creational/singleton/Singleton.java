package creational.singleton;

/**
 * Singleton은 static 필드로 정의하고 Singleton 클래스의 인스턴스에서 초기화합니다.
 * 초기화는 Singleton 클래스를 로드 할때 한번만 실행됩니다.
 * Singleton 클래스의 생성자는 private로 되어 있습니다.
 * 이는 Singleton 클랙스 외부에서 생성자 호출을 금지하기 위해서입니다.
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("인스턴스를 생성했습니다.");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
