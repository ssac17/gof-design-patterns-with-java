package structural.decorator;

/**
 * Border 클래스는 '장식틀'을 나타내는 추상 클래스로, 문자열을 표시하는 Display 클래스의 하위 클래스로 정의되어 있습니다.
 * 즉, 상속에 의해 장식틀은 내용물과 동일한 메서드를 갖게 됩니다. 구체적으로 말하면 Border 클래스는
 * getColumns, getRows, getRowText, show 메서드를 상속받습니다. 장식틀(Border)이 내용물(Display)과 같은 메서드를 갖는 다는 것은
 * 인터페이스(API) 관점에서 보면 장식틀과 내용물을 동일시 할수 있다는 뜻입니다.
 * 장식틀 Border 클래스는 Display형의 display 필드를 가지고 있습니다. display 필드는 장식틀 안의 '내용물'을 가리킵니다.
 * 하지만 display의 내용물이 반드시 StringDisplay  인스턴스라고는 할 수 없습니다. Border도 Display의 하위 클래스이므로 display 필드의
 * 내용물은 또 다른 장식틀(Border 클래스의 하위 클래스의 인스턴스)일지도 모릅니다. 그리고 그 장식틀 또한 display 필드를 가지고 있을수도 있습니다
 */
public abstract class Border extends Display {
    protected Display display; //이 장식들이 감싸는 내용물
    protected Border(Display display) { //인스턴스 생성 시 내용물을 인수로 지정
        this.display = display;
    }
}
