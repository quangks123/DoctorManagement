
package test;

import views.MainMenu;

public class Main {
    public static void main(String[] args) {
        String[] choices = {"ADD DOCTOR.", "UPDATE DOCTOR.", "DELETE DOCTOR.", "DISPLAY ALL.", "SEARCH DOCTOR.", "EXIT."};
        new MainMenu("==== MENU ====", choices).run();
    }
}
