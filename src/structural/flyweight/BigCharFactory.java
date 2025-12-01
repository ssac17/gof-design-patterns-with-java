package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * BigCharFactory 클래스는 BigChar의 인스턴스를 만드는 공장입니다. 여기서 구조를 실현하고 있습니다.
 * pool 필드는 기존에 만든 BigChar 인스턴스를 관리합니다. BigCharFactory의 pool에는 이미 만들어진
 * BigChar의 인스턴스가 모여있습니다. 여기서 BigCharFactory 클래스는 Singleton 패턴을 사용해 구현했습니다.
 * BigCharFactory의 인스턴스는 하나만 존재하면 되기 때문입니다. getBigChar 메서드는 Flyweight 패턴의 중심이
 * 되는 메서드 입니다. 이 메서드는 인수로 주어진 문자에 대응하는 BigChar 인스턴스를 만듭니다. 단, 이미 같은 문자
 * 에 대응하는 인스턴스가 없으면 새로만들지 않고 이전에 만들었던 인승턴스를 반환값을 합니다.
 */
public class BigCharFactory {
    //이미 만든 BigChar 인스턴스를 관리
    private Map<String, BigChar> pool = new HashMap<>();

    //Singleton 패턴
    private static BigCharFactory singleton = new BigCharFactory();

    //생성자
    private BigCharFactory() {}

    //유일한 인스턴스
    public static BigCharFactory getInstance() {
        return singleton;
    }

    //BigChar 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = pool.get(String.valueOf(charname));
        if(bc == null) {
            //여기서 BigChar 인스턴스를 생성
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc);
        }
        return bc;
    }
}
