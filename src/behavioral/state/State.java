package behavioral.state;

/**
 * State 인터페이스는 금고의 상태를 나타냅니다. State 인터페이스에는 다음과 같은 사건에 대응해서 호출할 인터페이스(API)가 선언되어 있습니다.
 * - 시간이 설정되었을 때
 * - 금고가 사용되었을 때
 * - 비상벨이 눌렸을 때
 * - 일반 통화를 할 때
 */
public interface State {
    public abstract void doClock(Context context, int hour);
    public abstract void doUse(Context context);
    public abstract void doAlarm(Context context);
    public abstract void doPhone(Context context);
}
