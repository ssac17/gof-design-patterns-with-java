package behavioral.iterator;

import java.util.Iterator;

/**
 * 반복자 패턴
 * 무엇인가 많이 모여 있을 때 이를 순서대로 가리키며  전체를 검색하고 처리를 반복하는 것
 * iterate는 '반복하다', iterator는 '반복자'라고 한다.
 * */
public class IteratorMain {
    public static void main(String[] args) {
        //책상 생성 및 책 추가
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("Crime and Punishment"));
        bookShelf.appendBook(new Book("The Brothers Karamazov"));
        bookShelf.appendBook(new Book("Les Miserables"));
        bookShelf.appendBook(new Book("Madame Bovary"));
        bookShelf.appendBook(new Book("Madame Bovary"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));


        //명시적으로 Iterator 사용하는 방벙
        Iterator<Book> iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getName());
        }
        System.out.println();

        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
    }
}

/*
출력 결과
Crime and Punishment
The Brothers Karamazov
Les Miserables
Madame Bovary
Madame Bovary
Cinderella
Daddy-Long-Legs

Crime and Punishment
The Brothers Karamazov
Les Miserables
Madame Bovary
Madame Bovary
Cinderella
Daddy-Long-Legs
*/