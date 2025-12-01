package behavioral.memento;

import behavioral.memento.game.Gamer;
import behavioral.memento.game.Memento;

public class MementoMain {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100); //최초 소지금 100
        Memento memento = gamer.createMemento(); //최초의 상태를 저장

        //게임 시작
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i); //횟수 표시
            System.out.println("상태: " + gamer); //현재 주인공 상태

            //게임을 진행
            gamer.bet();
            System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");

            //Memento 취급 방법 결정
            if(gamer.getMoney() > memento.getMoney()) {
                System.out.println("* 많이 늘었으니 현재 상태를 저장하자!");
                memento = gamer.createMemento();
            }else if(gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("* 많이 줄었으니 이전 상태를 복원하자!");
                gamer.restoreMemento(memento);
            }

            //잠시 대기
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println();
        }
    }
}
/*
실행 결과

.. 생략

==== 23
상태: [money = 250, fruits = [바나나, 바나나, 바나나, 맛있는 포도]]
소지금이 증가!
소지금은 350원이 되었습니다.
* 많이 늘었으니 현재 상태를 저장하자!

==== 24
상태: [money = 350, fruits = [바나나, 바나나, 바나나, 맛있는 포도]]
소지금이 절반으로 줄었습니다..
소지금은 175원이 되었습니다.

==== 25
상태: [money = 175, fruits = [바나나, 바나나, 바나나, 맛있는 포도]]
변동 사항이 없습니다.
소지금은 175원이 되었습니다.

==== 26
상태: [money = 175, fruits = [바나나, 바나나, 바나나, 맛있는 포도]]
변동 사항이 없습니다.
소지금은 175원이 되었습니다.

==== 27
상태: [money = 175, fruits = [바나나, 바나나, 바나나, 맛있는 포도]]
소지금이 절반으로 줄었습니다..
소지금은 87원이 되었습니다.
* 많이 줄었으니 이전 상태를 복원하자!

==== 28
상태: [money = 350, fruits = [맛있는 포도]]
변동 사항이 없습니다.
소지금은 350원이 되었습니다.

.. 생략
 */