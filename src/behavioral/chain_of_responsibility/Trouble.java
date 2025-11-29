package behavioral.chain_of_responsibility;

/**
 * Trouble 클래스는 발생한 트러블을 표현하는 클래스입니다.
 */
public class Trouble {
    //트러블 번호
    private int number;

    //트러블 생성
    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[Trouble " +
                 number +
                ']';
    }
}
