package behavioral.command;

import behavioral.command.command.MacroCommand;
import behavioral.command.drawer.DrawCanvas;
import behavioral.command.drawer.DrawCommand;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * CommandMain 클래스는 예제 프로그램을 실행하기 위한 클래스입니다. history 필드는 그리기 이력을 저장합니다.
 * 이것은 나중에 DrawCanvas의 인스턴스에 전달하는 것과 같습니다. 즉, 그리기 이력은 CommandMain의 인스턴스와
 * DrawCanvas 인스턴스에서 공유됩니다. canvas 필드는 그리는 영역입니다. 초기 크기는 400 X 400으로 지정했습니다.
 * clearButton 필드는 그린 점을 지우는 삭제 버튼입니다. JButton 클래스는 java.swing 패키지 클래스로 버튼을
 * 표현한 것입니다. 생성자에서는 마우스 클릭 등의 이벤트를 받는 리스너를 설정하고 컴포넌트를 배치하고 있습니다
 */
public class CommandMain extends JFrame implements MouseMotionListener, WindowListener {
    public static void main(String[] args) {
        new CommandMain("Command Pattern Sample");
    }

    //그리기 이력
    private MacroCommand history = new MacroCommand();
    //그리는 영역
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    //삭제 버튼
    private JButton clearButton = new JButton("clear");

    //생성자
    public CommandMain(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    //MouseMotionListener용
    @Override
    public void mouseDragged(MouseEvent e) {
        DrawCommand cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    //WindowListener용
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override public void mouseMoved(MouseEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
}
