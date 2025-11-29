package structural.bridge;

/**
 * 여기서부터가 '구현의 클래스 계층'입니다. DisplayImpl 클래스는 구현의 클래스 계층 최상위에 위치합니다.
 * DisplayImpl 클래스는 추상 클래스로 rawOpen, rawPrint, rawClose라는 세가지 메서드를 가지고 있습니다.
 * 이것은 Display 클래스의 open, print, close에 각각 대응하며, 전처기, 표시, 후처리를 실행 합니다.
 */
public abstract class DisplayImpl {

    public abstract void rawOpen();
    public abstract void rawPrint();
    public abstract void rawClose();
}
