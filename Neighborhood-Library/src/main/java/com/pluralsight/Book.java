package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // getters
    public int getId() {
        return this.id;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public String getTitle(){
        return this.title;
    }
    public boolean getIsCheckedOut(){
        return this.isCheckedOut;
    }
    public String getCheckedOutTo(){
        return this.checkedOutTo;
    }

    // methods
    public void checkOut(String name){
        isCheckedOut = true;
        checkedOutTo = name;
    }

    public void checkIn() {
        isCheckedOut = false;
        checkedOutTo = "";
    }
}
