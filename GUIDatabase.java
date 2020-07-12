package DatabaseStuff;

import javax.swing.*;

public class GUIDatabase {

    public static void main(String arg[]){
        JFrame gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("SOASE Ship Database");

        gui.setContentPane(new GUIDatabasePanel());

        gui.setSize(750,300);
        gui.setVisible(true);
    }
}
