package creational.prototype.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Manager 클래스는 Product 인터페이스를 이용해 인스턴스를 복제하는 클래스입니다.
 * Product 인터페이스와 Manager 클래스의 소스 코드에 MessageBox 클래스나 UnderlinePen 클래스의 이름이 전혀 나오지 않는 점을 주목하세요.
 * 이름이 나오지 않는다는건 그 클래스 들과는 독립적으로 수정할수 있다는 것을 뜻합니다.
 * Manager 클래스에서는 구체적인 개별 클래스 이름을 쓰지 않고, 오직 Product라는 인터페이스 이름만 사용합니다.
 * 이 인터페이스만이 Manager 클래스와 다른  클래스를 연결하는 다리가 됩니다.
 */
public class Manager {
    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    public Product create(String prototypeName) {
        Product p = showcase.get(prototypeName);
        return p.createCopy();
    }
}
