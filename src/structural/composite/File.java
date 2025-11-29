package structural.composite;

/**
 * File 클래스는 파일을 표현하는 클래스로, Entry 클래스의 하위 클래스로 선언되어 있습니다.
 * 상위 클래스인 Entry 클래스에서 선언된 추상 메서드 모두 여기서 구현했으므로 File 클래스는 추상 클래스가 아닙니다.
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
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
