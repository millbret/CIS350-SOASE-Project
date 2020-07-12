package DatabaseStuff;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class GUIDatabasePanel extends JPanel {

    private JList list;
    private static String[] colornames = {"black", "blue", "red"};
    private static Color[] colors = {Color.BLACK, Color.BLUE, Color.RED};

    JScrollPane data;
    JTextArea info;

    Database database;

    String[] shipList;
    Ship[] infoShips;


    public GUIDatabasePanel(){

        setLayout(new BorderLayout(5,5));

        database = new Database();
        shipList = database.getShips();
        infoShips = database.getShip();


        list = new JList(shipList);
        info = new JTextArea("Testing...");
        data = new JScrollPane(info);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list), BorderLayout.WEST);
        add(data,BorderLayout.CENTER);





        list.addListSelectionListener(
                new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent event){
                        info.setText(infoShips[list.getSelectedIndex()].print());

//                        setBackground(colors[list.getSelectedIndex()]);
                    }
                }
        );
    }
}
