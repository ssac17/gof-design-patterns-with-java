package structural.composite;

/**
 * Entry 클래스는 추상 클래스이고 디렉토리 엔트리를 표현합니다. 이 하위 클래스로 File, Directory 클래스가 만들어짐니다.
 */
public abstract class Entry {
    //이름을 얻음
    public abstract String getName();

    //크기를 얻음
    public abstract int getSize();

    //목록을 표시
    public void printList() {
        printList("");
    }

    //prefix를 앞에 붙여 목록을 표시
    protected abstract void printList(String prefix);

    //문자열 표시

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
