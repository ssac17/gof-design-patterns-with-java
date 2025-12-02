package behavioral.interpreter;

/**
 * Node형 필드 node는 <repeat command>에 대응하는 RepeatCommandNode 클래스의 인스턴스 또는
 * <primitive command>에 대응하는 PrimitiveCommandNode 클래스의 인스턴스를 저장하기 위해서 사용됩니다.
 */
public class CommandNode extends Node {
    //<command> ::= <repeat command> | <primitive command>
    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if(context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
            node.parse(context);
        }else {
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
