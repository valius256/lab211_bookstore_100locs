package universitymanagement.model;

import java.util.ArrayList;
import java.util.List;
import universitymanagement.main.ModelException;
import universitymanagement.util.Util;

/**
 * Student model.
 *
 * @author hasu
 */
public class StudentModel extends UniversityAbstractModel {

    public static final String ID_FORMAT = "STxxxxxx";
    private static final String ID_PATTERN = "ST\\d{6}";

    private String groupId;
    private GroupModel group;
    private final List<LearnedSubjectModel> learnedSubjectList;

    public String getGroupId() {
        return groupId;
    }

    public final void setGroupId(String groupId) {
        if (groupId != null && !groupId.isBlank()) {
            this.groupId = groupId;
        } else {
            this.groupId = "";
        }
    }

    public GroupModel getGroup() {
        return group;
    }

    public final void setGroup(GroupModel group) {
        if (group != null) {
            this.group = group;
            this.groupId = group.getId();
        } else {
            this.groupId = "";
        }
    }

    public List<LearnedSubjectModel> getLearnedSubjectList() {
        return learnedSubjectList;
    }

    public final void setLearnedSubjectList(List<LearnedSubjectModel> learnedSubjectList) {
        this.learnedSubjectList.clear();
        if (learnedSubjectList != null) {
            this.learnedSubjectList.addAll(learnedSubjectList);
        }
    }

    public StudentModel() {
        this.groupId = "";
        this.learnedSubjectList = new ArrayList();
    }

    public StudentModel(
            String id,
            String name,
            String groupId,
            String description) throws ModelException {
        super(id, name, description);
        setGroupId(groupId);
        this.learnedSubjectList = new ArrayList();
        setLearnedSubjectList(learnedSubjectList);
    }

    public boolean registerSubject(LearnedSubjectModel learnedSubjectModel) {
        if (!this.learnedSubjectList.contains(learnedSubjectModel)) {
            return this.learnedSubjectList.add(learnedSubjectModel);
        }
        return false;
    }

    @Override
    protected boolean validateId(String id) {
        return Util.validateStringPattern(id, StudentModel.ID_PATTERN, true);
    }

}
