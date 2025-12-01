package behavioral.state;

public class StateMain {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour); //시간 설정
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
