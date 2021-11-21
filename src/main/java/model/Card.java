package model;

import java.sql.Date;

public class Card {
    private int id;
    private Book book;
    private Student student;
    private boolean status = true;
    private Date borrow_day;
    private Date back_day;

    public Card() {
    }

    public Card(int id, Book book, Student student, Date borrow_day, Date back_day) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.borrow_day = borrow_day;
        this.back_day = back_day;
    }

    public Card(Book book, Student student, Date borrow_day, Date back_day) {
        this.book = book;
        this.student = student;
        this.borrow_day = borrow_day;
        this.back_day = back_day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBorrow_day() {
        return borrow_day;
    }

    public void setBorrow_day(Date borrow_day) {
        this.borrow_day = borrow_day;
    }

    public Date getBack_day() {
        return back_day;
    }

    public void setBack_day(Date back_day) {
        this.back_day = back_day;
    }
}
