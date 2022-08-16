package com.nie.pojo;

public class Books{
    private int bookId;
    private String bookName;
    private String authors;
    private String date;
    private String publisher;

    public Books() {
    }

    public Books(int bookId, String bookName, String authors, String date, String publisher) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authors = authors;
        this.date = date;
        this.publisher = publisher;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "books{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authors='" + authors + '\'' +
                ", date='" + date + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
