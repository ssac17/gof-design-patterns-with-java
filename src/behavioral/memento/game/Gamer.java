package behavioral.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Gamer 클래스는 게임 주인공을 나타내는 클래스로, 소지금(money)와 과일(fruits)과 난수 생성기(random)을 가지고 있습니다.
 * 게임의 중심이 되는 메서드는 bet입니다. 이 메서드는 만약 주인공이 파산하지 않았다면 주사위를 던지고 그 눈에 따라 소지금과 과일 개수를 변화시킵니다.
 * createMemento 메서드는 현재 상태를 저장하는 메서드입ㄴ다. 이 메서드에서는 Memento를 생성합니다.
 * 여기서는 현 시점에서의 소지금과 과일을 바탕으로 Memento의 인스턴스를 하나 만들고 있습니다. 이렇게 만들어진 Memento 인스턴스는 현재 Gamer 인스턴스의 상태를 나타냅니다.
 * 이것이 createMemento 메서드의 반환값입니다. 마치 사진을 찍듯 현재 상태를 Memento 인스턴스에 넣어둔 것입니다.
 * 과일에 대해서는 '맛있는' 것만 저장합니다.
 * restoreMemento는 createMemento 메서드와 반대로 실행을 취소(undo)하는 메서드 입니다.
 * 주어진 Memento 인스턴스를 바탕으로 자신의 상태를 복원합니다. 게임에서 부활 같은 겁니다.
 */
public class Gamer {
    //소지금
    private int money;

    //과일
    private List<String> fruits = new ArrayList<>();

    //난수 생성
    private Random random = new Random();

    //과일 이름표
    private static String[] fruitsName = {"사과", "포도", "바나나", "오렌지"};

    //생성자
    public Gamer(int money) {
        this.money = money;
    }

    //현재 소지금
    public int getMoney() {
        return money;
    }

    //내기한다, 게임 진행
    public void bet() {
        //주사위 던짐
        int dice = random.nextInt(6) + 1;
        if(dice == 1) {
            //1일때 소지금이 증가
            money += 100;
            System.out.println("소지금이 증가!");
        }else if(dice == 2) {
            //2일때 소지금이 절반
            money /= 2;
            System.out.println("소지금이 절반으로 줄었습니다..");
        }else if(dice == 6) {
            //6일때 과일을 받음
            String f = getFruit();
            System.out.println("과일(" + f + ")를 받았습니다.");
            fruits.add(f);
        }else {
            //그 외 수일때 아무것도 없음
            System.out.println("변동 사항이 없습니다.");
        }
    }

    //과일을 하나 얻음
    private String getFruit() {
        String f = fruitsName[random.nextInt(fruitsName.length)];
        if(random.nextBoolean()) {
            return "맛있는 " + f;
        }else {
            return f;
        }
    }

    //스냅샷을 찍음
    public Memento createMemento() {
        Memento m = new Memento(money);
        for (String f : fruits) {
            //과일은 맛있는 것만 저장
            if(f.startsWith("맛있는 ")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    //복원
    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }
}
