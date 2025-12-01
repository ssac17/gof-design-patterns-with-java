package behavioral.state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SafeFrame 클래스는 GUI를 사용하여 금고 경비 시스템을 실현합니다. 'safe'는 금고라는 뜻입니다. SafeFrame 클래스는 Context 인터페이스를 구현합니다.
 * SafeFrame 클래스의 필드는 화면에 표시되는 텍스트 필드나 텍스트 영역, 버튼 등의 부품니다. 단, state 필드만은 화면에 등장하는 부품이 아니고,
 * 금고의 현재 상태를 나타냅니다. 처음에는 '주간' 상태로 초기화 됩니다. 각 버튼 addActionListener 메서드를 호출하여 리스너를 설정합니다.
 * 이때 addActionListener 메서드의 인수로 '버튼을 눌렀을 때 호출될 인스턴스'를 지정합니다. addActionListener 메서드의 인수는 ActionListener 인터페이스의
 * actionPerformed 메서드로 구현합니다. 버튼을 눌렀을 때 , 리스너가 호출되는 구조는 Observer 패턴과 비슷합니다.
 */
public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60);           //현재 시간 표시
    private TextArea textScreen = new TextArea(10, 60);  //경비 센터 출력
    private Button buttonUse = new Button("금고 사용");            //금고사용 버튼
    private Button buttonAlarm = new Button("비상벨");            //비상벨 버튼
    private Button buttonPhone = new Button("일반 통화");         //일반 통화 버튼
    private Button buttonExit = new Button("종료");             //종료 버튼

    private State state = DayState.getInstance();                     //현재 상태

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        //textClock 배치
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        //textScreen 배치
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        //패널에 버튼 저장
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        //그 패널을 배치
        add(panel, BorderLayout.SOUTH);
        //표시
        setVisible(true);
        //리스너 설정
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    //버튼이 눌리면 이 메서드로
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if(e.getSource() == buttonUse) { //금고 사용 버튼
            state.doUse(this);
        }else if(e.getSource() == buttonAlarm) { //비상벨 버튼
            state.doAlarm(this);
        }else  if(e.getSource() == buttonPhone) { //일반 통화 버튼
            state.doPhone(this);
        }else if(e.getSource() == buttonExit) { //종료 버튼
            System.exit(0);
        }else {
            System.out.println("?");
        }
    }

    //시간 설정
    @Override
    public void setClock(int hour) {
        String clockstring = String.format("현재 시간은 %02d:00", hour);
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }

    //상태 전환
    @Override
    public void changeState(State state) {
        System.out.println(this.state + "에서 " + state + "으로 상태가 변화했습니다.");
        this.state = state;
    }

    //경비 센터 경비원 호출
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    //경비 센터 기록
    @Override
    public void recordLog(String msg) {
        textScreen.append("record... " + msg + "\n");
    }
}
