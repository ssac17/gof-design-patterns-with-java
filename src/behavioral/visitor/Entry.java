package behavioral.visitor;

/**
 * Entry 클래스는 Composite 패턴의 예제와 본질적으로 같지만, 여기서는 Element 인터페이스를 구현합니다.
 * 이는 Entry 클래스를 Visitor 패턴에 맞추기 위해서입니다. Element 인터페이스에서 선언되어 있는 추상 메서드 accept를
 * 실제로 구혀하는 것은 Entry의 하위 클래스이 File이나 Directory 클래스입니다.
 */
public abstract class Entry implements Element{
    public abstract String getName();
    public abstract int getSize();

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
