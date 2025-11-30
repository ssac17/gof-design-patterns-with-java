package behavioral.mediator;

import java.awt.Button;

/**
 * ColleagueButton 클래스는 java.awt.Button의 하위 클래스이고, Colleague 인터페이스를 구현하여 LoginFrame 클래스와 협조하며 동작합니다.
 * mediator 필드에는 setMediator로 전달되는 Mediator 객체를 저장합니다. setColleagueEnabled 메서드는 Java의 GUI에 정의된
 * setEnabled 메서드는 호출하여 활성화/비활성화를 설정합니다. setEnabled(true)이면 버튼을 누를수 있지만 setEnabled(false)면 버튼을 누를수 없습니다.
 */
public class ColleagueButton extends Button implements Colleague {

    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    //Mediator를 설정
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    //Mediator에서 활성/비활성을 지시
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
