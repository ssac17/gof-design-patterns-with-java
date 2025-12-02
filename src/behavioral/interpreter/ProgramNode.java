package behavioral.interpreter;

/**
 * <program>을 나타내는 ProgramNode 클래스입니다. 이 클래스에서는 Node형 CommandListNode 필드가 있습니다.
 * 이 필드는 자신의 뒤에 이어지는 <command list>에 대응하는 구조(노드)를 저장하기 위한 것입니다.
 * 구문 해석을 할때 처리 단위를 토큰(token)이라고 부릅니다. 이 미니 언어에서 '토큰'은 '영어 단어'와 동의어이지만,
 * 일반적인 프로그래밍 언어에서느 +나 == 등도 토큰이 됩니다. 자세히 말하면, 어휘 분석(lex)은 문자로부터 토큰을 만들고,
 * 구문 해석(parse)은 토큰으로부터 구문 트리를 만듭니다. skipToken 메서드는 program이라는 토큰을 건너뜁니다.
 * program이라는 토큰이 없다면 ParseException 예외를 던집니다. 그 뒤로 <command list>가 이어집니다.
 * <command list>에 대응하는 CommandListNode의 인스턴스를 생성하고, 그 인스턴스의 parse 메서드를 호출합니다.
 * <command list>가 어떤 내용으로 되어 있는지는 ProgramNode 클래스의 메서드에는 기술되어 있지 않은 것의 주의해주세요.
 */
public class ProgramNode extends Node{
    // <program> ::= program <command list>
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        //'program'이라는 단어가 들어오면 건너뜀
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
