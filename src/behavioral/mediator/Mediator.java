package behavioral.mediator;

/**
 * Mediator 인터페이스는 '중재자'를 나타내는 인터페이스입니다. 구체적인 중재자인 LoginFrame 클래스가 이 인터페이스를 구현합니다.
 * createColleagues 메서드는 이 Mediator가 관리할 멤버를 생성하는 메서드입니다. colleagueChanged 메서드는 멤버인 Colleague가 호춯하는 메서드입니다.
 * 이 메서드는 중재자에게 '상담'을 요청하는 것에 해당합니다. 예제 프로그램에서는 라디오 버튼이나 텍스트 필드 상태가 변화했을 때 이 메서드가 호출됩니다.
 */
public interface Mediator {
    //Colleague
    public abstract void createColleagues();

    //Colleague의 상태가 변화했을 때 호출된다
    public abstract void colleagueChanged();
}
