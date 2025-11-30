package behavioral.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {

    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    //Colleague를 생성하고 배치한 후에 표시
    public LoginFrame(String title) {
        super(title);

        //배경색 설정
        setBackground(Color.LIGHT_GRAY);

        //레이아웃 매니저를 사용해 4x2 그리드를 만듬
        setLayout(new GridLayout(4, 2));

        //Colleague를 생성
        createColleagues();

        //배치한다
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        //활성/비활성 초기 설정
        colleagueChanged();

        //표시
        pack();
        setVisible(true);
    }

    //Colleague 생성
    @Override
    public void createColleagues() {
        //CheckBox
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        //TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);

        //Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        //Mediator를 설정
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        //Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);

    }

    //Colleague 상태가 바뀌면 호출
    @Override
    public void colleagueChanged() {
        if(checkGuest.getState()) {
            //게스트 로그인
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        }else {
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    //textUser 또는 textPass의 변경이 있다
    //각 Colleague의 활성/비활성을 판정
    private void userpassChanged() {
        if(textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if(textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            }else {
                buttonOk.setColleagueEnabled(false);
            }
        }else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
