package behavioral.state;

/**
 * DayState클래스는 주간 상태를 나타내느 클래스이고, State 인터페이스에서 선언된 메서드를 구현합니다.
 * 상태를 나타내는 클래스는 인스턴스를 하나씩만 만든다고 가정합니다. 상태가 변화할 때마다 새로운 인스턴스를 만들면
 * 메모리와 시간이 낭비되기 때문입니다. 그 때문에 Singleton 패턴을 사용했습니다.
 * doClock 메서드는 시간을 설정하는 메서드입니다. 인수로 주어진 시간이 야간이면 야간 상태로 시스템을 전환합니다.
 * 이 때 상태 변화가 일어납니다. 여기서는 Context 인터페이스의 changeState 메서드를 사용하여 상태 변화를 표현합니다.
 * 야간 상태는 NightState 클래스로 표현되며 해당 인스턴스는 GetInstance 메서드로 얻고 있습니다.
 * (여기서도 Singleton 패턴입니다.)
 * doUse, doArarm, doPhone은 가가가 금고 사용, 비상벨, 일반 통화라는 메서드입니다.
 * 각 메서드는 Context의 메서드를 호출하여 필요한 처리를 할 뿐이빈다. 이들 메서드 안에 '현재 상태를 체크'하는
 * if문이 들어가지 않은 것을 확인할수 있습니다. State 패턴에서는 상태의 차익 ㅏ클래스의 차이로 표현되므로,
 * if문이나 switch문을 사용해 상태별로 분기할 필요가 없습니다.
 */
public class DayState implements State{
    private static DayState singleton = new DayState();

    private DayState() {}

    public static DayState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if(hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }
}
