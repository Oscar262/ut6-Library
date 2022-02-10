package org.iesfm;

import org.iesfm.exceptions.BookNotFoundException;
import org.iesfm.exceptions.MemberNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LibraryTest {

    @Test
    public void findNovelasTest() {
        Library library = library();
        List<Book> novelas = library.booksWithGenre("Novela");
        Assert.assertEquals(1, novelas.size());
        Assert.assertEquals("Libro1", novelas.get(0).getTitle());
    }

    @Test
    public void findFantasiaTest() {
        Library library = library();
        List<Book> novelas = library.booksWithGenre("Fantasia");
        Assert.assertEquals(0, novelas.size());
    }

    @Test
    public void findMemberZipCode2Test() {
        Library library = library();
        List<Member> members = library.membersInZipCode(2);
        Assert.assertEquals(1, members.size());
        Assert.assertEquals(2, members.get(0).getZipCode());
    }

    @Test
    public void findMemberZipCode1Test() {
        Library library = library();
        List<Member> members = library.membersInZipCode(1);
        Assert.assertEquals(0,members.size());
    }

    @Test
    public void createBookLendTest() throws BookNotFoundException, MemberNotFoundException {
        Library library = library();
        List<BookLend> bookLends = library.newBookLend("10", "20");
        Assert.assertEquals(3, bookLends.size());
    }

    @Test(expected = BookNotFoundException.class)
    public void createBookLendBookNotFoundTest() throws BookNotFoundException, MemberNotFoundException {
        Library library = library();
        List<BookLend> bookLends = library.newBookLend("10", "200");
    }

    @Test(expected = MemberNotFoundException.class)
    public void createBookLendMemberNotFoundTest() throws BookNotFoundException, MemberNotFoundException {
        Library library = library();
        List<BookLend> bookLends = library.newBookLend("100", "20");
    }

    @Test
    public void removeNovelaTest() throws BookNotFoundException {
        Library library = library();
        Book book = library.removeGenre("Novela", "1");
        Assert.assertEquals(1, book.getGenres().size());
        Assert.assertTrue(book.getGenres().contains("Ciencia ficcion"));
    }

    @Test(expected = BookNotFoundException.class)
    public void removeNovelaBookNotFoundTest() throws BookNotFoundException {
        Library library = library();
        Book book = library.removeGenre("Novela", "100");
    }

    @Test()
    public void removeNovelaGenreNotFoundTest() throws BookNotFoundException {
        Library library = library();
        Book book = library.removeGenre("Novela", "20");
        Assert.assertEquals(1, book.getGenres().size());
    }


    public Library library() {
        HashSet<String> genres1 = new HashSet<>();
        genres1.add("Novela");
        genres1.add("Ciencia ficcion");

        HashSet<String> genres2 = new HashSet<>();
        genres2.add("Ciencia ficcion");

        List<Member> members = new LinkedList<>();
        members.add(new Member("10", "Juan", "garcia", 1, 2));
        members.add(new Member("20", "Jose", "gomez", 2, 3));

        List<Book> books = new LinkedList<>();
        books.add(new Book("1", "Libro1", "Autor1", genres1));
        books.add(new Book("20", "Libro2", "Autor2", genres2));


        List<BookLend> bookLends = new LinkedList<>();
        bookLends.add(new BookLend("1", "10", new Date()));
        bookLends.add(new BookLend("1", "20", new Date()));

        return new Library("Biblioteca", members, books, bookLends);
    }
}
