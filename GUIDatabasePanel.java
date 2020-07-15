package DatabaseStuff;

/******************************************************************************************
 * @author :    Bret Miller, Omar Tiba, Robert Saunders
 * @version :   Version 1 for Summer 2020
 * date:        7/15/2020
 * class:       GUIDatabasePanel
 * description: Code relating to whats displayed in the GUI.
 ******************************************************************************************/
import javax.swing.*;
import java.awt.*;

class GUIDatabasePanel extends JPanel {

    private final JList list;

    private final JTextArea info;

    private final Ship[] infoShips;


    public GUIDatabasePanel() {

        setLayout(new BorderLayout(5, 5));

        Database database = new Database();
        String[] shipList = database.getShipName();
        infoShips = database.getShip();


        list = new JList(shipList);
        info = new JTextArea("Welcome click on a ship to view it's stats.");
        JScrollPane data = new JScrollPane(info);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list), BorderLayout.WEST);
        add(data, BorderLayout.CENTER);





        list.addListSelectionListener(
                event -> {
                    info.setText(infoShips[list.getSelectedIndex()].print());

//                        setBackground(colors[list.getSelectedIndex()]);
                }
        );
    }
}
