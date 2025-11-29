package structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Directory 클래스는 디렉토리를 표현합니다. 이 클래스도 마찬가지로 Entry 클래스의 하위 클래스로 선언되어 있습니다.
 * printList 메서드는 디렉토리 목록을 표시합니다. printList 메서드도 getSize 메서드처럼 printList를 재귀적으로 호출합니다.
 * 이때, entry가 File의 인스턴스인지 Directory의 인스턴스인지 조사하지 않는 것도 getSize 메서드의 경우과 같습니다.
 * 그릇과 내용물을 동일시하기 때문입니다.
 */
public class Directory extends Entry{
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directory) {
            entry.printList(prefix  + "/" + name);
        }
    }

    //디렉토리 엔트리를 디렉토리에 추가
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
