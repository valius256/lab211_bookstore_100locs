package bookstoreManagement;

import model.Book;
import bookstore.BException;
import static model.Book.compBook;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.Util;


/**
 *
 * @author hasu
 */
public class BookManagement {

    private static BookManagement instance = new BookManagement();

    public static BookManagement getInstance() {
        return instance;
    }

    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    private BookManagement() {
        this.bookList = new ArrayList();
    }

    public Book addBook() throws BException {
        Book b = new Book();
        b.input();
        
        if(checkDuplicate(b.getId()) == false){
            if(this.bookList.add(b)){
                return b;
            }
        }
        
        System.out.println("dupplicated");
        bookList.add(b);
        return null;
    }

    // public List<Book> search(Predicate<Book> condition) {
    // List<Book> ret = new ArrayList<>();
    // for (int i = 0; i < bookList.size(); i++) {
    // if (condition.test(bookList.get(i))) {
    // ret.add(bookList.get(i));
    // }
    // }
    // return ret;
    // }
    public Book searchID(String ID) {
        for (Book i : bookList) {
            if (ID.equals(i.getId())) {
                return i;
            }
        }
        return null;
    }

    // public void searchByName() {
    // String name = Util.inputString("Enter name to search: ", true);
    // int count = 0;
    // for (Book book : bookList) {
    // if(book.getName().equals(name)){
    // System.out.println(book.toString());
    // count++;
    // }
    // }
    // }
    //
    // public void searchByID() {
    // String ID = Util.inputString("Enter ID to search: ", true);
    // List<Book> found = search(i -> {
    // return i.getId().equals(ID);
    // });
    // if (found != null && !found.isEmpty()) {
    // System.out.println(found.get(0).toString());
    // } else {
    // System.out.println("NONE FOUND");
    // }
    // }
    public void searchByName() {
        int choice;
        System.out.println("Choose to find by ");
        System.out.println("1. Find by Name");
        System.out.println("2.Find by ID");
        choice = Util.inputInt("Enter your choice: ");

        if (choice == 1) {
            String fName;

            fName = Util.inputString("Enter the name to find: ", true);
            int count = 0;

            for (Book book : bookList) {
                if (book.getName().contains(fName) || book.getName().toLowerCase().contains(fName)) {
                    System.out.println(book);
                    count++;
                }
            }

            if (count == 0) {
                System.out.println("Have no any Book");
            }
        } else if (choice == 2) {
            String fID;

            fID = Util.inputString("Enter the id to find: ", true);
            int count = 0;

            for (Book book : bookList) {
                if (book.getPublisherId().contains(fID) || book.getName().toLowerCase().contains(fID)) {
                    System.out.println(book);
                    count++;
                }
            }

            if (count == 0) {
                System.out.println("Have no any Book");
            }
        }
    }

