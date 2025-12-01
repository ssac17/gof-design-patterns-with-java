package behavioral.observer;

/**
 * Observer 인터페이스는 '관찰자'를 나타내는 인터페이스입니다. 구체적인 관찰자가 이 인터페이스를 구현합니다.
 * 이 Observer 인터페이스는 예제 프로그램용으로 만든 것이므로, Java 클래스 라이브러리에 java.util.Observer와는 다릅니다.
 * update 메서드를 호출하는 것은 숫자를 생성하는 NumberGenerator입니다. update  메서드는 NumberGenerator가
 * 내용이 갱신될 때 표시하는 쪽도 갱신해 달라 Observer에 전달하기 위한 메서드입니다.
 *
 */
public interface Observer {
    public abstract void update(NumberGenerator generator);
}
