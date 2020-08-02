package DatabaseStuff;

/******************************************************************************************
 * @author :    Bret Miller, Omar Tiba, Robert Saunders
 * @version :   Version 3 for Summer 2020
 * date:        8/1/2020
 * class:       GUIDatabasePanel
 * description: Code relating to whats displayed on the GUI and how the components react to
 *              each other.
 ******************************************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;

class GUIDatabasePanel extends JFrame implements ActionListener {
    /** JTree used to store the list of ships in a directory **/
    private JTree tree;

    /** JTextArea that shows various information about ships when selected. Also displays help information **/
    private JTextArea textArea = new JTextArea(20,50);;

    /** shipList used to receive the list of ships **/
    private Database shipList;

    /** Map used to identify ships in the tree with their relative path **/
    private Map<String, DefaultMutableTreeNode> shipMap;

    /** JTable used to compare ships to one another **/
    private JTable table;

    /** treePopup is a JPopupMenu that is assigned to the Jtree. Used to add ships to JTable **/
    private JPopupMenu treePopup;

    /** tablePopup is a JPopupMenu assigned to the JTable. Used to remove ships from JTable **/
    private JPopupMenu tablePopup;

    /** JMenuBar to hold menu items */
    private JMenuBar menu;

    /** JMenu item */
    private JMenu fileMenu;

    /** JMenuItems inside JMenu items */
    private JMenuItem helpItem;
    private JMenuItem exitItem;

    public GUIDatabasePanel() {
        menu = new JMenuBar();

        fileMenu = new JMenu("File");

        //menu items to exit and call help dialog.
        helpItem = new JMenuItem("Help");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(helpItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitItem);

        menu.add(fileMenu);

        helpItem.addActionListener(this);
        exitItem.addActionListener(this);

        setJMenuBar(menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(5, 15));

        //Panels used for the Ship information screen and compare screen.
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //Used to create separate tabs for Ship information and compare ships.
        JTabbedPane tabPane = new JTabbedPane();

        //Creates the list of ships from "Sins of a Solar Empire."
        shipList = new Database();

        //The Root of the JTree and creating the first node
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("SOASE Ships");
        createNodes(top);

        //Used as a directory to show the list of ships
        tree = new JTree(top);

        //Used to compare ship information
        table = new JTable(shipList);

        //initializing and setting the size of the JTextArea

        //Jlist of JCheckListItems to compare values in the JTable. Each JCheckListItem is a different attribute of the ship
        JList<CheckListItem> list = new JList<>(new CheckListItem[] { new CheckListItem("Type"),
                new CheckListItem("Faction"), new CheckListItem("Armor Type"), new CheckListItem("Number of Weapons"),
                new CheckListItem("Shield"),new CheckListItem("Armor"),new CheckListItem("Hull"),
                new CheckListItem("Fleet Supply"),new CheckListItem("Credits"),new CheckListItem("Metals"),
                new CheckListItem("Crystals"),new CheckListItem("Build Time"),new CheckListItem("XP"),
                new CheckListItem("Hull Restore"),new CheckListItem("Shield Restore"),
                new CheckListItem("Max Speed"),new CheckListItem("Antimatter Supply")});

        CheckListRenderer listRenderer = new CheckListRenderer();
        list.setCellRenderer(listRenderer);

        //Allows the selection of multiple JCheckListItems in the JList
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //MouseListener to find when a JCheckListItem is selected
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event){
                JList list = (JList)event.getSource();
                int index = list.locationToIndex(event.getPoint()); //finds the specific JCheckListItem selected
                CheckListItem item = (CheckListItem)list.getModel().getElementAt(index);
                item.setSelected(!item.isSelected()); // Toggle selected state
                list.repaint(list.getCellBounds(index, index));// Repaint cell

                if(item.isSelected()){
                    //Updates the JTableHeaders and JTable to display the information offered by the JCheckListItem
                    shipList.setTableHeaders(index+1, true);
                }
                else
                    //Updates the JTableHeaders and JTable to remove the information offered by the JCheckListItem
                    shipList.setTableHeaders(index+1, false);
            }
        });

        //JPopupMenu for the JTree which allows the user to add a ship to the JTable for comparing
        treePopup = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Compare");
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.getAccessibleContext().setAccessibleDescription("Compare");
        menuItem.addActionListener(e -> {
            //Finds path of the node selected
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            //checks to see if the node is a leaf. Object data is only stored in leaf nodes.
            if(node.isLeaf()){
                Object nodeInfo = node.getUserObject();
                //Checks to see if the Ship is already in the JTable.
                //If it is in the JTable a dialog box informs the user and prevents the addition of the extra row.
                if(shipList.inTable((Ship)nodeInfo))
                    JOptionPane.showMessageDialog(null, "Ship is already in the table");

                else
                    //adds the ship to the compare JTable
                    shipList.add(nodeInfo);

            }
        });
        treePopup.add(menuItem);

        //JPopupMenu for the JTable which allows the user to remove ships from the JTable.
        //Row must be selected to remove the ship object
        tablePopup = new JPopupMenu();
        menuItem = new JMenuItem("Remove");
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.getAccessibleContext().setAccessibleDescription("Remove");
        menuItem.addActionListener(e -> {
            //finds the selected row index and removes it from the JTable
            int index = table.getSelectedRow();
            shipList.remove(index);
        });
        tablePopup.add(menuItem);

        Dimension treeDimension = new Dimension(150,350);
        Dimension listDimension = new Dimension(170,350);
        Dimension tableDimension = new Dimension(1000,350);

        //creating scrollPanes for the JTable, JTree, and JList of JCheckListItems
        JScrollPane treeScrollPane = new JScrollPane(tree);
        JScrollPane listScrollPane = new JScrollPane(list);
        JScrollPane tableScrollPane = new JScrollPane(table);

        treeScrollPane.createVerticalScrollBar();
        treeScrollPane.createHorizontalScrollBar();
        tableScrollPane.createHorizontalScrollBar();
        tableScrollPane.createVerticalScrollBar();
        listScrollPane.createVerticalScrollBar();

        treeScrollPane.setPreferredSize(treeDimension);
        listScrollPane.setPreferredSize(listDimension);
        tableScrollPane.setPreferredSize(tableDimension);

        //adding GUI components to JPanels
        panel1.add(treeScrollPane, BorderLayout.WEST);
        panel1.add(textArea, BorderLayout.CENTER);
        panel2.add(listScrollPane, BorderLayout.WEST);
        panel2.add(tableScrollPane, BorderLayout.CENTER);

        displayHelpDialog();

        //adding JPanels to JTabbedPane and naming tabs
        tabPane.addTab("Ship Info", panel1);
        tabPane.addTab("Compare", panel2);

        //adding JTabbedPane to the JFrame.
        add(tabPane);

        //MouseListener for the jTable to bring up the JTable popup menu.
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(SwingUtilities.isRightMouseButton(e)){
                    if(table.getSelectedRow() != -1)
                        //shows the popup menu at the location of the click on the selected row.
                        tablePopup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        //MouseListener for the JTree to bring up the JTree popup menu
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //If right click is used on a leaf node, show the popup menu
                if (SwingUtilities.isRightMouseButton(e)) {
                    //Declare and Initialize a node at the selected path in the tree.
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                    if(node == null) // if the node is a parent don't show the popup menu
                        return;
                    else{ //only show the popup menu if the node is a leaf
                        if (node.isLeaf()) {
                            //show popup menu at selected node
                            int row = tree.getClosestRowForLocation(e.getX(), e.getY());
                            tree.setSelectionRow(row);
                            treePopup.show(e.getComponent(), e.getX(), e.getY());
                        }
                    }
                }

                //If left click is used on a leaf node, display the object information the the JTextArea
                if ( SwingUtilities.isLeftMouseButton(e)){
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                    //checks to make sure the node is a leaf.
                    if(node != null) {
                        if (node.isLeaf()) {
                            Object nodeInfo = node.getUserObject();
                            textArea.setText(nodeInfo.toString());

                        }
                    }

                }
            }


        });
        pack();
    }

    /******************************************************************
     * Creates a JTree to be used as a directory for storing ship
     * information in the game "Sins of a Solar Empire." Information in
     * the Directory is split into root > Faction > ShipType > Ship
     * where Ship holds specific object information.
     * @param top the root of the tree tht nodes will be added to.
     *****************************************************************/
    private void createNodes(DefaultMutableTreeNode top) {
        //Map used to store specific relative paths for ships as they
        //are added to the JTree.
        shipMap = new HashMap<>();
        shipMap.put("Ship", top);

        //Gets the list of ships.
        ArrayList<Ship> ship = shipList.getShip();

        //adding ships to the tree.
        for (Ship value : ship) {
            //If Faction node does not exist then add all three levels: Faction > ShipType > Ship
            if (shipMap.get("Ship/" + value.getFaction()) == null) {
                addShip("Ship", value.getFaction());
                addShip("Ship/" + value.getFaction(), value.getShipType());
                addAliasShip("Ship/" + value.getFaction() + "/" + value.getShipType(), value.getName(), value);
            //If Faction does exist check ShipType.
            } else {
                //If ShipType node does not exist then add two levels: ShipType > Ship
                if (shipMap.get("Ship/" + value.getFaction() + "/" + value.getShipType()) == null) {
                    addShip("Ship/" + value.getFaction(), value.getShipType());
                    addAliasShip("Ship/" + value.getFaction() + "/" + value.getShipType(), value.getName(), value);
                 //If ShipType node does not exist check Ship
                } else {
                    //If Ship node does not exist then add one level: Ship
                    if (shipMap.get("Ship/" + value.getFaction() + "/" + value.getShipType() + "/" + value.getName()) == null) {
                        addAliasShip("Ship/" + value.getFaction() + "/" + value.getShipType(), value.getName(), value);
                    }
                }
            }
        }
    }

    /******************************************************************
     * Using DefaultMutableTreeNode to add a node to the Jtree with
     * object data will name the node after the toString in the Ship
     * class if it has one. Using the AliasTreeNode class we assign
     * an alias name to the node without having to adjust the toString
     * in the Ship class, as it is needed for the JTextField.
     * @param path path of the node down the JTree
     * @param name name that will be used as an alias for the node
     * @param ship Ship information being stored in the node
     *****************************************************************/
    private void addAliasShip(String path, String name, Ship ship) {
        //Gets the parent node that the new node will be added to.
        DefaultMutableTreeNode currentNode = shipMap.get(path);
        AliasTreeNode childNode = new AliasTreeNode(ship, name);

        //Set the alias of the node
        childNode.setAlias(name);
        currentNode.add(childNode);

        //adds the new path of the new node and the node to the Map
        shipMap.put(path + "/" + name, childNode);
    }

    /******************************************************************
     * Adds a named node to the JTree, at a specific path location
     * @param path path of the parent node the new node will be added
     *             under.
     * @param name Name that will be given to the node and shown in the
     *             JTree
     *****************************************************************/
    private void addShip(String path, String name) {
        //Gets the parent node that the new node will be added to.
        DefaultMutableTreeNode currentNode = shipMap.get(path);
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(name);
        currentNode.add(childNode);

        //adds the new path of the new node and the node to the Map
        shipMap.put(path + "/" + name, childNode);
    }

    /******************************************************************
     * Event handling code for menu items
     * @param e Holds the action event parameter
     *****************************************************************/
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comp = e.getSource();

        if(helpItem == comp){
            displayHelpDialog();
        }

        if(exitItem == comp){
            System.exit(1);
        }
    }

    /******************************************************************
     * Displays help dialog to the user in the JTextArea at the start
     * and when the help enu item is selected.
     *****************************************************************/
    private void displayHelpDialog(){
        textArea.setText("Hello! welcome to the Sins of a Solar Empire ship database.\n\n " +
                        "To use this program you can select a ship by following this basic structure\n" +
                        " with the tree on the left. Faction > Ship Type > Ship. Left clicking on the ship\n " +
                        "will display their information in this center text area here.\n\n" +
                        "The compare table on the second tab is used to help you compare multiple ships at\n " +
                        "the same time. You can select and deselect what stats you would like to see by choosing\n" +
                        " them on the checklist to the left in the compare tab. To add a ship to this list you do\n" +
                        " so by selecting and right clicking the ship in the tree and clicking the compare option from\n" +
                        " the menu that pops up. To remove the ship from the table select and right click on the ship\n" +
                        " from the table and select the remove option from the menu that appears.");
    }

    /******************************************************************
     * Creates and runs the GUI.
     *****************************************************************/
    public static void main(String[] args){
        new GUIDatabasePanel().setVisible(true);
    }

}
