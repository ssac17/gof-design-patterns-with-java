package creational.prototype.framework;

/**
 * java.lang.Cloneable 인터페이스를 상속한 Product 인터페이스는 복제를 가능하게 합니다.
 * createCopy는 인터페이스를 복제하기 위한 메서드입니다.
 *
 */
public interface Product extends Cloneable {
    public abstract void use(String s);
    public abstract Product createCopy();
}
