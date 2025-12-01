package behavioral.observer;

import java.util.Random;

/**
 * RandomNumberGenerator 클래스는 NumberGenerator의 하위 클래스로 난수를 생성합니다.
 * random 필드에는 java.util.Random 클래스의 인스턴스가 저장되고, number 필드에는 현재의 난수값이 저장됩니다.
 * execute 메서드는 난수(0~49 범위의 정수)를 20개 생성하고, 그때마다 notifyObservers를 사용하여 관찰자에게 통지합니다.
 */
public class RandomNumberGenerator extends NumberGenerator{

    public Random random = new Random(); //난수 생성
    public int number; //현재 수

    //수를 취득
    @Override
    public int getNumber() {
        return number;
    }

    //수를 생성
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
