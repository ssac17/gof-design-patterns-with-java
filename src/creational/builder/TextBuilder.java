package creational.builder;

/**
 * Builder 클래스의 하위 클래스입니다.
 * 일반 텍스트를 사용하여 문서를 구축합니다.
 */
public class TextBuilder extends Builder{

    private StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        sb.append("========================\n");
        sb.append("[");
        sb.append(title);
        sb.append("]\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("#");
        sb.append(str);
        sb.append("\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            sb.append(" -");
            sb.append(item);
            sb.append("\n");
        }
        sb.append("\n");
    }

    @Override
    public void close() {
        sb.append("========================\n");
    }

    public String getTextResult() {
        return sb.toString();
    }
}
