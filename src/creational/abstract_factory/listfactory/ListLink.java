package creational.abstract_factory.listfactory;

import creational.abstract_factory.factory.Link;

/**
 * ListLink 클래스는 Link 클래스이 하위 클래스입니다.
 * 구현해야할 메서드는 상위 클래스의 추상 메서드인 makeHTML 메서드 입니다.
 */
public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "    <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
