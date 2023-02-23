package examinationmanagement.model;

import examinationmanagement.list.IObject;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import examinationmanagement.util.Util;

/**
 * Class department
 *
 * @author hasu
 */
public class Department implements IObject {

    public static final String ID_FORMAT = "DEPxxxxx";
    private static final String ID_PATTERN = "DEP\\d{5}";
    private static final int ATTRIBUTE_COUNT = 4;

    private String id;
    private String name;
    private Date createDate;
    private Date lastUpdateDate;

    public String getId() {
        return id;
    }

    public final void setId(String id) {
        if (validateId(id, false)) {
            this.id = id.toUpperCase();
        }
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        }
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public final void setCreateDate(Date createDate) {
        if (Util.validateDate(createDate, this.lastUpdateDate)) {
            this.createDate = createDate;
        }
    }

    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public final void setLastUpdateDate(Date lastUpdateDate) {
        if (Util.validateDate(this.createDate, lastUpdateDate)) {
            this.lastUpdateDate = lastUpdateDate;
        }
    }

    public Department() {
    }

    public Department(String id, String name, Date createDate, Date lastUpdateDate) {
        setId(id);
        setName(name);
        setCreateDate(createDate);
        setLastUpdateDate(lastUpdateDate);
    }

    public void input() {
        System.out.println("Input department ...");
        this.id = inputId().toUpperCase();
        this.name = Util.inputString("Please enter name (not blank or empty)").trim();
        this.createDate = inputCreateDate();
        this.lastUpdateDate = inputLastUpdateDate();
    }

    public int parseString(String stringObject) {
        if (stringObject != null) {
            return setAttribute(stringObject.split(Util.SEPARATOR));
        }
        return 0;
    }

    public int setAttribute(String[] attributes) {
        int idx = 0;
        if (attributes != null && attributes.length >= getAttributeCount()) {
            setId(attributes[idx++].trim());
            setName(attributes[idx++].trim());
            try {
                setCreateDate(Util.toDate(attributes[idx++].trim()));
            } catch (ParseException ex) {
                Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                setLastUpdateDate(Util.toDate(attributes[idx++].trim()));
            } catch (ParseException ex) {
                Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idx;
    }

    public void output() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" {");
        sb.append(toString());
        sb.append("}");
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append(Util.SEPARATOR);
        sb.append(this.name);
        sb.append(Util.SEPARATOR);
        sb.append(Util.toString(this.createDate));
        sb.append(Util.SEPARATOR);
        sb.append(Util.toString(this.lastUpdateDate));
        return sb.toString();
    }

    protected int getAttributeCount() {
        return Department.ATTRIBUTE_COUNT;
    }

    private boolean validateId(String id, boolean checkExists) {
        return Util.validateString(id, Department.ID_PATTERN, true)
                && (!checkExists || !Util.isDepartmentdExists(id));
    }

    private String inputId() {
        String inputId;
        do {
            inputId = Util.inputString("Please enter the id with the pattern(" + Department.ID_FORMAT + ")");
        } while (!validateId(inputId, true));

        return inputId;
    }

    private Date inputCreateDate() {
        Date date;
        do {
            date = Util.inputDate("Please enter create date");
        } while (!Util.validateDate(date, this.lastUpdateDate));
        return date;
    }

    private Date inputLastUpdateDate() {
        Date date;
        do {
            date = Util.inputDate("Please enter last update date");
        } while (!Util.validateDate(this.createDate, date));
        return date;
    }
}
