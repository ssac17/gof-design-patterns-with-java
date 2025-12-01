package structural.flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * BigChar 클래스는 큰 문자를 나타내는 클래스입니다. 생성자에서는 인수로 주어진 문자의 '큰 문자'버전을 생성합니다. 생성된 문자열은
 * fontdata 필드에 저장합니다. 예로 인수 3이 주어지면, 다음과 같은 문자열이 fontdata 필드에 저장됩니다.
 * ....######.....
 * ..##......##...
 * ..........##...
 * ........###....
 * ..........##...
 * ..##......##...
 * ....######.....
 * '큰 글자'를 구성하는 데이터는 파일로 준비되어 있습니다.
 */
public class BigChar {
    //문자의 이름
    private char charname;

    //큰 문자를 표현하는 문자열('#', '.', '\n'으로 이루어진 열)
    private String fontdata;

    //생성자
    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "data/big" + charname + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line : Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    //큰 문자를 표시
    public void print() {
        System.out.println(fontdata);
    }
}
