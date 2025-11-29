package behavioral.chain_of_responsibility;

/**
 * Support 클래스는 문제 해결 사슬을 만들기 위한 추상 클래스입니다.
 * next 필드는 떠넘길 곳을 나타내며, setNext 메서드로 떠넘길 곳을 설정합니다.
 * resolve 메서드는 하위 클래스에서 구현하는 것을 가정한 추상 메서드로, '트러블을 해결하는'처리를 나타냅니다.
 * 반환값이 true일 때는 트러블이 해결되었음을 나타내고, false일 때는 트러블이 아직 해결되지 않았음(다음에 반복한다)을 나타냅니다.
 * support 메서드는 resolve 메서드를 호출한 후 반환값이 false이면 '다음 사람'에게 트러블 처리를 떠넘깁니다.
 * '다음 사람'이 없는 경우에는 자신이 사슬의 마지막이고 ,아무도 해결하지 못한 것이 되므로 그 사실을 표시합니다.
 * 여기에서는 표시만 하면 되지만, 프로그램에 따라서는 예외를 던지는 것이 적절할 수 도 있습니다.
 * 덧붓여 support 메서드는 추상 메서드 resolve를 사용한 Template Method 패턴으로 되어 있습니다.
 */
public abstract class Support {
    private String name; //이 트러블 해결자 이름
    private Support next; //떠넘길 곳

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    //떠넘길 곳을 설정
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    //트러블 해결 절차를 결정
    public void support(Trouble trouble) {
        if(resolve(trouble)) {
            done(trouble);
        }else if(next != null) {
            next.support(trouble);
        }else {
            fail(trouble);
        }
    }

    //해결하려고 함
    protected abstract boolean resolve(Trouble trouble);

    //해결함
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    //해결하지 않음
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
