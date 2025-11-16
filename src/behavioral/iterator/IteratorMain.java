package behavioral.iterator;

import java.util.Iterator;

public class IteratorMain {
    public static void main(String[] args) {
        //책상 생성 및 책 추가
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Crime and Punishment"));
        bookShelf.appendBook(new Book("The Brothers Karamazov"));
        bookShelf.appendBook(new Book("Les Miserables"));
        bookShelf.appendBook(new Book("Madame Bovary"));


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

Crime and Punishment
The Brothers Karamazov
Les Miserables
Madame Bovary
*/