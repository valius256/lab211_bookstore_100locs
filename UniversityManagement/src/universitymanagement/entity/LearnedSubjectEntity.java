package universitymanagement.entity;

/**
 * Learned subject entity.
 *
 * @author hasu
 */
public class LearnedSubjectEntity implements UniversityEntityInterface{

    private String studentId;
    private String subjectId;
    private int semester;
    private float score;
    protected String description;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LearnedSubjectEntity() {
        this.studentId = "";
        this.subjectId = "";
        this.semester = Integer.MIN_VALUE;
        this.score = Float.NaN;
        this.description = "";
    }

}
