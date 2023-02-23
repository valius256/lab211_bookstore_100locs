package universitymanagement.model;

import universitymanagement.main.ModelException;

/**
 * Learned subject model.
 *
 * @author hasu
 */
public class LearnedSubjectModel implements UniversityModelInterface {

    public static final int MIN_SEMESTER = 1;
    public static final int MAX_SEMESTER = 12;
    public static final float MIN_SCORE = 0.0F;
    public static final float MAX_SCORE = 10.0F;
    public static final float UNDEFINED = Float.NaN;

    private String studentId;
    private String subjectId;
    private float score;
    private int semester;
    private String description;
    private StudentModel student;
    private SubjectModel subject;

    public String getStudentId() {
        return studentId;
    }

    public final void setStudentId(String studentId) throws ModelException {
        if (studentId == null || studentId.isBlank()) {
            throw new ModelException("student's id is blank.");
        }
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public final void setSubjectId(String subjectId) throws ModelException {
        if (subjectId == null || subjectId.isBlank()) {
            throw new ModelException("subject's id is blank.");
        }
        this.subjectId = subjectId;
    }

    public float getScore() {
        return score;
    }

    public final void setScore(float score) {
        if (LearnedSubjectModel.MIN_SCORE <= score && score <= LearnedSubjectModel.MAX_SCORE) {
            this.score = score;
        } else {
            this.score = Float.NaN;
        }
    }

    public int getSemester() {
        return semester;
    }

    public final void setSemester(int semester) {
        if (LearnedSubjectModel.MIN_SEMESTER <= semester && semester <= LearnedSubjectModel.MAX_SEMESTER) {
            this.semester = semester;
        } else {
            this.semester = 0;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        } else {
            this.description = "";
        }
    }

    public StudentModel getStudent() {
        return student;
    }

    public final void setStudent(StudentModel student) {
        if (student != null) {
            this.student = student;
            this.studentId = student.getId();
        } else {
            this.studentId = "";
        }
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public final void setSubject(SubjectModel subject) {
        if (subject != null) {
            this.subject = subject;
            this.subjectId = subject.getId();
        } else {
            this.subjectId = "";
        }
    }

    public LearnedSubjectModel() {
        this.studentId = "";
        this.subjectId = "";
        this.score = LearnedSubjectModel.UNDEFINED;
        this.semester = 0;
        this.description = "";
    }

    public LearnedSubjectModel(
            String studentId,
            String subjectId,
            float score,
            int semester,
            String description) throws ModelException {
        setStudentId(studentId);
        setSubjectId(subjectId);
        setScore(score);
        setSemester(semester);
    }

    public LearnedSubjectModel(
            StudentModel student,
            SubjectModel subject,
            int semester,
            String description) {
        setStudent(student);
        setSubject(subject);
        setSemester(semester);
        setScore(LearnedSubjectModel.UNDEFINED);
    }

    @Override
    public String getId() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getStudentId());
        sb.append("_");
        sb.append(this.getSubjectId());
        sb.append("_");
        sb.append(this.semester);
        return sb.toString();
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
