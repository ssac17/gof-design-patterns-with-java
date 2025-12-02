package behavioral.interpreter;

/**
 * <number> 부분은 int형 number 필드, <command list> 부분은 Node형 commandListNode 필드에 저장됩니다.
 *   RepeatCommandNode의 parse 메서드 안에서는
 *     CommandListNode의 인스턴스를 만들어 parse 메서드를 호출하고
 *   CommandListNode의 parse 메서드 안에서는
 *     CommandNode의 인스턴스를 만들어 parse 메서드를 호출하고
 *   CommandNode의 parse 메서드 안에서는
 *     RepeatCommandNode 인스턴스를 만들어 parse 메서드를 호출하고
 *   RepeatCommandNode의 parse 메서든 안에서는...
 * 이렇게 재귀적인 정의 취급에 익수하지 않으면, 왠지 무한 루프가 될것 같은 생각이 들지만, 그것은 착각입니다.
 * 언젠가는 반드시 터미널 익스프레션에 도달하게 됩니다. 더미널 익스프레션에 도달하지 않으면 그정의 잘못된 것입니다.
 */
public class RepeatCommandNode extends Node {
    //<repeat command> ::= repeat <number> <command list>
    private int number;
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }
}
