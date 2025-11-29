package creational.builder;

/**
 * Main 클래스는 Builder 클래스의 메소드를 모릅니다.(호출하지 않습니다)
 * Main 클래스는 Director 클래스의 construct 메서드만 호출합니다. 그러면 Director 클래스 안에서 조용히 일이 진행되고
 * (그것을 Main 클래스는 신경 쓰지 않고) 문서가 완성됩니다.
 */
public class BuilderMain {
    public static void main(String[] args) {
        if(args.length != 1) {
            usage();
            System.exit(0);
        }
        if(args[0].equals("text")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getTextResult();
            System.out.println(result);
        }else if(args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String filename = htmlBuilder.getHTMLResult();
            System.out.println("HTML파일 " + filename + "이 작성되었습니다.");
        }else {
            usage();
            System.exit(0);
        }
    }

    public static void usage() {
        System.out.println("Usage: java BuilderMain.java text   텍스트로 문서 작성");
        System.out.println("Usage: java BuilderMain.java html   HTML로 문서 작성");
    }
}
