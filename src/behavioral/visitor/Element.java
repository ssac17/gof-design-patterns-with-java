package behavioral.visitor;

/**
 * Element 인터페이스는 방문자를 받아들이는 인터페이스입니다. Visitor 클래스가 방문자라면 Element 인터페이스는 방문하는곳입니다.
 */
public interface Element {
    public abstract void accept(Visitor v);
}
