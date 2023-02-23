package bookstore;

/**
 * Menu item.
 *
 * @author hasu
 */
public enum MenuItem {
    BACK("Back"),
    EXIT("Exit"),
    BOOK("Book"),
    BOOK_ADD("Add"),
    BOOK_UPDATE("Update"),
    BOOK_DELETE("Delete"),
    BOOK_FILTER_BY_ID("Filter by id"),
    BOOK_FILTER_BY_NAME("Filter by name"),
    BOOK_FILTER_BY_PHULISHER_ID("Filter by publisher's id"),
    BOOK_SAVE_TO_FILE("Save the Book list to file"),
    Book_PRINT_FROM_FILE("Print the Book list from the file."),
    Book_Search("Search the book"),
    //...

    PUBLISHER("Publisher"),
    PUBLISHER_ADD("Add"),
    PUBLISHER_UPDATE("Update"),
    PUBLISHER_DELETE("Delete"),
    PUBLISHER_FILTER_BY_ID("Filter by id"), //...
    PUBLISHER_SAVE_TO_FILE("Save the Publishers list to file"),
    PUBLISHER_PRINT_FROM_FILE("Print the Publisher list from the file."),
    ;

    private final String label;

    public String getLabel() {
        return label;
    }

    private MenuItem(String label) {
        this.label = label;
    }

}
