package bookstoreManagement;

import model.Publisher;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Book;
import utils.Util;

/**
 *
 * @author hasu
 */
public class PublisherManagement {

    private static PublisherManagement instance = new PublisherManagement();

    public static PublisherManagement getInstance() {
        return instance;
    }

    private List<Publisher> publisherList;

    public List<Publisher> getPublisherList() {
        return publisherList;
    }

    private PublisherManagement() {
        this.publisherList = new ArrayList();
    }

    public Publisher addNew() {
        Publisher p = new Publisher();
        p.input();
        
         if((checkDuplicate(p.getId())) == false){
            if(this.publisherList.add(p)){
                return p;
            }
        }
        
        System.out.println("dupplicated");
//        publisherList.add(p);
        return p;
    }

    public void delete() {
        String ID = Util.inputString("Input ID publisher: ", true);
        for (Publisher publisher : publisherList) {
            if (ID.equals(publisher.getId())) {
                publisherList.remove(publisher);
                return;
            }
        }
        System.out.println("Publisher’s ID does not exist");
    }
    
     private boolean checkDuplicate(String Id) {
        for (Publisher publisher : publisherList) {
            if (publisher.getId().equals(Id)) {
                return true;
            }
        }
        return false;
    }

    public void SaveToFile() {
        if (publisherList.isEmpty()) {
            System.out.println("Khong can ghi file");
            return;
        }

        try {
            File f = new File("publisher.txt");
            if (!f.exists()) {
                return;
            }

            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            for (Publisher publisher : publisherList) {
                pw.println(publisher.getId() + "|   |" + publisher.getName() + "|   |" + publisher.getPhone());
            }

            fw.close();
            pw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Success");
    }

    public void printDataFromFile() {
        try {
            File f = new File("publisher.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

            fr.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public Publisher searchID(String ID) {
        for (Publisher i : publisherList) {
            if (ID.equals(i.getId())) {
                return i;
            }
        }
        return null;
    }

    public Publisher getPublisherById(String publisherId) {
        if (publisherId != null && !publisherId.isBlank()) {
            for (Publisher pub : publisherList) {
                if (publisherId.equalsIgnoreCase(pub.getId())) {
                    return pub;
                }
            }
        }
        return null;
    }

    public List<Publisher> filterById(String publisherId) {
        if (publisherId != null && !publisherId.isBlank()) {
            this.publisherList.stream().filter(pub -> publisherId.equalsIgnoreCase(pub.getId())).collect(Collectors.toList());
        }
        return null;
    }
}
