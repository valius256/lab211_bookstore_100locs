package examinationmanagement.model;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import examinationmanagement.util.Util;

/**
 * Class doctor
 *
 * @author hasu
 */
public class Doctor extends People {

    public static final String ID_FORMAT = "DOCxxxxx";
    private static final String ID_PATTERN = "DOC\\d{5}";
    private static final int ATTRIBUTE_COUNT = 4;

    private boolean sex;
    private String departmentId;
    private Date createDate;
    private Date lastUpdateDate;

    public boolean isSex() {
        return this.sex;
    }

    public final void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public final void setDepartmentId(String departmentId) {
        if (validateDepartmentId(departmentId)) {
            this.departmentId = departmentId;
        } else {
            System.out.println("Err: ...");
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

    public Doctor() {
        this.sex = false;
        this.departmentId = "";
        this.createDate = null;
        this.lastUpdateDate = null;
    }

    public Doctor(String id, String name, String address, boolean sex, String departmentId, Date createDate, Date lastUpdateDate) {
        super(id, name, address);
        setSex(sex);
        setDepartmentId(departmentId);
        setCreateDate(createDate);
        setLastUpdateDate(lastUpdateDate);
    }

    @Override
    public void input() {
        System.out.println("Input doctor ...");
        super.input();
        this.sex = Util.inputBoolean("Please enter sex");
        this.departmentId = inputDepartmentId();
        this.createDate = inputCreateDate();
        this.lastUpdateDate = inputLastUpdateDate();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(Util.SEPARATOR);
        sb.append(this.sex);
        sb.append(Util.SEPARATOR);
        sb.append(this.departmentId);
        sb.append(Util.SEPARATOR);
        sb.append(Util.toString(this.createDate));
        sb.append(Util.SEPARATOR);
        sb.append(Util.toString(this.lastUpdateDate));
        return sb.toString();
    }

    @Override
    public int setAttribute(String[] attributes) {
        int idx = 0;
        if (attributes != null && attributes.length >= getAttributeCount()) {
            idx = super.setAttribute(attributes);
            setSex(Boolean.parseBoolean(attributes[idx++].trim()));
            setDepartmentId(attributes[idx++].trim());
            try {
                setCreateDate(Util.toDate(attributes[idx++].trim()));
            } catch (ParseException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                setLastUpdateDate(Util.toDate(attributes[idx++].trim()));
            } catch (ParseException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idx;
    }

    /**
     *
     * @return
     */
    @Override
    protected String getIdFormatString() {
        return Doctor.ID_FORMAT;
    }

    @Override
    protected int getAttributeCount() {
        return super.getAttributeCount() + Doctor.ATTRIBUTE_COUNT;
    }

    @Override
    protected boolean validateId(String id, boolean checkExists) {
        return Util.validateString(id, Doctor.ID_PATTERN, true)
                && (!checkExists || !Util.isDoctorIdExists(id));
    }

    private String inputDepartmentId() {
        String depId;
        do {
            depId = Util.inputString("Please enter the department's id with the pattern(" + Department.ID_FORMAT + ")").trim();
        } while (!validateDepartmentId(depId));

        return depId;
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

    private boolean validateDepartmentId(String id) {
        return Util.isExistsDepartmentId(id);
    }

}
