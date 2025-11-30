package structural.facade;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * DataBase 클래스는 데이터베이스 이름을 지정하여 대응하는 Properties를 생성하는 클래스입니다.
 * DataBase 클래스는 java.util.Properties 클래스를 간이 데이터베이스로 보고, 이메일 주소와 이름 세트를
 * 데이터 파일*(maildata.txt)로 관리합니다. DataBase 클래스는 Properties의 인스턴스를 만들지 않고,
 * getProperties라는 static 메서드를 통해 Properties의 인스턴스를 얻습니다.
 */
public class DataBase {
    private DataBase() {}

    //데이터베이스 이름에서 Properties를 얻는다
    public static Properties getProperties(String dbname) throws IOException {
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        prop.load(new FileReader(filename));
        return prop;
    }
}
