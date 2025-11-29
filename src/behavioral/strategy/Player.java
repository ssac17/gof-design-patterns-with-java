package behavioral.strategy;

/**
 * Player 클래스는 가위바위보하는 사람을 표현한 클래스입니다. Player 클래스는 주어진 '이름과 전략'으로 인스턴스를 만듭니다.
 * nextHand는 다음 손을 얻은 메서드인데, 실제로 다음 손을 결정하는 것은 자신의 '전략'입니다.
 * 전약의 nextHand 메서드의 반환값이 그대로 Player의 nextHand 메서드의 반환값이 됩니다.
 * nextHand 메서드는 자신이 해야 할 처리를 Strategy에 맡기고 있습니다. 다시 말해 '위임'하고 있습니다.
 * 이기거나, 지너가, 비기거나 한 승부 결과를 다음 승부에 헤 활용하고나 Player 클래스는 strategy 필드를 통해 study 메서드를 호출합니다.
 * study 메서드로 전략의 내부 상태를 변화시키는 것입니다.
 */
public class Player {
    private String name;
    private Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    //이름과 전략을 받아서 플레이어를 만듬

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    //전락에 따라 다음 손을 결정
    public Hand nextHand() {
        return strategy.nextHand();
    }

    //승리
    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    //패배
    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    //무승부
    public void even() {
        gameCount++;
    }

    @Override
    public String toString() {
        return  "["+ name +
                ", winCount= " + winCount +
                ", loseCount= " + loseCount +
                ", gameCount= " + gameCount +
                ']';
    }
}
