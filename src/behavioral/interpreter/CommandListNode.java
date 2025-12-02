package behavioral.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * <command>가 0회 이상 반복되고 마지막에 end가 옵니다. CommandListNode 클래스는 0회 이상 반복하는
 * <command>를 가지고자 java.util.List<Node>형 필드 list를 가지고 있습니다. 이 필드는 <command>에 해당
 * 하는 CommandNode 클래스의 인스턴스를 저장합니다. parse 메서드는 우선 현재 주목하고 있는 토큰, context.currentToken()의
 * 값이 null이면 더는 남은 토큰이 없다(즉, 프로그램을 끝까지 읽었다)는 것입니다. 이 경우, parse 메서드는 'end가 없다(Missing end)'라는
 * 메세지를 붙여 ParseException 예외를 던집니다. 현재 주목하는 토큰이 end가 아니면, 그것은 <command>라는 의미이므로,
 * CommandNode 인스턴스를 만들어 parse합니다. 그럼 다음 인스턴스를 CommandListNode의 list 필드에 add합니다.
 */
public class CommandListNode extends Node {
    //<command list> ::= <command>* end
    private List<Node> list = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if(context.currentToken() == null) {
                throw new ParseException("Error: Missing 'end'");
            }else if(context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            }else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
