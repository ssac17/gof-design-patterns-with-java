package behavioral.state;

/**
 * NightState 클래스는 야간 상태를 나타내는 클래스입니다. 이 클래스도 DayState 클래스와 마찬가지로
 * Singleton 패턴을 사용합니다. DayState 클래스와 구성을 동일합니다.
 */
public class NightState implements State{
    private static NightState singleton = new NightState();

    private NightState() {}

    public static NightState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if(9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상: 야간 금고 사용!");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야간)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("야간 통화 녹음");
    }

    @Override
    public String toString() {
        return "[야간]";
    }
}
