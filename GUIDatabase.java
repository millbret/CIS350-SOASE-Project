package DatabaseStuff;

/******************************************************************************************
 * @author :    Bret Miller, Omar Tiba, Robert Saunders
 * @version :   Version 1 for Summer 2020
 * date:        7/15/2020
 * class:       GUIDatabase
 * description: This is how the code is run for the user to see it.
 ******************************************************************************************/
import javax.swing.*;

class GUIDatabase {

    public static void main(String[] args) {
        JFrame gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("SOASE Ship Database");

        gui.setContentPane(new GUIDatabasePanel());

        gui.setSize(750, 300);
        gui.setVisible(true);
    }
}