    public void update() throws BException {
        String ID = Util.inputString("Input ID of Book to update: ", true);

        if (!checkDuplicate(ID)) {
            System.out.println("Book’s Name does not exist");
        }

        for (int i = 0; i < bookList.size(); i++) {
            Book p = bookList.get(i);
            if (p.getId().equals(ID)) {
                p.inputUpdate();
            }
        }
        
        int choice;
            do {
                System.out.println("Main Menu");
                System.out.println("1. Update new Book");
                System.out.println("2. Go back");
                System.out.print("Enter your choice: ");
                choice = Util.inputInt("Enter your choice: ");

                switch (choice) {
                    case 1:
                        update();
                        break;
                    case 2:
                        System.out.println("Going back to main menu");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 2);
    }

    public void saveToFile() {
        if (bookList.isEmpty()) {
            System.out.println("Empty.Nothing to write");
            return;
        }

        try {
            File f = new File("book.txt");
            if (!f.exists()) {
                return;
            }

            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            for (Book book : bookList) {
                pw.println(book.getId().trim() + "|   |" + book.getName().trim() + "|   |" + book.getPrice() + "|   |"
                        + book.getQuantity() + book.getPublisherId().trim() + "|   |" + book.getStatus().trim());
            }

            fw.close();
            pw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Success");
    }

    public void printFromFile() {
        try {
            File f = new File("book.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                List<Book> sorted = bookList;
                Collections.sort(sorted, (Book p1, Book p2) -> {
                    int temp;
                    if ((temp = Integer.valueOf(p2.getQuantity()).compareTo(p1.getQuantity())) != 0) {
                        return temp;
                    } else {
                        return Double.valueOf(p1.getPrice()).compareTo(p2.getPrice());
                    }
                });
//                sorted.forEach(item -> {
//                    System.out.println(item.toString());
//                });

                String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n"; // doi cai nay
                // thanh 30 roi
                // de 30 gach o
                // duoi
                System.out.format(
                        "+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------%n");
                System.out.format(
                        "|        ID       +    Name         +        Price    +     Quantity    +    Subtotal     + Publisher's Name+    Status      +%n");
                System.out.format(
                        "+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------%n");

                // System.out.format("id\t" + "Name\t\t" + "Price\t" + "Quantity\t" +
                // "Subtotal\t" + "Publisher's Name\t" + "Status\t");
                for (Book book : sorted) {
                    System.out.format(leftAlignFormat, book.getId(),
                            book.getName(),
                            book.getPrice(),
                            book.getQuantity(),
                            (book.getPrice() * book.getQuantity()),
                            PublisherManagement.getInstance().getPublisherById(book.getPublisherId()).getName(),
                            book.getStatus());

                }
                System.out.format(
                        "+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------%n");
                line = br.readLine();
            }

            fr.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // public void print() {
    // if (bookList.isEmpty()) {
    // System.out.println("EMPTY.");
    // } else {
    // List<Book> sorted = bookList;
    // Collections.sort(sorted, (Book p1, Book p2) -> {
    // int temp;
    // if ((temp = Integer.valueOf(p2.getQuantity()).compareTo(p1.getQuantity())) !=
    // 0) {
    // return temp;
    // } else {
    // return Double.valueOf(p1.getPrice()).compareTo(p2.getPrice());
    // }
    // });
    // sorted.forEach(item -> {
    // System.out.println(item.toString());
    // });
    //
    // String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |
    // %-15s |%n"; // doi cai nay thanh 30 roi de 30 gach o duoi
    // System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------%n");
    // System.out.format("| ID + Name + Price + Quantity + Subtotal + Publisher's
    // Name+ Status +%n");
    // System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------%n");
    //
    //// System.out.format("id\t" + "Name\t\t" + "Price\t" + "Quantity\t" +
    // "Subtotal\t" + "Publisher's Name\t" + "Status\t");
    // for (Book book : sorted) {
    // System.out.format(leftAlignFormat, book.getId(),
    // book.getName(),
    // book.getPrice(),
    // book.getQuantity(),
    // (book.getPrice() * book.getQuantity()),
    // PublisherManagement.getInstance().getPublisherById(book.getPublisherId()).getName(),
    // book.getStatus());
    //
    // }
    // System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------%n");
    //
    // }
    // }
    public void delete() {
        String ID = Util.inputString("Input ID publisher: ", true);
        for (Book book : bookList) {
            if (book.getId().equals(ID)) {
                bookList.remove(book);
                System.out.println("Success");
                return;
            } else {
                System.out.println("Failed");
            }
        }
        System.out.println("Publisher’s ID does not exist");
    }

    private boolean checkDuplicate(String Id) {
        for (Book book : bookList) {
            if (book.getId().equals(Id)) {
                return true;
            }
        }
        return false;
    }

//    public List<Book> filterByPublisherId(String publisherId) {
//        if (publisherId != null && !publisherId.isBlank()) {
//            return this.bookList.stream().filter(pub -> publisherId.equalsIgnoreCase(pub.getId())).sorted().toList();
//
//            // List<Book> resultList = new ArrayList();
//            // for (Book book : bookList) {
//            // if (publisherId.equalsIgnoreCase(book.getPublisherId())) {
//            // resultList.addNew(book);
//            // }
//            // }
//            // return resultList;
//        }
//        return null;
//    }
}
