package by.itac.mylibrary.entity;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

    private String author;
    private String title;
    private String year;
    private int id;

    public Book(){

    }

    public Book(String author, String title, String year){

        this.author = author;
        this.title = title;
        this.year = year;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()){
            return false;
    }
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(title, book.title) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, year);
    }

    @Override
    public String toString() {
        return  "__ __[" + author + "]__ __" + "{" + title + "}" + "__ __- " +year;
    }
}
