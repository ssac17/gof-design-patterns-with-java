package behavioral.command.drawer;

import behavioral.command.command.MacroCommand;

import java.awt.*;

/**
 * DrawCanvas 클래스는 Drawable 인터페이스를 구현하는 클래스로, java.awt.Canvas 클래스의 하위 클래스입니다.
 * 자신이 그려야 할 명령 집합은 history 필드에 저장합니다. 이 필드의 형은 command.MacroCommand 입니다.
 * paint 메서드는 DrawCanvas를 다시 그릴 필요가 있을 때, Java 처리 시스템(java.awt 프레임워크)에서 호출되는 메서드입니다.
 * 해야 할 처리는 history.execute를 호출하는 것뿐입니다. 이것만으로 history에 기록된 명령 집합이 다시 실행 됩니다.
 * draw 메서드는 Drawable 인터페이스를 구현하고자 정의된 메서드입니다.
 * 이 안에서 g.setColor로 색상을 지정하고 g.fillOval로 원을 표시합니다.
 */
public class DrawCanvas extends Canvas implements Drawable {

    //그리는 색
    private Color color = Color.RED;

    //그리는 점의 반지름
    private int radius = 6;

    //이력
    private MacroCommand history;

    //생성자
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.WHITE);
        this.history = history;
    }

    //이력 전체 다시 그리기
    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    //그리기
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
