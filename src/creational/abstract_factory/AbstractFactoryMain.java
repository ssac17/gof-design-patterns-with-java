package creational.abstract_factory;

import creational.abstract_factory.factory.Factory;
import creational.abstract_factory.factory.Link;
import creational.abstract_factory.factory.Page;
import creational.abstract_factory.factory.Tray;

/**
 * 여기서는 추상적인 공장을 사용해 추상적인 부품을 제조하고 추상적인 제품을 조립합니다.
 * import하는 것이 factory 패키지뿐이라는 점에서 알수 있듯이, 이 클래스에서는 구체적인 부품, 제품, 공장을 젼혀 이용하지 않습니다.
 * ex> java Main list.html listfactory.ListFactory
 * 이 인수(args[1])을 바탕으로 getFactory로 공장을 만들고 변수 factroy에 대입니다. 이후에 factory를 사용해
 * Link와 Tray를 만들고, Tray 안에 Link나 Tray를 넣을 후 마지막에 Page를 만들어 output을 실행합니다.
 * 실행 > java AbstractFactoryMain.java list.html creational.abstract_factory.listfactory.ListFactory
 *       java AbstractFactoryMain.java div.html creational.abstract_factory.divfactory.DivFactory
 */
public class AbstractFactoryMain {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: java Main filename.html clas.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main list.html listfactory.ListFactory");
            System.out.println("Example 2: java Main div.html divfactory.DivFactory");
        }

        String filename = args[0];
        String classname = args[1];
        Factory factory = Factory.getFactory(classname);

        //Blog
        Link blog1 = factory.createLink("Blog 1", "https://example.com/blog1");
        Link blog2 = factory.createLink("Blog 2", "https://example.com/blog2");
        Link blog3 = factory.createLink("Blog 3", "https://example.com/blog3");

        Tray blogTray = factory.createTray("Blog Site");
        blogTray.add(blog1);
        blogTray.add(blog2);
        blogTray.add(blog3);

        //News
        Link news1 = factory.createLink("News 1", "https://example.com/new1");
        Link news2 = factory.createLink("News 2", "https://example.com/new2");
        Tray news3 = factory.createTray("News 3");
        news3.add(factory.createLink("News 3 (US)", "https://example.com/news3us"));
        news3.add(factory.createLink("News 3 (Korea)", "https://example.com/news3kr"));

        Tray newsTray = factory.createTray("News Site");
        newsTray.add(news1);
        newsTray.add(news2);
        newsTray.add(news3);

        //Page
        Page page = factory.createPage("Blog and News", "Youngjin.com");
        page.add(blogTray);
        page.add(newsTray);

        page.output(filename);
    }
}
