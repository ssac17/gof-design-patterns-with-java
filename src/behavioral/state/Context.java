package behavioral.state;

/**
 * Context 인터페이스는 상태를 관리하거나 경비 센터를 호출합니다.
 * 실제로 무슨 일을 하는지는 SafeFrame 클래스를 보면서 설명하겠습니다.
 */
public interface Context {
    public abstract void setClock(int hour);
    public abstract void changeState(State state);
    public abstract void callSecurityCenter(String msg);
    public abstract void recordLog(String msg);
}
