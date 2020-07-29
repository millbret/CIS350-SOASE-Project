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
import java.awt.event.*;
import java.util.ArrayList;
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

    private JTable table;

    private JPopupMenu treePopup;
    private JPopupMenu tablePopup;

    private JMenuItem menuItem;

    public GUIDatabasePanel() {

        setLayout(new BorderLayout(5, 15));

        //JPanel panel1 = new JPanel();
        // splitPane = new JSplitPane();
        // treePanel = new JPanel();
        // textPanel = new JPanel();
        // JTabbedPane tabbedPane = new JTabbedPane();

        shipList = new Database();
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Food");
        //foodList.viewFoods();
        createNodes(top);

        tree = new JTree(top);
        root = new DefaultMutableTreeNode("Data");
        //treeMap = new HashMap<>();
        //treeMap.put("Food", top);

        //model.reload();

        table = new JTable(shipList);
        //table.getColumnModel().getColumn(0).setPreferredWidth(20);

        scrollPane = new JScrollPane(tree);
        scrollPane.createVerticalScrollBar();
        textArea = new JTextArea(20,50);



        //Jlist of JCheckBoxes to compare values in the JTable
        JList list = new JList(new CheckListItem[] { new CheckListItem("Type"),
                new CheckListItem("Faction"), new CheckListItem("Armor Type"), new CheckListItem("Number of Weapons"),
                new CheckListItem("Shield"),new CheckListItem("Armor"),new CheckListItem("Hull"),
                new CheckListItem("Fleet Supply"),new CheckListItem("Credits"),new CheckListItem("Metals"),
                new CheckListItem("Crystals"),new CheckListItem("Build Time"),new CheckListItem("XP"),
                new CheckListItem("Hull Restore"),new CheckListItem("Shield Restore"),new CheckListItem("DPS"),
                new CheckListItem("Max Speed"),new CheckListItem("Antimatter Supply")});
        list.setCellRenderer(new CheckListRenderer());
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event){
                JList list = (JList)event.getSource();
                int index = list.locationToIndex(event.getPoint());
                CheckListItem item = (CheckListItem)list.getModel().getElementAt(index);
                item.setSelected(!item.isSelected()); // Toggle selected state
                list.repaint(list.getCellBounds(index, index));// Repaint cell

                if(item.isSelected()){
                    shipList.setTableHeaders(index+1, true);
                    // table.getColumnModel().getColumn(index+1).setPreferredWidth(20);
                    System.out.println( "I was selected at index " + item.toString());
                }
                else
                    shipList.setTableHeaders(index+1, false);
                System.out.println("I was unselected at index " + item.toString());
            }
        });

        treePopup = new JPopupMenu();
        menuItem = new JMenuItem("Compare");
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.getAccessibleContext().setAccessibleDescription("Compare");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                if(node.isLeaf()){
                    Object nodeInfo = node.getUserObject();
                    shipList.add(nodeInfo);
                }
                //System.out.println("Trying to add a node");
            }
        });
        treePopup.add(menuItem);

        tablePopup = new JPopupMenu();
        menuItem = new JMenuItem("Remove");
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.getAccessibleContext().setAccessibleDescription("Remove");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = table.getSelectedRow();
                shipList.remove(index);
            }
        });
        tablePopup.add(menuItem);

        add(new JScrollPane(tree), BorderLayout.WEST);
        add(textArea, BorderLayout.CENTER);
        add(new JScrollPane(list), BorderLayout.EAST);
        add(new JScrollPane(table), BorderLayout.SOUTH);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(SwingUtilities.isRightMouseButton(e)){
                    if(table.getSelectedRow() != -1)
                        tablePopup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                    if(node == null)
                        return;
                    else {
                        if (node.isLeaf()) {
                            int row = tree.getClosestRowForLocation(e.getX(), e.getY());
                            tree.setSelectionRow(row);
                            treePopup.show(e.getComponent(), e.getX(), e.getY());
                        }
                    }
                }

                if ( SwingUtilities.isLeftMouseButton(e)){
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

                    if(node == null) {
                        return;
                    }
                    else {
                        if (node.isLeaf()) {
                            Object nodeInfo = node.getUserObject();
                            textArea.setText(nodeInfo.toString());

                        } else {
                            return;
                        }
                    }
                }
            }


        });

        pack();
    }

    private void createNodes(DefaultMutableTreeNode top) {

        shipMap = new HashMap<>();
        shipMap.put("Ship", top);

        ArrayList<Ship> ship = shipList.getShip();


        for (int i = 0; i < ship.size(); i++) {

            //If type does not exist then add all three components
            if (shipMap.get("Ship/" + ship.get(i).getFaction()) == null) {
                addShip("Ship", ship.get(i).getFaction());
                addShip("Ship/" + ship.get(i).getFaction(), ship.get(i).getShipType());
                addAliasShip("Ship/" + ship.get(i).getFaction() + "/" + ship.get(i).getShipType(), ship.get(i).getName(), ship.get(i));
                //Name.setAlias(food[i].getName());
            } else {
                if (shipMap.get("Ship/" + ship.get(i).getFaction() + "/" + ship.get(i).getShipType()) == null) {
                    addShip("Ship/" + ship.get(i).getFaction(), ship.get(i).getShipType());
                    addAliasShip("Ship/" + ship.get(i).getFaction() + "/" + ship.get(i).getShipType(), ship.get(i).getName(), ship.get(i));
                    //Name.setAlias(food[i].getName());
                } else {
                    if (shipMap.get("Ship/" + ship.get(i).getFaction() + "/" + ship.get(i).getShipType() + "/" + ship.get(i).getName()) == null) {
                        addAliasShip("Ship/" + ship.get(i).getFaction() + "/" + ship.get(i).getShipType(), ship.get(i).getName(), ship.get(i));
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
