package behavioral.visitor;

/**
 * ListVisitor 클래스는 클래스의 하위 클래스로, 데이터 구조를 돌아다니면서 목록을 표시합니다.
 * Visitor 클래스의 하위 클래스이믈 visit(File) 메서드와 visit(Directory) 메서드를 구현합니다.
 *
 */
public class ListVisitor extends Visitor{
    //현재 주목하는 디렉토리 이름
    private String currentDir = "";

    //File 방문시
    @Override
    public void visit(File fIle) {
        System.out.println(currentDir + "/" + fIle);
    }

    //Directory 방문시
    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        for (Entry entry : directory) {
            entry.accept(this);
        }
        currentDir = saveDir;
    }
}
