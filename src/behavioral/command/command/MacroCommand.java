package behavioral.command.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * MacroCommand 클래스는 '복수의 명령은 모은 명령'을 나타냅니다. 이 클래스는 Command 인터페이스를 구현합니다.
 * MacroCommand 클래스의 commands 필드는 java.util.Deque 인터페이스형으로, 여러 command의 인스턴스를 모아 두기 위한 것입니다.
 * Deque는 double ended que(양단 큐) 데이터 구조를 나타내는 인터페이스로, 여기서는 push와 pop을 할수 있는 스택으로 사용합니다.
 */
public class MacroCommand implements Command{
    //명령들의 배열
    private Deque<Command> commands = new ArrayDeque<>();

    //실행
    @Override
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute();
        }
    }

    //추가
    public void append(Command cmd) {
        if(cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    //마지막 명령을 삭제
    public void undo() {
        if(!commands.isEmpty()) {
            commands.pop();
        }
    }

    //전부 삭제
    public void clear() {
        commands.clear();
    }
}
