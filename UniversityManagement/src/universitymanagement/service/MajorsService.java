package universitymanagement.service;

import java.util.List;
import universitymanagement.main.ModelException;
import universitymanagement.databaseservice.MajorsDatabaseService;
import universitymanagement.util.Singleton;
import universitymanagement.entity.MajorsEntity;
import universitymanagement.model.MajorsModel;

/**
 * Majors service.
 *
 * @author hasu
 */
public class MajorsService extends UniversityAbstractService<MajorsModel, MajorsEntity> {

    private MajorsService() {
        this.dataManagementService = Singleton.getInstance(MajorsDatabaseService.class);
    }

    public List<MajorsModel> filterByFacultyId(String facultyId) {
        if (facultyId != null && !facultyId.isBlank()) {
            return this.modelMap.values().stream().filter(obj -> facultyId.equalsIgnoreCase(obj.getFacultyId())).toList();
        }
        return null;
    }

    public MajorsModel createModel(String id, String name, String facultyId, String description) throws ModelException {
        if (id != null && name != null) {
            if (filterById(id) == null) {
                return new MajorsModel(id, name, facultyId, description);
            } else {
                throw new ModelException(id + " already exists.");
            }
        }
        return null;
    }

    @Override
    public int loadModels() {
        return loadEntityFromDatabase(MajorsEntity.class);
    }

    @Override
    public boolean saveModels() {
        return saveEntitytoDatabase(MajorsEntity.class);
    }

    @Override
    public void refresh() {
        for (MajorsModel model : this.modelMap.values()) {
            model.setFaculty(Singleton.getInstance(FacultyService.class).filterById(model.getFacultyId()));
            model.setGroupList(Singleton.getInstance(GroupService.class).filterByMajorsId(model.getId()));
        }
    }

    @Override
    protected MajorsEntity toEntity(MajorsModel model) {
        MajorsEntity entity = null;
        if (model != null) {
            entity = new MajorsEntity();
            entity.setId(model.getId());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setFacultyId(model.getFacultyId());
        }
        return entity;
    }

    @Override
    protected MajorsModel toModel(MajorsEntity entity) {
        MajorsModel model = null;
        if (entity != null) {
            try {
                model = new MajorsModel();
                model.setId(entity.getId());
                model.setName(entity.getName());
                model.setDescription(entity.getDescription());
                model.setFacultyId(entity.getFacultyId());
                model.setFaculty(Singleton.getInstance(FacultyService.class).filterById(entity.getFacultyId()));
                model.setGroupList(Singleton.getInstance(GroupService.class).filterByMajorsId(entity.getId()));
            } catch (ModelException ex) {
                System.out.println(">>>>> Error: " + ex.getMessage());
//                Logger.getLogger(MajorsService.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return model;
    }

}
