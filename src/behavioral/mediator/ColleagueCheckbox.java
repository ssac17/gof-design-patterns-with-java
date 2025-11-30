package behavioral.mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * ColleagueCheckbox 클래스는 java.awt.Checkbox 클래스의 하위 클래스입니다. 예제 프로그램에서는 체크 박스가 아니라
 * 라디오 버튼으로 사용합니다(CheckboxGroup). 이 클래스에서는 라디오 버튼의 상태 변화를 itemStateChanged 메서드로
 * 파악하기 위해 java.awt.event.ItemListener 인터페이스도 구현합니다.
 */
public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state);
    }

    //Mediator 설정
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    //Mediator에ㅓ 활성/비활성을 지시
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //상태가 변화하면 Mediator에 알림
        mediator.colleagueChanged();
    }
}
