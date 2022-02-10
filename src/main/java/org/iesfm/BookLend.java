package org.iesfm;

import java.util.Date;
import java.util.Objects;

public class BookLend {

    private String isbn;
    private String nifMember;
    private Date date;


//    String fecha= "11-10-2022";
//    SimpleDateFormat formato = new SimpleDateFormat("MM-dd-yyyy")
//    Date date= formato.parse(fecha);


    public BookLend(String isbn, String nifMember, Date date) {
        this.isbn = isbn;
        this.nifMember = nifMember;
        this.date = date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNifMember() {
        return nifMember;
    }

    public void setNifMember(String nifMember) {
        this.nifMember = nifMember;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLend bookLend = (BookLend) o;
        return Objects.equals(isbn, bookLend.isbn) && Objects.equals(nifMember, bookLend.nifMember) && Objects.equals(date, bookLend.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, nifMember, date);
    }

    @Override
    public String toString() {
        return "BookLend{" +
                "isbn='" + isbn + '\'' +
                ", nifMember='" + nifMember + '\'' +
                ", date=" + date +
                '}';
    }
}
