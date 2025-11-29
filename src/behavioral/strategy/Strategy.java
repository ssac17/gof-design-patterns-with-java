package behavioral.strategy;

/**
 * Strategy 인터페이스는 가위바위보 전략을 위한 추상 메서드를 모은 것입니다.
 * nextHand는 '다음에 낼 손을 얻기 위한' 메서드입니다. 이 메서드를 호출하면 Strategy 인터페이스를 구현하는 클래스는 지혜를 짜내서 '다음에 낼 손'을 결정합니다.
 * study는 '직전에 낸 손으로 이겼는지 졌는지'를 학습하는 메서드 입니다.
 * 직전 nextHand 메서드 호출에서 이긴 경우에는 study(true)로 호출하고, 진 경우에는 study(false)로 호출합니다.
 * 이에 따라 Strategy 인터페이스를 구현하는 클래스는 자신의 내부 상태를 변화시키고, 다음 번 이후에 nextHand 메서드를 반환값을 결정하는 재료롤 사용합니다.
 */
public interface Strategy {
    public abstract Hand nextHand();
    public abstract void study(boolean win);
}
