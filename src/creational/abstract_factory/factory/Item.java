package creational.abstract_factory.factory;

/**
 * Item 클래스는 Link와 Tray의 상위 클래스로 되어 있습니다.
 * 이것은 Link와 Tray를 동일시 하기 위한 클래스입니다.
 */
public abstract class Item {
    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    public abstract String makeHTML();
}
