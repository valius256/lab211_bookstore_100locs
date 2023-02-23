package examinationmanagement.main;

import examinationmanagement.model.Department;
import examinationmanagement.model.Doctor;
import examinationmanagement.model.Examination;
import examinationmanagement.service.UserManagetment;
import examinationmanagement.model.Patient;
import java.util.Date;
import examinationmanagement.list.DepartmentList;
import examinationmanagement.list.DoctorList;
import examinationmanagement.list.ExaminationList;
import examinationmanagement.list.PatientList;
import examinationmanagement.util.Util;

/**
 *
 * @author hasu
 */
public class ExaminationManagement {

    private static final ExaminationManagement instance = new ExaminationManagement();

    private final String departmentFilePath;
    private final String doctorFilePath;
    private final String patientFilePath;
    private final String examinationFilePath;

    private final DepartmentList departmentList;
    private final DoctorList doctorList;
    private final PatientList patientList;
    private final ExaminationList examinationtList;

    public static ExaminationManagement getInstance() {
        return instance;
    }

    public DoctorList getDoctorList() {
        return doctorList;
    }

    public DepartmentList getDepartmentList() {
        return departmentList;
    }

    public PatientList getPatientList() {
        return patientList;
    }

    public ExaminationList getExaminationtList() {
        return examinationtList;
    }

    private ExaminationManagement() {
        departmentFilePath = "Department.dat";
        doctorFilePath = "Doctor.dat";
        patientFilePath = "Patient.dat";
        examinationFilePath = "Examination.dat";

        departmentList = new DepartmentList(departmentFilePath);
        doctorList = new DoctorList(doctorFilePath);
        patientList = new PatientList(patientFilePath);
        examinationtList = new ExaminationList(examinationFilePath);
    }

    private void loadData() {
        this.departmentList.load();
        this.doctorList.load();
        this.patientList.load();
        this.examinationtList.load();
    }

    private void showAllDepartment() {
        departmentList.show();
    }

    private void filterDepartmentById() {
        System.out.println("filterDepartmentById ...");
    }

    private void filterDepartmentByName() {
        System.out.println("filterDepartmentByName ...");
    }

    private void addNewDepartment() {
        // check user role ROLE_ADMIN
        if (UserManagetment.getInstance().getCurrentUser().checkRole(UserRole.ADMIN) == true) {
            Department dep = new Department();
            dep.input();
            departmentList.add(dep);
            departmentList.save();
        } else {
            System.out.println("Eror: ....");
        }
    }

    private void updateDepartment() {
        System.out.println("updateDepartment ...");
    }

    private void deleteDepartment() {
        System.out.println("deleteDepartment ...");
    }

    private void showAllDoctor() {
        System.out.println("Doctor list:");
        doctorList.show();
    }

    private void filterDoctorById() {
        System.out.println("filterDoctorById ...");
    }

    private void filterDoctorByName() {
        System.out.println("filterDoctorByName ...");
    }

    private void filterDoctorByDepartmentId() {
        String id = Util.inputString("Please enter the department's id with the pattern(" + Department.ID_FORMAT + ")");
        System.out.println("Doctor list:");
        doctorList.showFilter(id);
//        List<Doctor> fList = doctorList.filter(id);
//        for (Doctor doc : fList) {
//            doc.output();
//        }
    }

    private void addNewDoctor() {
        // check user role ROLE_ADMIN
        if (UserManagetment.getInstance().getCurrentUser().checkRole(UserRole.ADMIN) == true) {
            Doctor doc = new Doctor();
            doc.input();
            doctorList.add(doc);
            doctorList.save();
        } else {
            System.out.println("Eror: ...");
        }
    }

    private void updateDoctor() {
        System.out.println("updateDoctor ...");
    }

    private void deleteDoctor() {
        System.out.println("deleteDoctor ...");
    }

    private void showAllPatient() {
        System.out.println("Patient list:");
        patientList.show();
    }

    private void filterPatientById() {
        System.out.println("filterPatientById ...");
    }

    private void filterPatientByName() {
        System.out.println("filterPatientByName ...");
    }

    private void addNewPatient() {
        // check user role ROLE_DOCTOR
        if (UserManagetment.getInstance().getCurrentUser().checkRole(UserRole.DOCTOR) == true) {
            Patient pati = new Patient();
            pati.input();
            patientList.add(pati);
            patientList.save();
        } else {
            System.out.println("Eror: ...");
        }

    }

    private void updatePatient() {
        System.out.println("updatePatient ...");
    }

    private void deletePatient() {
        System.out.println("deletePatient ...");
    }

