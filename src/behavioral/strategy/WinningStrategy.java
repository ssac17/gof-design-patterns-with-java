package behavioral.strategy;

import java.util.Random;

/**
 * WinningStrategy 클래스는 Strategy 인터페이스를 구현하는 클래스 중 하나입니다. 이클래스는 이전 승부에 이겼다면,
 * 다음에도 같은 손을 내는 어리석은 전략을 취합니다. 만약 이전 스부에서 졌다면, 다음 손은 난수를 사용하여 결정합니다.
 */
public class WinningStrategy implements Strategy{
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if(!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
