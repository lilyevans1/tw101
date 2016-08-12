package Biblioteca;

public class Biblioteca {

    private BookList availableBookList;
    private BookList checkedOutBookList;

    public Biblioteca(BookList availableBookList, BookList checkedOutBookList){

        this.availableBookList = availableBookList;
        this.checkedOutBookList = checkedOutBookList;
    }

    public void printAvailableBooks() {
        availableBookList.printBookList();
    }

    public void printCheckedOutBooks() {
        checkedOutBookList.printBookList();
    }

    public void checkOutBook(String title) {
        if(availableBookList.containsBook(title)){
            Book bookToCheckOut = availableBookList.removeBook(title);
            checkedOutBookList.addBook(bookToCheckOut);
        }
    }
}
