package examinationmanagement.model;

import examinationmanagement.list.IObject;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import examinationmanagement.util.Util;

/**
 * Class examination
 *
 * @author hasu
 */
public class Examination implements IObject {

    public static final String ID_FORMAT = "EXAxxxxx";
    private static final String ID_PATTERN = "EXA\\d{5}";
    private static final int ATTRIBUTE_COUNT = 5;

    private String id;
    private String doctorId;
    private String patientId;
    private String result;
    private Date date;

    public String getId() {
        return id;
    }

    public final void setId(String id) {
        if (validateId(id, false)) {
            this.id = id.toUpperCase();
        } else {
            System.out.println("Err");
        }
    }

    public String getDoctorId() {
        return doctorId;
    }

    public final void setDoctorId(String doctorId) {
        if (validateDoctorId(doctorId)) {
            this.doctorId = doctorId;
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public final void setPatientId(String patientId) {
        if (validatePatientId(patientId)) {
            this.patientId = patientId;
        }
    }

    public String getResult() {
        return result;
    }

    public final void setResult(String result) {
        if (result != null && !result.isBlank()) {
            this.result = result;
        }
    }

    public Date getDate() {
        return date;
    }

    public final void setDate(Date date) {
        if (validateDate(date)) {
            this.date = date;
        }
    }

    public Examination() {
    }

    public Examination(String id, String doctorId, String patientId, String result, Date date) {
        setId(id);
        setDoctorId(doctorId);
        setPatientId(patientId);
        setResult(result);
        setDate(date);
    }

    public void input() {
        System.out.println("Input examination ...");
        this.id = inputId().toUpperCase();
        this.doctorId = inputDoctorId();
        this.patientId = inputPatientId();
        this.result = Util.inputString("Please enter result (not blank or empty)").trim();
        this.date = new Date();
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append(Util.SEPARATOR);
        sb.append(this.doctorId);
        sb.append(Util.SEPARATOR);
        sb.append(this.patientId);
        sb.append(Util.SEPARATOR);
        sb.append(this.result);
        sb.append(Util.SEPARATOR);
        sb.append(Util.toString(this.date));
        return sb.toString();
    }

    public int parseString(String stringObject) {
        if (stringObject != null) {
            return setAttribute(stringObject.split(Util.SEPARATOR));
        }
        return 0;
    }

    public int setAttribute(String[] attributes) {
        int idx = 0;
        if (attributes != null && attributes.length >= Examination.ATTRIBUTE_COUNT) {
            setId(attributes[idx++].trim());
            setDoctorId(attributes[idx++].trim());
            setPatientId(attributes[idx++].trim());
            setResult(attributes[idx++].trim());
            try {
                setDate(Util.toDate(attributes[idx++].trim()));
            } catch (ParseException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idx;
    }

    @Override
    public void output() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" {");
        sb.append(toString());
        sb.append("}");
        System.out.println(sb.toString());
    }

    private String inputId() {
        String inputId;
        do {
            
            inputId = Util.inputString("Please enter the id with the pattern(" + Examination.ID_FORMAT + ")");
        } while (!validateId(inputId, true));

        return inputId;
    }

    private String inputDoctorId() {
        String docId;
//        do {
            docId = Util.inputString("Please enter the department's id with the pattern(" + Doctor.ID_FORMAT + ")").trim();
//        } while (!validateDoctorId(docId));

        return docId;
    }

    private String inputPatientId() {
        String patId;
//        do {
            patId = Util.inputString("Please enter the department's id with the pattern(" + Patient.ID_FORMAT + ")").trim();
//        } while (!validatePatientId(patId));

        return patId;
    }

    private boolean validateId(String id, boolean checkExists) {
        return Util.validateString(id, Examination.ID_PATTERN, true)
                && (!checkExists || !Util.isExaminationIdExists(id));
    }

    private boolean validateDoctorId(String id) {
        return Util.isDoctorIdExists(id);
    }

    private boolean validatePatientId(String id) {
        return Util.isPatientIdExists(id);
    }

    private boolean validateDate(Date date) {
        return Util.validateDate(date, null);
    }

}
