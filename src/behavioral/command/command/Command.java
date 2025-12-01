package behavioral.command.command;

/**
 * Command 인터페이스는 '명령'을 나타냅니다. 이 인테페이스에는 단 하나의 메서드 execute가 있습니다.
 *
 */
public interface Command {
    public abstract void execute();
}
