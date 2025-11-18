package creational.singleton;

public class SingletonMain {
    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if(obj1 == obj2) {
            System.out.println(obj1 + "와 " + obj2 +"은 같은 인스턴스 입니다.");
        }else {
            System.out.println(obj1 + "와 " + obj2 +"은 다른 인스턴스 입니다.");
        }
        System.out.println("End.");
    }
}
/*
출력 결과
Start.
인스턴스를 생성했습니다.
creational.singleton.Singleton@30f39991와 creational.singleton.Singleton@30f39991은 같은 인스턴스 입니다.
End.
 */
