
package views;

import controllers.DoctorManager;
import controllers.Validation;

public class MainMenu extends Menu{
    Validation val = new Validation();
    DoctorManager doc = new DoctorManager();

    public MainMenu(String title, String[] choices) {
        super(title, choices);
    }

    @Override
    public void execute(int ch) {
        if (doc.getId() == 0) {
            System.out.println("Database does not exist");
            return;
        }
        
        switch (ch) {
            case 1:
                String name, spec;
                int avail;
                System.out.println("==== ADD NEW ====");
                System.out.print("Enter Name: ");
                name = val.inputString();
                System.out.print("Enter Specialization: ");
                spec = val.inputString();
                
                while (true) {                    
                    System.out.print("Enter Availability: ");
                    avail = val.inputNum();
                    if (avail >= 0 ) {
                        break;
                    }
                }
                
                doc.addDoctor(name, spec, avail);
                System.out.println("--------------\nADD SUCCESS!!");
                
                break;
            case 2:
                System.out.println("==== UPDATE ===="); 
                String id;
                System.out.print("Enter Code: ");
                id = val.inputString();
                
                if (!doc.checkExist(id)) {
                    System.out.println("NOT FOUND!!");
                    return;
                }
                
                System.out.print("Enter Name: ");
                name = val.inputString();
                System.out.print("Enter Specialization: ");
                spec = val.inputString();
                
                while (true) {                    
                    System.out.print("Enter Availability: ");
                    avail = val.inputNum();
                    if (avail >= 0 ) {
                        break;
                    }
                }
                
                doc.update(id, name, spec, avail);
                
                System.out.println("-------------\nUPDATE SUCCESS!!");
                
                break;
                
            case 3:
                System.out.println("==== DELETE ====");
                System.out.print("Enter Code: ");
                id = val.inputString();
                
                if (!doc.checkExist(id)) {
                    System.out.println("NOT FOUND!!");
                    return;
                }
                
                doc.delete(id);
                
                System.out.println("-------------\nDELETE SUCCESS!!");
                
                break;
                
            case 5:
                System.out.println("==== SEARCH ====");
                System.out.print("Enter Code: ");
                id = val.inputString();
                
                if (!doc.checkExist(id)) {
                    System.out.println("NOT FOUND!!");
                    return;
                }
                
                doc.search(id);
                
                break;
            case 4:
                System.out.println("==== DISPLAY ALL ====");
                doc.displayAll();
                break;
        }
    }
    
}
