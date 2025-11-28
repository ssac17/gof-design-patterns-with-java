package creational.abstract_factory.factory;

/**
 * HTML 하이퍼링크를 추상적으로 표현한 클래스입니다.
 * Link 클래스에서는 추상 메서드가 전혀 등장하지 않은 것처럼 보이지만, Link 클래스에서는 상위 클래스(Item)의 추상 메서드(makeHTML)를
 * 구현하지 않았습니다. 그래서 Link 클래스도 추상 클래스가 됩니다.
 */
public abstract class Link extends Item{
    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
