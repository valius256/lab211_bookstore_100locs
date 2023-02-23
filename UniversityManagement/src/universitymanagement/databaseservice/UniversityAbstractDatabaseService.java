package universitymanagement.databaseservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import universitymanagement.entity.UniversityEntityInterface;

/**
 * Abstract class UniversityAbstractDatabaseService.
 *
 * @author hasu
 * @param <EntityClass>
 */
public abstract class UniversityAbstractDatabaseService<EntityClass extends UniversityEntityInterface>
        implements UniversityDatabaseServiceInterface<EntityClass> {

    protected static final String SEPARATOR = ",";
    private static final String DATABASE_FOLDER = "database/";
    private static final String DATABASE_FILE_EXTENSION = ".csv";

    public List loadEntitysFromFile(String filePath) {
        List<EntityClass> entityList = new ArrayList();
        List<String> entityStringList = readStringFromFile(filePath);
        EntityClass entity;
        for (String entityString : entityStringList) {
            if (!entityString.isBlank()) {
                entity = toEntity(entityString);
                if (entity != null) {
                    entityList.add(entity);
                }
            }
        }
        return entityList;
    }

    public boolean saveEntitysToFile(String filePath, List<EntityClass> entityList) {
        if (entityList != null && !entityList.isEmpty()) {
            List<String> entityStringList = new ArrayList();
            for (EntityClass entity : entityList) {
                entityStringList.add(toString(entity));
            }
            return saveStringToFile(filePath, entityStringList);
        }
        return false;
    }

    protected String getEntityFilePath(Class clazz) {
        return UniversityAbstractDatabaseService.DATABASE_FOLDER
                + clazz.getSimpleName()
                + UniversityAbstractDatabaseService.DATABASE_FILE_EXTENSION;
    }

    protected void prepareDataFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(">>>>> Error: " + ex.getMessage());
//                Logger.getLogger(UniversityAbstractDatabaseService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private List<String> readStringFromFile(String filePath) {
        List<String> dataObjectList = new ArrayList();
        try ( Scanner sc = new Scanner(new File(filePath))) {
            String data;
            while (sc.hasNextLine()) {
                data = sc.nextLine();
                if (!data.isBlank()) {
                    dataObjectList.add(data);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UniversityAbstractDatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataObjectList;
    }

    private boolean saveStringToFile(String filePath, List<String> strEntityList) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (String strEntity : strEntityList) {
                writer.append(strEntity);
                writer.append("\n");
            }
            writer.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(UniversityAbstractDatabaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    protected abstract String toString(EntityClass entity);

    protected abstract EntityClass toEntity(String entityString);

}
