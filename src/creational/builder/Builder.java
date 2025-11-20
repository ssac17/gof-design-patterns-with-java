package creational.builder;

/**
 * 문서를 만드는 메서드들을 선언한 추상 클래스입니다.
 */
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();

}
