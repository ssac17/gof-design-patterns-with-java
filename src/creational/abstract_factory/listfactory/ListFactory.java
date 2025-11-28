package creational.abstract_factory.listfactory;

import creational.abstract_factory.factory.Factory;
import creational.abstract_factory.factory.Link;
import creational.abstract_factory.factory.Page;
import creational.abstract_factory.factory.Tray;

/**
 * ListFactory 클래스에서는 Factory 클래스의 추상 메서드 createLink, createTray, createPage를 구현했습니다.
 * 여기에서는 단순히 ListLink, ListTray, ListPage를 new 합니다.
 */
public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
