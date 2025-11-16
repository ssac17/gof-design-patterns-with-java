package behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book>{

    private List<Book> books = new ArrayList<>();
    private int last = 0;



    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        this.books.add(book);
        last++;
    }

    public int getLength() {
        return last;
    }


    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
