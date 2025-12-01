package structural.flyweight;

/**
 * BigString 클래스는 BigChar를 모은 '큰 문자열' 클래스입니다. bigchars 필드는 BigChar의 배열이며,
 * BigChar의 인스턴스를 저장합니다. 생성자의 for문을 보면 getBigChar를 사용해 작성되어 있습니다.
 * factory.getBigChar -> new BigChar(X), new를 사용하지 않습니다.
 */
public class BigString {
    //큰 문자의 배열
    private BigChar[] bigChars;

    //생성자
    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigChars = new BigChar[string.length()];
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    //표시
    public void print() {
        for (BigChar bc : bigChars) {
            bc.print();
        }
    }
}
