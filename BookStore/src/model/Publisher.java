package model;

import bookstore.BException;
import bookstoreManagement.PublisherManagement;

import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Util;

/**
 *
 * @author hasu
 */
public class Publisher implements Comparable<Publisher> {

    public static final String ID_FORMAT = "Pxxxxx";
    private static final String ID_PATTERN = "P\\d{5}";

    private String id;
    private String name;
    private String phone;

    public Publisher() {
    }

    public Publisher(String id, String name, String phone) throws BException {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
    }

    public String getId() {
        return id;
    }

    public final void setId(String id) throws BException {
        if (validateID(id, false)) {
            this.id = id.toUpperCase();
        }
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name.length() >= 5 && name.length() <= 30) {
            this.name = name;
        }
    }

    public String getPhone() {
        return phone;
    }

    public final void setPhone(String phone) {
        if (phone.length() >= 10 && phone.length() <= 12) {
            this.phone = phone;
        }
    }

    public void input() {
        System.out.println("Publisher --> add ...");
        while (true) {
            try {
                setId(Util.inputString("Input id with patern (" + Publisher.ID_FORMAT + ")", false));
                break;
            } catch (BException ex) {
                Logger.getLogger(Publisher.ID_FORMAT).log(Level.SEVERE, null, ex);
            }
        }

        while (true) {
            setName(Util.inputString("Enter name", false));
            break;
        }
        while (true) {
            setPhone(Util.inputString("Input Phone", false));
            break;
        }

    }

    private String inputId() throws BException {
        String Id;
        do {
            Id = Util.inputString("Please enter the id with the pattern(" + Publisher.ID_FORMAT + ")", true);

        } while (!validateID(Id, true));
        return Id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Publisher{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Publisher o) {
        if (o != null) {
            return this.id.compareTo(o.id);
        }
        return 1;
    }

    public String toSaveString() {
        return id + Util.SEP + name + Util.SEP + phone;
    }

    private boolean validateID(String id, boolean checkExists) {
        return Util.validateString(id, Publisher.ID_PATTERN, true)
                && (!checkExists || PublisherManagement.getInstance().getPublisherById(id) == null);
    }

    public Publisher getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
