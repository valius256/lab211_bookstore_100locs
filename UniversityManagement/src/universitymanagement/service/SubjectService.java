package universitymanagement.service;

import universitymanagement.main.ModelException;
import universitymanagement.databaseservice.SubjectDatabaseService;
import universitymanagement.entity.SubjectEntity;
import universitymanagement.model.SubjectModel;
import universitymanagement.util.Singleton;

/**
 * Subject service.
 *
 * @author hasu
 */
public class SubjectService extends UniversityAbstractService<SubjectModel, SubjectEntity> {

    private SubjectService() {
        this.dataManagementService = Singleton.getInstance(SubjectDatabaseService.class);
    }

    public SubjectModel createModel(String id, String name, int numberOfCredits, String description) throws ModelException {
        if (id != null && name != null && description != null) {
            if (filterById(id) == null) {
                return new SubjectModel(id, name, numberOfCredits, description);
            } else {
                throw new ModelException(id + " already exists.");
            }
        }
        return null;
    }

    @Override
    public int loadModels() {
        return loadEntityFromDatabase(SubjectEntity.class);
    }

    @Override
    public boolean saveModels() {
        return saveEntitytoDatabase(SubjectEntity.class);
    }

    @Override
    public void refresh() {
    }

    @Override
    protected SubjectEntity toEntity(SubjectModel model) {
        SubjectEntity entity = null;
        if (model != null) {
            entity = new SubjectEntity();
            entity.setId(model.getId());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
            entity.setNumberOfCredits(model.getNumberOfCredits());
        }
        return entity;
    }

    @Override
    protected SubjectModel toModel(SubjectEntity entity) {
        SubjectModel model = null;
        if (entity != null) {
            try {
                model = new SubjectModel();
                model.setId(entity.getId());
                model.setName(entity.getName());
                model.setDescription(entity.getDescription());
                model.setNumberOfCredits(entity.getNumberOfCredits());
            } catch (ModelException ex) {
                System.out.println(">>>>> Error: " + ex.getMessage());
//                Logger.getLogger(SubjectService.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return model;
    }
}
