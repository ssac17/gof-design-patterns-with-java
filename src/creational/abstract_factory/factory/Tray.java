package creational.abstract_factory.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Tray 클래스는 복수의 Link나 Tray를 모아서 한데 묶는 클래스입니다.
 * Link나 Tray는 add 메서드를 사용해서 모읍니다. 'Link나 Tray'라는 부분을 표현하고자 add 메서드에서는 Link와 Tray의 상위 클래스인
 * Item을 인수로 받습니다.  Tray 클래스도 Item 클래스의 추상 메서드 makeHTML을 상속받지만 구현하지 않아, 그래서 Tray 클래스는 추상클래스가 됩니다.
 */
public abstract class Tray extends Item{
    protected List<Item> tray = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }
}
