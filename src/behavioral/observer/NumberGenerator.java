package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * NumberGenerator 클래스는 수를 생성하는 추상 클래스입니다. 실제로 수를 생성하는 부분 execute 메서드와
 * getNumber 메서드는 하위 클래스에서 구현해야 하는 추상 메서드로 표현 되어 있습니다.
 * observers 필드는 NumberGenerator를 관찰하는 Observer를 저장하는 메서드입니다.
 */
public abstract class NumberGenerator {
    //Observer를 저장
    private List<Observer> observers = new ArrayList<>();

    //Observer를 추가
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    //Observer를 제거
    public void removeObservers(Observer observer) {
        observers.remove(observer);
    }

    //Observer에 통지
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    //수를 취득
    public abstract int getNumber();

    //추를 생성
    public abstract void execute();
}
