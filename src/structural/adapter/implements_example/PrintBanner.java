package structural.adapter.implements_example;

import structural.adapter.Banner;

/**
 * 위임을 사용한 패턴 예제입니다.
 * 일반적으로 상속을 사용하것 보다 위임을 사용하는 편이 문제가 적습니다.
 * 상위 클래스의 내부 동작을 자세히 모르면 상송을 효과적으로 사용하기 어려운 경우가 많기 때문입니다.
 */
public class PrintBanner extends Print{

    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();

    }

    @Override
    public void printString() {
        banner.showWithAster();
    }
}
