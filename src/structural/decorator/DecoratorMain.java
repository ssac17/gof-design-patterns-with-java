package structural.decorator;

public class DecoratorMain {
    static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world!");
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();

        SideBorder b4 = new SideBorder(
                new FullBorder(
                        new SideBorder(
                                new FullBorder(
                                        new StringDisplay("Hello, world.")
                                ),
                                '*'
                        )
                ),
                '/'
        );
        b4.show();
    }
}
/*
출력 결과
Hello, world!
#Hello, world!#
+---------------+
|#Hello, world!#|
+-----------------+
/+-----------------+/
/|*+-------------+*|/
/|*|Hello, world.|*|/
/|*+---------------+*|/
/+-------------------+/
 */