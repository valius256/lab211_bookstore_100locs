package model;

import bookstore.BException;
import bookstore.Status;
import bookstoreManagement.PublisherManagement;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.InputBookValidation;
import utils.Util;

/**
 *
 * @author hasu
 */
public class Book implements Comparable<Book> {

    public static final String ID_FORMAT = "Bxxxxx";
    private static final String ID_PATTERN = "B\\d{5}";

    private String id;
    private String name;
    private double price;
    private int quantity;
    private String publisherId;
    private String status;

    public Book() {
    }

    public Book(String id, String name, double price, int quantity, String publisherId, String status) throws BException {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setPublisherId(publisherId);
        this.setStatus(status);
    }

    public String getId() {
        return id;
    }

    public final void setId(String id) throws BException {
        if (!Util.validateStringPattern(id, Book.ID_PATTERN, true)) {
            throw new BException("Error: id ...");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) throws BException {
        if (name.length() >= 5 && name.length() <= 30) {
            this.name = name;
        } else {
            throw new BException("Error: name ...");
        }
    }

    public double getPrice() {
        return price;
    }

    public final void setPrice(double price) throws BException {

        if (price > 0) {
            this.price = price;
        } else {
            throw new BException("Error: price ...");
        }

    }

    public int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) throws BException {

        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new BException("Error: quantity ...");
        }

    }

    public String getPublisherId() {
        return publisherId;
    }

    public final void setPublisherId(String publisherId) throws BException {

        if (PublisherManagement.getInstance().getPublisherById(publisherId) != null) {
            this.publisherId = publisherId;
        } else {
            throw new BException("Error: publisherId ...");
        }

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) throws BException {

        if (status.equals(Status.NOT_Available.toString()) || status.equals(Status.Available.toString())) {
            this.status = status;
        } else {
            throw new BException("Error: status ...");
        }

    }

    public void input() {
        while (true) {
            try {
                setId(Util.inputString("Input id with patern (" + Book.ID_FORMAT + ")", false));
                break;
            } catch (BException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (true) {
            try {
                setName(Util.inputString("Enter name", false));
                break;
            } catch (BException ex) {
                System.out.println("Name has length from 5 to 30 characters");
            }
        }
        while (true) {
            try {
                setPrice(Util.inputDouble("Input price", 0));
                break;
            } catch (BException ex) {
                System.out.println("Price must greater than 0");
            }
        }

        while (true) {
            try {
                setQuantity(Util.inputInt("Input quantity", 0));
                break;
            } catch (BException ex) {
                System.out.println("Quantity must greater than 0");
            }
        }

        while (true) {
            try {
                setStatus(Util.inputString("Enter status (Available or Not AVailable)", true));
                break;
            } catch (BException e) {
                System.out.println("Status must be \"Available\" or \"Not AVailable\"");
            }
        }

        this.publisherId = Util.inputString("Input publisher's id", false);
        if (PublisherManagement.getInstance().getPublisherById(this.publisherId) == null) {
            System.out.println("Publisher not found, add one.");
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append(", publisherId=").append(publisherId);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Book o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Book getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Comparator compBook = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Book b1 = (Book) o1;
            Book b2 = (Book) o2;

            if (b1.getQuantity() > b2.getQuantity()) {
                return 1;
            } else if (b1.getQuantity() == b2.getQuantity()) {
                return 0;
            } else {
                return -1;
            }
        }

    };

    public void inputUpdate() throws BException {
        boolean cont = false;
        do {
            String newName = Util.inputString("Input new name: ", true);
            if (newName.equals("")) {
            } else {
                if (InputBookValidation.checkBookName(newName) == false) {
                    cont = true;
                }
                setName(newName);
            }
        } while (cont);
        
        
        do {
            String newPrice = Util.inputString("Input new price: ", true);
            if (newPrice.equals("")) {
                // don't change the data
            } else {
                // System.out.println(p.getpDuration() + "-->" + newDuration);
                if (InputBookValidation.checkBookPrice(Integer.parseInt(newPrice)) == false) {
                    cont = true;
                }
                setPrice(Double.parseDouble(newPrice));
            }
        } while (cont);

        do {
            String newQuantity = Util.inputString("Input new Quantity: ", true);
            if (newQuantity.equals("")) {
            } else {
                // System.out.println(p.getpQuantity() + "-->" + newQuantity);
                if (InputBookValidation.checkBookQuantity(Integer.parseInt(newQuantity)) == false) {
                    cont = true;
                    System.out.println("Invalid quantity");
                }
                setQuantity(Integer.parseInt(newQuantity));
            }
        } while (cont);

        do {
            String newPublisherID = Util.inputString("Input new PublisherID: ", true);
            if (newPublisherID.equals("")) {

            } else {
                if (InputBookValidation.checkPublisherId(newPublisherID) == false) {
                    cont = true;
                    System.out.println("Invalid publisherID");
                }
                setPublisherId(newPublisherID);
            }

        } while (cont);

        do {
            String newStatus = Util.inputString("Input new Status (Available or Not Available): ", true);
            if (newStatus.equals("")) {

            } else {
                if (InputBookValidation.checkBookStatus(newStatus) == false) {
                    cont = true;
                    System.out.println("invalid status");
                }
                setStatus(newStatus);
            }
        } while (cont);
        
        
    }
}
