package org.iesfm;

import org.iesfm.exceptions.BookNotFoundException;
import org.iesfm.exceptions.MemberNotFoundException;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Library {

    private String name;
    private List<Member> members;
    private List<Book> catalogue;
    private List<BookLend> bookLends;


    public List<Book> booksWithGenre(String genre) {
        List<Book> books = new LinkedList<>();
        for (Book book : catalogue) {
            if (book.getGenres().contains(genre)) {
                books.add(book);
            }
        }
        return books;
    }

    public List<Member> membersInZipCode(int zipCode) {
        List<Member> membersZipCode = new LinkedList<>();
        for (Member member : members) {
            if (member.getZipCode() == zipCode) {
                membersZipCode.add(member);
            }
        }
        return membersZipCode;
    }

    public List<BookLend> newBookLend(String nif, String isbn) throws BookNotFoundException, MemberNotFoundException {
        for (Member member : members) {
            if (member.getNif().equalsIgnoreCase(nif)) {
                for (Book book : catalogue) {
                    if (book.getIsbn().equalsIgnoreCase(isbn)) {
                        bookLends.add(new BookLend(isbn, nif, new Date()));
                        return bookLends;
                    }
                }
                throw new BookNotFoundException();
            }

        }
        throw new MemberNotFoundException();
    }

    public Book removeGenre(String genre, String isbn) throws BookNotFoundException {
        for (Book book : catalogue) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                book.getGenres().remove(genre);
                return book;
            }
        }
        throw new BookNotFoundException();
    }


    public Library(String name, List<Member> members, List<Book> books, List<BookLend> bookLends) {
        this.name = name;
        this.members = members;
        this.catalogue = books;
        this.bookLends = bookLends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Book> getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(List<Book> catalogue) {
        this.catalogue = catalogue;
    }

    public List<BookLend> getBookLends() {
        return bookLends;
    }

    public void setBookLends(List<BookLend> bookLends) {
        this.bookLends = bookLends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Objects.equals(members, library.members) && Objects.equals(catalogue, library.catalogue) && Objects.equals(bookLends, library.bookLends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, members, catalogue, bookLends);
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", members=" + members +
                ", books=" + catalogue +
                ", bookLends=" + bookLends +
                '}';
    }
}
