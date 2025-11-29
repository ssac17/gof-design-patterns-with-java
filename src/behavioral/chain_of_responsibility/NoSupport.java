package behavioral.chain_of_responsibility;

/**
 * NoSupport 클래스는 Support 클래스의 하위 클래스입니다.
 * NoSupport 클래스의 resolve 메서드는 항상 false를 반환, 어떤 문제도 해결하지 않는 클래스입니다.
 */
public class NoSupport extends Support{

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        //자신은 아무것도 해결하지 않음
        return false;
    }
}
