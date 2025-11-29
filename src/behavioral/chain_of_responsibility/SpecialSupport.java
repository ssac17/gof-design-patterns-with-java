package behavioral.chain_of_responsibility;

/**
 * SpecialSupport 클래스는 지정한 번호의 문제에 한해 해결하는 클래스입니다.
 */
public class SpecialSupport extends Support{
    //이 번호만 해결할수 있음
    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() == number) {
            return true;
        }else {
            return false;
        }
    }
}
