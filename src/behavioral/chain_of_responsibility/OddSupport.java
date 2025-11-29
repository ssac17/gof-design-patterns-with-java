package behavioral.chain_of_responsibility;

/**
 * OddSupport 클래스는 홀수 번호 문제를 해결하는 클래스입니다.
 */
public class OddSupport extends Support{

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() % 2 == 1) {
            return true;
        }else {
            return false;
        }
    }
}
