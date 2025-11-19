package creational.prototype;

import creational.prototype.framework.Product;

/**
 * createCopy는 자기 자신을 복제하는 메서드입니다. 여기서 호출하는 clone메서드는 Java 언어  사양으로 규정되어 있으며,
 * 자기 자신의 복제를 생성하는 메서드입니다. 복제를 생성할 때 인스턴스가 가진 필드 값도 그랟로 새 인스턴스에 복사됩니다.
 * clone 메서드로 복사 할수 있는 것은 java.lang.Cloneable 인터페이스를 구현한 클래스뿐입니다.
 * 만약 이 인터페이스가 구현되지 않은 경우에는 CloneNotSupportedException이 발생할수 있습니다.
 * MessageBox 클래스에서는 Product 인터페이스만 구현했지만, Product 인터페이스는 java.lang.Cloneable 인터페이스를 확장한것이므로
 * CloneNotSupportedException이 발생하지 않습니다. java.lang.Cloneable 인터페이스는 단순한 표시로 이용될 뿐이고, 이 인터페이스가 선언하는 메서드는 없습니다.
 */
public class MessageBox implements Product {
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
        System.out.println(decochar + s + decochar);
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;
        try{
            p = (Product) clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