    private void showAllExamination() {
        System.out.println("Examinationt list:");
        examinationtList.show();
    }

    private void filterExaminationById() {
        System.out.println("filterExaminationById ...");
    }

    private void filterExaminationByDoctorId() {
        String id = Util.inputString("Please enter the doctor's id with the pattern(" + Doctor.ID_FORMAT + ")");
        System.out.println("Examinationt list:");
        examinationtList.showFilter(id);
    }

    private void filterExaminationByPatientId() {
        System.out.println("filterExaminationByPatientId ...");
    }

    private void filterExaminationByDate() {
        Date date = Util.inputDate("Please enter the date filter");
        System.out.println("Examinationt list:");
        examinationtList.showFilter(date);
    }

    private void addNewExamination() {
        // check user role ROLE_USER
        if (UserManagetment.getInstance().getCurrentUser().checkRole(UserRole.USER) == true) {
            Examination exa = new Examination();
            exa.input();
            if (!Util.isPatientIdExists(exa.getPatientId())) {
                Patient p = new Patient();
                p.setId(exa.getPatientId());
                p.input();
//                exa.setPatientId(p.getId());
                patientList.add(p);
                patientList.save();
            }
            examinationtList.add(exa);
            examinationtList.save();
        } else {
            System.out.println("Eror: ...");
        }
    }

    private void updateExamination() {
        System.out.println("updateExamination ...");
    }

    private void deleteExamination() {
        System.out.println("deleteExamination ...");
    }

    private void run() {
        Menu menu = new Menu();
        int option = Integer.MAX_VALUE;
        MenuItem userChoice;
        do {
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case DEPARTMENT_SHOW_ALL -> {
                    showAllDepartment();
                }
                case DEPARTMENT_FILTER_BY_ID -> {
                    filterDepartmentById();
                }
                case DEPARTMENT_FILTER_BY_NAME -> {
                    filterDepartmentByName();
                }
                case DEPARTMENT_ADD_NEW -> {
                    addNewDepartment();
                }
                case DEPARTMENT_UPDATE -> {
                    updateDepartment();
                }
                case DEPARTMENT_DELETE -> {
                    deleteDepartment();
                }

                case DOCTOR_SHOW_ALL -> {
                    showAllDoctor();
                }
                case DOCTOR_FILTER_BY_ID -> {
                    filterDoctorById();
                }
                case DOCTOR_FILTER_BY_NAME -> {
                    filterDoctorByName();
                }
                case DOCTOR_FILTER_BY_DEPARTMENT_ID -> {
                    filterDoctorByDepartmentId();
                }
                case DOCTOR_ADD_NEW -> {
                    addNewDoctor();
                }
                case DOCTOR_UPDATE -> {
                    updateDoctor();
                }
                case DOCTOR_DELETE -> {
                    deleteDoctor();
                }

                case PATIENT_SHOW_ALL -> {
                    showAllPatient();
                }
                case PATIENT_FILTER_BY_ID -> {
                    filterPatientById();
                }
                case PATIENT_FILTER_BY_NAME -> {
                    filterPatientByName();
                }
                case PATIENT_ADD_NEW -> {
                    addNewPatient();
                }
                case PATIENT_UPDATE -> {
                    updatePatient();
                }
                case PATIENT_DELETE -> {
                    deletePatient();
                }

                case EXAMINATION_SHOW_ALL -> {
                    showAllExamination();
                }
                case EXAMINATION_FILTER_BY_ID -> {
                    filterExaminationById();
                }
                case EXAMINATION_FILTER_BY_DOCTOR_ID -> {
                    filterExaminationByDoctorId();
                }
                case EXAMINATION_FILTER_BY_PATIENT_ID -> {
                    filterExaminationByPatientId();
                }
                case EXAMINATION_FILTER_BY_DATE -> {
                    filterExaminationByDate();
                }
                case EXAMINATION_ADD_NEW -> {
                    addNewExamination();
                }
                case EXAMINATION_UPDATE -> {
                    updateExamination();
                }
                case EXAMINATION_DELETE -> {
                    deleteExamination();
                }
                case EXIT -> {
                    System.out.println("Exited!");
                }
                default -> {
                    System.out.println("???");
                }
            }
        } while (userChoice != MenuItem.EXIT);
    }

    private void start() {
        System.out.println("Examination management");
        if (UserManagetment.getInstance().login()) {
            UserManagetment.getInstance().getCurrentUser().output();
            loadData();
            run();
        } else {
            System.out.println("Login failed!");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ExaminationManagement().start();
    }

}
