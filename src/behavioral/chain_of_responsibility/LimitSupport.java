package behavioral.chain_of_responsibility;

/**
 * LimitSupport 클래스는 limit로 지정한 번호 미만의 문제를 해결하는 클래스입니다.
 * resolve 메서드에서는 판단 후 단순히 true를 반환할 뿐이지만, 원래대로라면 이곳에서 문제를 해결해 주어야 합니다.
 */
public class LimitSupport extends Support{
    //이 번호 미만이면 해결할수 있음
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() < limit) {
            return true;
        }else {
            return false;
        }
    }
}
