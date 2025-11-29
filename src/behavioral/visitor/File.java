package behavioral.visitor;

/**
 * File 클래스도 Composite 패턴의 예제와 거의 동일합니다. Visitor 패턴에서의 핵심은 accept 메서드를 어떻게 구현할까 입니다.
 * accept 메서드의 인수는 Visitor 클래스입니다. 그리고 accept 메서드 안에서 v.visit(this); 문으로 Visito의 visit 메서드를 호출합니다.
 * visit 메서드는 오버로드되어 있는데, 여기서 호출되는 것은 visit(File)입니다.
 */
public class File extends Entry{
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
