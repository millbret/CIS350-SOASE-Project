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
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

class GUIDatabasePanel extends JFrame {

    private JTree tree;
    private JTextArea textArea;
    private Database shipList;
    //private final JSplitPane splitPane;
    private final JScrollPane scrollPane;
    private Map<String, DefaultMutableTreeNode> shipMap;

    private DefaultMutableTreeNode root;

    public GUIDatabasePanel() {

        setLayout(new BorderLayout(5, 15));

        shipList = new Database();
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Food");

        createNodes(top);
        tree = new JTree(top);
        root = new DefaultMutableTreeNode("Data");

        //String[] shipList = database.getShipName();
        //infoShips = database.getShip();
        scrollPane = new JScrollPane(tree);
        scrollPane.createVerticalScrollBar();
        textArea = new JTextArea(20,50);

        //list = new JList(shipList);
        //info = new JTextArea("Welcome click on a ship to view it's stats.");


        add(new JScrollPane(tree), BorderLayout.WEST);
        add(textArea, BorderLayout.CENTER);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.isLeaf() && node != null) {
                    Object nodeInfo = node.getUserObject();

                    textArea.setText(nodeInfo.toString());
                    //System.out.println("I was clicked");
                    //System.out.println(nodeInfo.toString());
                }
            }
        });

        pack();
    }

    private void createNodes(DefaultMutableTreeNode top) {

        shipMap = new HashMap<>();
        shipMap.put("Food", top);

        Ship[] ship = shipList.getShip();


        for (int i = 0; i < ship.length; i++) {

            //If type does not exist then add all three components
            if (shipMap.get("Food/" + ship[i].getFaction()) == null) {
                addShip("Food", ship[i].getFaction());
                addShip("Food/" + ship[i].getFaction(), ship[i].getShipType());
                addAliasShip("Food/" + ship[i].getFaction() + "/" + ship[i].getShipType(), ship[i].getName(), ship[i]);
                //Name.setAlias(food[i].getName());
            } else {
                if (shipMap.get("Food/" + ship[i].getFaction() + "/" + ship[i].getShipType()) == null) {
                    addShip("Food/" + ship[i].getFaction(), ship[i].getShipType());
                    addAliasShip("Food/" + ship[i].getFaction() + "/" + ship[i].getShipType(), ship[i].getName(), ship[i]);
                    //Name.setAlias(food[i].getName());
                } else {
                    if (shipMap.get("Food/" + ship[i].getFaction() + "/" + ship[i].getShipType() + "/" + ship[i].getName()) == null) {
                        addAliasShip("Food/" + ship[i].getFaction() + "/" + ship[i].getShipType(), ship[i].getName(), ship[i]);
                        //Name.setAlias(food[i].getName());
                    }
                }
            }
        }
    }

    private void addAliasShip(String path, String name, Ship ship) {
        DefaultMutableTreeNode currentNode = shipMap.get(path);
        AliasTreeNode childNode = new AliasTreeNode(ship, name);
        childNode.setAlias(name);
        currentNode.add(childNode);

        shipMap.put(path + "/" + name, childNode);
    }

    private void addShip(String path, String name) {
        DefaultMutableTreeNode currentNode = shipMap.get(path);
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(name);
        currentNode.add(childNode);
        shipMap.put(path + "/" + name, childNode);
        //model.reload();
    }

    private static void createGUI(){
        new GUIDatabasePanel().setVisible(true);
    }

    public static void main(String args[]){
        createGUI();

    }
}
