package behavioral.mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * ColleagueTextField 클래스는 java.awt.TextField의 하위 클래스이고 Colleague 인터페이스를 구현합니다.
 * 이 클래스는 java.awt.event.TextListener 인터페이스도 구현합니다. 이유는 텍스트 내용의 변화를 textValueChanged 메서드로 파악하고 싶기 때문입니다.
 * Java의 클래스는 여러 클래스를 확장(extends)할수 없지만, 여러 인터페이스를 구현(implements) 할수 있습니다.
 * setColleagueEnabled 메서드에서는 setEnabled 메서드뿐만 아니라 setBackGround 메서드도 호출합니다.
 * 활성화 시에는 배경을 희색으로, 비활성화 시에는 밝은 회색으로 하기 위함니다.
 * textValueChanged 메서드는 TextListener 인터페이스를 위한 메서드로, 텍스트 내용에 변경이 있으면 AWT 프레임워크에서
 * 호출됩니다. 예제 프로그램의 textValueChanged 메서드에서는 colleagueChanged 메서드를 호추하여
 * 중재자에게 문자열을 내용이 바뀌었음을 알리고 있습니다.
 */
public class ColleagueTextField extends TextField implements TextListener, Colleague {

    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {
        super(text, columns);
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
        //활성/비활성에 맞게 배경색을 변경
        setBackground(enabled ? Color.WHITE : Color.LIGHT_GRAY);
    }

    @Override
    public void textValueChanged(TextEvent e) {
        //문자열이 바뀌면 Mediator에 알림
        mediator.colleagueChanged();
    }
}
