package creational.abstract_factory.factory;

/**
 * getFactory 안에서는 Class 클래스의 forName 메서드를 사용하여 해당 클래스를 동적으로 가져옵니다.
 * 그리고 getDeclaredConstructor 메서드로 생성자를 얻고 newInstance 메서드로 인스턴스를 만들어 getFactory의 반환값입니다.
 * 여기서는 클래스나 생성자와 같은 프로그램의 구성 요소를 (컴파일러가 다루지 않고) 프로그램 자신이 다루고 있습니다.
 * 이러한 처리를 리플렉션(reflection)이라고 합니다.
 * 반환타입이 추상, Factory임을 주의!
 */
public abstract class Factory {
    public  static Factory getFactory(String classname) {
        Factory factory = null;

        try{
            factory = (Factory) Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println(classname + " 클래스가 발견되지 않았습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
