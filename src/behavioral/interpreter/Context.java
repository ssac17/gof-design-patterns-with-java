package behavioral.interpreter;

/**
 * Context 클래스는 구문 해석을 위해 필요한 메서드를 제공합니다.
 * nextToken: 다음 토큰을 얻는다(다음 토큰으로 진행)
 * currentToken: 현재 토큰을 얻는다(다음 토큰으로 진행하지 않음)
 * skipToken: 현재 토큰을 체크하고 나서, 다음 토큰을 얻는다(다음 토큰으로 진행)
 * currentNumber: 현재 토큰을 수치로 얻는다(다음 토큰으로 진행하지 않음)
 * Context 클래스에서는 주어진 문자열로부터 '공백 문자가 한개 이상 연속된 것'을 구분하여 토큰 배열을 작성합니다.
 * 사용되고 있는 split 메서드는 인수로 건네받은 정규 표현과 일치하는 문자열을 단락으로 분할해 결과를 배열에 변환합니다.
 * '공백 문자가 한개 이상 연속된 것'을 의미하는 정규 표현은 \s+로, text.split("\\s+")로 원하는 배열에 변환합니다.
 * 예를 들어 text가 "program go end"인 경우 split의 결과는 "program", "go", "end" 세개의 문자열로 구성된 배열입니다.
 */
public class Context {
    private String[] tokens;
    private String lastToken;
    private int index;

    public Context(String text) {
        this.tokens = text.split("\\s+");
        this.index = 0;
        nextToken();
    }

    public String nextToken() {
        if(index < tokens.length) {
            lastToken = tokens[index++];
        }else {
            lastToken = null;
        }
        return lastToken;
    }

    public String currentToken() {
        return lastToken;
    }

    public void skipToken(String token) throws ParseException {
        if(currentToken() == null) {
            throw new ParseException("Error: " + token + " is expected, but no more token is found.");
        }else if(!token.equals(currentToken())) {
            throw new ParseException("Error: " + token + " is expected, but " + currentToken() + " is found.");
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        if(currentToken() == null) {
            throw new ParseException("Error: No more token.");
        }
        int number = 0;
        try {
            number = Integer.parseInt(currentToken());
        }catch (NumberFormatException e) {
            throw new ParseException("Error: " + e);
        }
        return number;
    }
}
