package com.pluralsight;

import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Book[] inventory = new Book[20];

        // Filling the Inventory with 20 books
        inventory[0] = new Book(1, "978-1-4215-1234-5", "One Piece, Volume 1");
        inventory[1] = new Book(2, "978-0-06-112008-4", "To Kill a Mockingbird");
        inventory[2] = new Book(3, "978-1-9747-1234-9", "DanDaDan, Volume 1");
        inventory[3] = new Book(4, "978-1-4215-2345-6", "Tokyo Ghoul, Volume 1");
        inventory[4] = new Book(5, "978-0-486-1234-0", "Frankenstein");
        inventory[5] = new Book(6, "978-0-7432-7356-5", "The Great Gatsby");
        inventory[6] = new Book(7, "978-0-06-447239-6", "Fade");
        inventory[7] = new Book(8, "978-0-06-144878-2", "Gone");
        inventory[8] = new Book(9, "978-0-525-47881-2", "The Fault in Our Stars");
        inventory[9] = new Book(10, "978-0-14-240251-1", "Looking for Alaska");
        inventory[10] = new Book(11, "978-0-439-02348-1", "The Hunger Games");
        inventory[11] = new Book(12, "978-1-2345-6789-0", "The Mortal Hero");
        inventory[12] = new Book(13, "978-0-14-026886-7", "Homer's The Odyssey");
        inventory[13] = new Book(14, "978-0-385-73440-7", "Perks of Being a Wallflower");
        inventory[14] = new Book(15, "978-1-4215-9876-5", "One Piece, Volume 108");
        inventory[15] = new Book(16, "978-0-14-027536-0", "Homer's The Iliad");
        inventory[16] = new Book(17, "978-0-14-243722-3", "The Divine Comedy");
        inventory[17] = new Book(18, "978-0-7434-7712-3", "Hamlet");
        inventory[18] = new Book(19, "978-0-7434-7711-6", "MacBeth");
        inventory[19] = new Book(20, "978-0-486-1234-6", "Beowulf");

        boolean running = true;

        while (running){
            // Menu with options
            System.out.println("\n Welcome to the Neighborhood Library! ");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            // Getting User Input
            String choice = keyboard.nextLine();

            // If/Else Statements for option input and failure to comply
            if (choice.equals("1")) {
                showAvailableBooks(keyboard, inventory);
            } else if (choice.equals("2")) {
                showCheckedOutBooks(keyboard, inventory);
            } else if (choice.equals("3")) {
                running = false;
                System.out.println("Thank you for using the app!");
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
    private static void showAvailableBooks(Scanner keyboard, Book[] inventory){
        System.out.println("\n Available Books: ");
        boolean bookAvailable = false;

        for (Book book : inventory ){
            if (!book.getIsCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s ", book.getId(), book.getIsbn(), book.getTitle());
                bookAvailable = true;
            }
        }

        if (!bookAvailable) {
            System.out.println("No books are currently available to check out");
            return;
        }

        System.out.println("\nPlease enter the ID of the book to check it out or 'X' to return to home screen: ");
        String input = keyboard.nextLine();

        if (input.equalsIgnoreCase("X")){
            return;
        }

        int bookId = Integer.parseInt(input);
        Book bookToCheckOut = findBookById(inventory, bookId);

        if (bookToCheckOut != null && !bookToCheckOut.getIsCheckedOut()){
            System.out.println("Please enter your name to check out this book: ");
            String name = keyboard.nextLine();
            bookToCheckOut.checkOut(name);
            System.out.println("Book is now checked out to " + name);
        }else {
            System.out.println("Invalid ID or the book has already been checked out, sorry.");
        }
    }
    private static void showCheckedOutBooks(Scanner keyboard, Book[] inventory) {
        System.out.println("\n Checked Out Books: ");
        boolean bookCheckedOut = false;

        for(Book book : inventory){
            if (book.getIsCheckedOut()){
                System.out.printf("ID: %d | ISBN: %s | Title: %s | Checked Out to %s%n", book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
                bookCheckedOut = true;
            }
        }

        if (!bookCheckedOut){
            System.out.println("No books are currently checked out.");
            return;
        }

        System.out.println("Enter 'C' to check in a book or 'X' to return to home screen.");
        String input = keyboard.nextLine();

        if (input.equalsIgnoreCase("X")){
            return;
        } else if (input.equalsIgnoreCase("C")) {
            System.out.println("Enter the ID of the book to check in: ");
            String idInput = keyboard.nextLine();
            int bookId = Integer.parseInt(idInput);
            Book bookToCheckIn = findBookById(inventory, bookId);

            if(bookToCheckIn != null && bookToCheckIn.getIsCheckedOut()){
                bookToCheckIn.checkIn();
                System.out.println("Book successfully checked in.");
            } else {
                System.out.println("Invalid ID or the book is not checked out.");
            }
        } else {
            System.out.println("Invalid input.");
        }
    }
    private static Book findBookById(Book[] inventory, int id) {
        for (Book book : inventory) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
