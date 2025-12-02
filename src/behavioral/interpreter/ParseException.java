package behavioral.interpreter;

/**
 * ParseException 클래스는 구문 해석 중 예외 처리를 위한 클래스입니다.
 */
public class ParseException extends RuntimeException {
    public ParseException(String msg){
        super(msg);
    }
}

