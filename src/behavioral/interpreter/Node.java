package behavioral.interpreter;

/**
 * Node 클래스느 구문 트리의 각 부분(노드)를 구성하는 최상위 클래스입니다. Node 클래스에는 추상 메서드 parse만 선언 되어 있습니다.
 * parse는 '구문 해석 처리'를 위한 메서드입니다. Node 클래스에서는 단순히 parse 메서드만 선언만 하고, 구체적으로 어떻게 해석할지는
 * Node 클래스의 하위 클래스 쪽에 맡깁니다(subclass responsibility).
 */
public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}