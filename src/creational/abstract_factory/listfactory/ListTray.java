package creational.abstract_factory.listfactory;

import creational.abstract_factory.factory.Item;
import creational.abstract_factory.factory.Tray;

/**
 * ListTray 클래스는 Tray 클래스이 하위 클래스입니다.
 * 여기서 변수 item의 내용이 실제로 무엇인지 조사해서 switch문이나 if문을 사용하는 프로그램을 작성해선 안됩니다.
 * 그렇게 하면 매우 비객체지형적인 프로그램이 되고 맙니다. 변수 item은 Item형이고 Item 클래스에는 makeHTML이라는 메서드가 선언되어 있습니다.
 * 그리고 ListLink나 ListTray는 모두 Item 클래스의 하위 클래스입니다. 그러므로 안심하고 makeHTML 메서드를 호출해도 됩니다.
 * 나머지는 능숙하게 item이 makeHTML 메서드를 처리해 줍니다. 어떻게 처리할지는 item이라는 하나의 인스턴스(객체)가 알고 있습니다.
 * 이것이 객체지향의 장점입니다.
 */
public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>\n");
        sb.append(caption);
        sb.append("\n<ul>\n");
        for (Item item : tray) {
            sb.append(item.makeHTML());
        }
        sb.append("</ul>\n");
        sb.append("</li>\n");
        return sb.toString();
    }
}
