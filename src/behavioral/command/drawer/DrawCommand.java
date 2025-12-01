package behavioral.command.drawer;

import behavioral.command.command.Command;

import java.awt.Point;

/**
 * DrawCommand 클래스는 Command 인터페이스를 구현한 클래스로, '점을 그리는 명령'을 표현한 것입니다. 이 클래스는
 * drawable과 position이라는 두개의 필드가 있습니다. drawable 필드에는 그리기를 실행할 대상을 저장합니다.
 * position 필드는 그리기를 실행할 위치를 나타냅니다. Point 클래스는 java.awt 패키지에 정의되어 있는 클래스로
 * X좌표와 Y좌표를 갖는 2차원 평면의 위치를 나타냅니다. 생성자에서는 Drawable 인터페이스를 구현한 클래스의 인스턴스와
 * Point 클래스의 인스턴스를 인수로 넘겨 필드에 대입합니다. 이것이 '이 위치에 점을 그리라'는 명령을 만드는 부분입니다.
 */
public class DrawCommand implements Command {

    //그리는 대상
    protected Drawable drawable;

    //그리는 위치
    private Point position;

    //생성자
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    //실행
    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
