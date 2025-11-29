package behavioral.visitor;

/**
 * Visitor 클래스는 '방문자'를 나타내는 추상 클래스입니다. 이 방문자는 방문하는 곳의 데이터 구조(File, Directory)에 의존합니다.
 * visit(File)은 File 방문 시 File 클래스가 호출하는 메서드이고, Visit(Directory)는 Directory 방문 시 Directory 클래스가
 * 호출되는 메서드 입니다.
 */
public abstract class Visitor {
    public abstract void visit(File fIle);
    public abstract void visit(Directory directory);
}
