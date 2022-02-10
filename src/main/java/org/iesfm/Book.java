package org.iesfm;

import java.util.HashSet;
import java.util.Objects;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private HashSet<String> genres;



    public Book(String isbn, String title, String author, HashSet<String> genres) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genres = genres;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public HashSet<String> getGenres() {
        return genres;
    }

    public void setGenres(HashSet<String> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genres, book.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, genres);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genres=" + genres +
                '}';
    }
}
