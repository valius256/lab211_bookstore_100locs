package bookstore;

import model.Book;
import model.Publisher;
import bookstoreManagement.PublisherManagement;
import bookstoreManagement.BookManagement;


public class BookStore {

    private PublisherManagement publisherManagement;
    private BookManagement bookManagement;
   
    
    public BookStore() {
        this.publisherManagement = PublisherManagement.getInstance();
        this.bookManagement = BookManagement.getInstance();
    }
    

    private void addNewBook() throws BException {
        Book book = this.bookManagement.addBook();
        if (this.publisherManagement.getPublisherById(book.getPublisherId()) == null) {
            System.out.println("Publishers [" + book.getPublisherId() + "] don't exist. Please enter another or add a new one.");
            Publisher publisher = this.publisherManagement.addNew();
            if (!book.getPublisherId().equalsIgnoreCase(publisher.getId())) {
                book.setPublisherId(publisher.getId());
                this.bookManagement.update();
                System.out.println("p" + publisher.getName());
            }
        }
    }

    private void updateBook() throws BException {
        System.out.println("updateBook");
        bookManagement.update();
    }

    private void deleteBook() {
        System.out.println("deleteBook");
        bookManagement.delete();
    }

    private void search() {
        System.out.println("filterBookById");
        bookManagement.searchByName();
    }

     private void filterBookByName() {
     System.out.println("filterBookByName");
     bookManagement.searchByName();
     }

    private void saveToFileBook() {
        System.out.println("saveToFile");
        bookManagement.saveToFile();
    }

    private void printFromFile() {
        System.out.println("printFromFile");
        bookManagement.printFromFile();
    }

//    private void filterBookByPublisherId() {
//        String pubId = Util.inputString("Input publisher's id", false);
//        List<Book> resultList = this.bookManagement.filterByPublisherId(pubId);
//        if (resultList == null || resultList.isEmpty()) {
//            System.out.println("Khong tim thay");
//        } else {
//            for (Book book : resultList) {
//                System.out.println(book);
//            }
//        }
//    }

    private void addNewPublisher() throws BException {
        System.out.println("addNewPublisher");
        publisherManagement.addNew();
    }

    private void deletePublisher() {
        System.out.println("deletePublisher");
        publisherManagement.delete();
    }

    private void saveToFile() {
        publisherManagement.SaveToFile();
    }

    private void printDataFromText() {
        System.out.println("filterPublisherById");
        publisherManagement.printDataFromFile();
    }

    private void process() throws BException, Exception {
        Menu menu = new Menu();
        int option = Integer.MAX_VALUE;
        MenuItem userChoice;
        do {
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case BOOK_ADD:
                    addNewBook();
                    break;
                case BOOK_UPDATE:
                    updateBook();
                    break;
                case BOOK_DELETE:
                    deleteBook();
                    break;
                case Book_Search:
                    search();
                    break;
                case BOOK_FILTER_BY_PHULISHER_ID:
                    filterBookByName();
                    break;
                case BOOK_SAVE_TO_FILE:
                    saveToFileBook();
                    break;
                case Book_PRINT_FROM_FILE:
                    printFromFile();
                    break;

                case PUBLISHER_ADD:
                    addNewPublisher();
                    break;
                case PUBLISHER_DELETE:
                    deletePublisher();
                    break;
                case PUBLISHER_SAVE_TO_FILE:
                    saveToFile();
                    break;
                case PUBLISHER_PRINT_FROM_FILE:
                    printDataFromText();

                case EXIT:
                    System.out.println("Exited!");
                    break;

                default:
                    System.out.println("???");
            }
        } while (userChoice != MenuItem.EXIT);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BException, Exception {
        new BookStore().process();
    }

}
