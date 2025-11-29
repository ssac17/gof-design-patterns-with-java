package behavioral.strategy;

import java.util.Random;

/**
 * ProbStrategy 클래스는 구체적인 '전략'입니다. 다음 손을 항상 난수로 결정하는데,
 * 과거에 이기고 진 이력을 활용해서 각각의 손을 낼 확률을 바꾸는 것입니다.
 * history 필드는 과거의 승패를 반영한 확률 계산을 위한 표로 되어 있습니다.
 * history[진전에 낸 손][이번에 낼 손]
 * 구체적으로
 * history[0][0]바위, 바위를 내가 냈을 때 과거의 승수, 값이 3
 * history[0][1]바위, 가위를 내가 냈을 때 과거의 승수, 값이 5
 * history[0][2]바위, 보를 내가 냈을 때 과거의 승수, 값이 7
 * 직전에 내가 바위을 냈다고 치면 다음에 내가 무엇을 낼지를 위에 history[0][0], history[0][1], history[0][2] 값을 이용해 확률로 계산하는 것입니다.
 * 이때 바위, 가위 ,보를 내는 비율을  3:5:7로 하고 다음 손을 결정합니다. 0 이상 15미만(15는 3+5+7의 값)의 난수값을 얻어 다음과 같이 결정합니다.
 * 0 이상 3미만이면 바위 (확률 3/15)
 * 3 이상 8미만이면 바위 (확률 5/15)
 * 8 이상 15미만이면 바위 (확률 7/15)
 * study 메서드는 nextHand 메서드에서 반환한 손의 승패를 바탕으로 history 필드에 내용을 갱신합니다.
 * - 이 전략에서는 상대의 가위바위보 방법에 일종의 패턴이 있다는 가정합니다.
 */
public class ProbStrategy implements Strategy{
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handValue = 0;
        if(bet < history[currentHandValue][0]) {
            handValue = 0;
        }else if(bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handValue = 1;
        }else {
            handValue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handValue;
        return Hand.getHand(handValue);
    }

    private int getSum(int handValue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[handValue][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if(win) {
            history[prevHandValue][currentHandValue]++;
        }else {
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
