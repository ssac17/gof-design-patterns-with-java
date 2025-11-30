package structural.facade;

import java.io.IOException;
import java.io.Writer;

/**
 * HtmlWriter는 간단한 웹 페이지를 만드는 클래스입니다. 인스턴스 생성 시 Writer를 주고 그 writer에 HTML을 출력합니다.
 * 이 클래스에는 title 메서드를 가장 먼저 호출해야 하는 제약이 숨겨져 있습니다.
 * 그리고 창구가 되는 PageMaker 클래스는 그 제약을 지키도록 작성되어 있습니다.
 */
public class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    //타이틀 출력
    public void title(String title) throws IOException {
        writer.write("<!DOCTYPE html>");
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("\n");
        writer.write("<h1>" + title + "</h1>");
        writer.write("\n");
    }

    //단락 출력
    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>");
        writer.write("\n");
    }

    //링크 출력
    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + ">" + caption + "</a>");
    }

    //이메일 출력
    public void mailto(String mailaddr, String username) throws IOException {
        link("mailto: " + mailaddr, username);
    }

    //HTML 닫기
    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</thml>");
        writer.write("\n");
        writer.close();
    }
}
