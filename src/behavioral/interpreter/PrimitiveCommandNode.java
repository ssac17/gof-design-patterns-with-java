package behavioral.interpreter;

/**
 * PrimitiveCommandNode 클래스는에 해당하는 BNF는 <primitive command> ::= go | right | left 와 같습니다.
 * PrimitiveCommandNode 클래스의 parse 메서든에서는 다른 parse 메서들를 호출하지 않았습니다.
 */
public class PrimitiveCommandNode extends Node {
    //<primitive command> ::= go | right | left
    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        if(name == null) {
            throw new ParseException("Error: Missing <primitive command>");
        }else if(!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            System.out.println(name);
            throw new ParseException("Error: Unknown <primitive command>: '" + name + "'");
        }
        context.skipToken(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
