package behavioral.memento.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Memento 클래스는 주인공(gamer)의 상태를 나타내는 클래스입니다. Memento 클래스의 생성자에는 public이 없습니다.
 * 따라서 Memento 클래스의 인스턴스는 아무나 만들수 없습니다. 동일한 패키지(여기서는 game 패키지)에 속한 클래스에서만 사용할수 있습니다.
 * 구체적으로 Memento 클래스의 인스턴스는  game 패키지의 Gamer 클래스가 생성합니다.
 * addFruit 메서드는 과일을 추가하는 메서드입니다. 이 메서드도 public이 아닙니다. 과일을 추가할수 있는 것은 같은 패키지의 클래스뿐입니다.
 * 그러므로 game 패지키 외부에서 Memento 내부를 변경할수 없습니다.
 */
public class Memento {
    private int money; //소지금
    private List<String> fruits; //과일

    public int getMoney() {
        return money;
    }

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    public List<String> getFruits() {
        return new ArrayList<>(fruits);
    }
}
