package universitymanagement.service;

import universitymanagement.main.ModelException;
import universitymanagement.databaseservice.FacultyDatabaseService;
import universitymanagement.util.Singleton;
import universitymanagement.entity.FacultyEntity;
import universitymanagement.model.FacultyModel;

/**
 * Faculty service.
 *
 * @author hasu
 */
public class FacultyService extends UniversityAbstractService<FacultyModel, FacultyEntity> {

    private FacultyService() {
        this.dataManagementService = Singleton.getInstance(FacultyDatabaseService.class);
    }

    public FacultyModel createModel(String id, String name, String description) throws ModelException {
        if (id != null && name != null && description != null) {
            if (filterById(id) == null) {
                return new FacultyModel(id, name, description);
            } else {
                throw new ModelException(id + " already exists.");
            }
        }
        return null;
    }

    @Override
    public int loadModels() {
        return loadEntityFromDatabase(FacultyEntity.class);
    }

    @Override
    public boolean saveModels() {
        return saveEntitytoDatabase(FacultyEntity.class);
    }

    @Override
    public void refresh() {
        MajorsService majorsService = Singleton.getInstance(MajorsService.class);
        for (FacultyModel model : this.modelMap.values()) {
            model.setMajorsList(majorsService.filterByFacultyId(model.getId()));
        }
    }

    @Override
    protected FacultyEntity toEntity(FacultyModel model) {
        FacultyEntity entity = null;
        if (model != null) {
            entity = new FacultyEntity();
            entity.setId(model.getId());
            entity.setName(model.getName());
            entity.setDescription(model.getDescription());
        }
        return entity;
    }

    @Override
    protected FacultyModel toModel(FacultyEntity entity) {
        FacultyModel model = null;
        if (entity != null) {
            try {
                model = new FacultyModel();
                model.setId(entity.getId());
                model.setName(entity.getName());
                model.setDescription(entity.getDescription());
                model.setMajorsList(Singleton.getInstance(MajorsService.class).filterByFacultyId(entity.getId()));
            } catch (ModelException ex) {
                System.out.println(">>>>> Error: " + ex.getMessage());
//                Logger.getLogger(FacultyService.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return model;
    }

}
