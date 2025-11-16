package behavioral.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {

    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public boolean hasNext() {
        if(index < bookShelf.getLength()) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Book next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        //book 변수를 저장한 후 index를 다음으로 진행후 book을 return -> for문의 i++
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
