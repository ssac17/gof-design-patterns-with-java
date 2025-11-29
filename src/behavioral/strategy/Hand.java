package behavioral.strategy;

/**
 * Hand는 가위바위보의 '손'을 나타내는 enum형으로 가위, 바위, 보를 각각 ROCK, SCISSORS, PAPER를 상수로 나타냅니다.
 * Hand형을 클래스의 일종으로 생각하고, enum 상수인 ROCK, SCISSORS, PAPER의 인스턴스로 봐도 무방합니다.
 * isStrongerThen과 isWeakerThen은 Hand형인 hand1과 hand2라는 두개의 손이 있을때, 강약을 비교합니다.
 */
public enum Hand {
    //가위 바위 보를 나타내는 세 개의 enum 상수
    ROCK("바위", 0),
    SCISSORS("가위", 1),
    PAPER("보", 2);

    //enum이 가진 필드
    private String name; //가위 바위 보의 이름
    private int handValue; //가위 바위 보의 값

    //손의 값으로 상수를 얻기 위한 배열
    private static Hand[] hands = {
            ROCK, SCISSORS, PAPER
    };

    //생성자
    Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    //손의 값으로 enum 상수를 가져온다
    public static Hand getHand(int handValue) {
        return hands[handValue];
    }

    //this가 h보다 강할 때 true
    public boolean isStrongerThen(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThen(Hand h) {
        return fight(h) == -1;
    }

    //무승부는 0, this가 이기면 1, h가 이기면 -1
    private int fight(Hand h) {
        if(this == h) {
            return 0;
        }else if((this.handValue + 1) % 3 == h.handValue) {
            return 1;
        }else {
            return -1;
        }
    }

    //가위 바위 보의 문자열 표현
    @Override
    public String toString() {
        return name;
    }
}
