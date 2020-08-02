package DatabaseStuff;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.ArrayList;

/******************************************************************************************
 * @author :    Bret Miller, Omar Tiba, Robert Saunders
 * @version :   Version 2 for Summer 2020
 * date:        7/29/2020
 * class:       Database
 * description: Holds all of the ships to be displayed by the GUI for users.
 ******************************************************************************************/

class Database extends AbstractTableModel {
    /** Used to call the search function that finds the ships to be stored in the JTree */
    private Search search = new Search();

    /** Holds the list of different ships in the game */
    private ArrayList<Ship> ship = new ArrayList<Ship>();

    /** Holds the list of ships to be compared.*/
    private ArrayList<Ship> compareShip = new ArrayList<Ship>();

    /** Array of Table headers that can be used for comparing ships */
    private String[] tableHeaders = {"Name", "Type", "Faction", "Armor Type", "Number of Weapons", "Shield",
            "Armor", "Hull", "Supply", "Credits", "Metals", "Crystals", "BuildTime", "XP", "Hull Restore",
            "Shield Restore", "Max Speed", "Antimatter"};

    /**Array of booleans to check which headers to display on the table */
    private boolean[] boolHeaders = {true, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false};

    /**Array to display correct table header order */
    private String[] updatedTableHeaders = new String[18];

    /** Array to determine and display correct table order */
    private int[] tableOrder = new int[18];

    /******************************************************************
     * Constructor creates a database of "Sins of a Solar Empire" ships
     * ***************************************************************/
    public Database() {
        try {
            search.storeShips(ship);

        }catch(Exception e){
            System.out.print(e);
        }
    }

    /******************************************************************
     * Updates the tableHeaders to be displayed in the JTable.
     *****************************************************************/
    private void updateTableHeaders() {
        int count = 0;
        for(int i = 0; i < boolHeaders.length; i++){
            //If the index in boolHeader is set to true the table
            // header with the same index is added to the table in order
            if(boolHeaders[i]) {
                updatedTableHeaders[count] = tableHeaders[i];
                //keeps track of the order of headers so data is put correctly into the table
                tableOrder[count] = i;
                count++;
            }
        }
    }

    /******************************************************************
     * Sets the table header at the specific index to true or false.
     * If true, the header is added to the table and if false it is
     * removed
     * @param index index of a specific table header
     * @param flag whether or not the table header is removed or added
     *             from the table
     *****************************************************************/
    public void setTableHeaders(int index, boolean flag) {
        boolHeaders[index] = flag;
        //updates the table structure
        fireTableStructureChanged();
    }

    /******************************************************************
     * Adds a Ship object to the list of ships being compared
     * @param a Ship Object
     *****************************************************************/
    public void add(Object a) {
        compareShip.add((Ship)a);
        //Updates the table data
        fireTableDataChanged();
    }

    /******************************************************************
     * Removes a Ship object from the list of ships being compared
     * @param index location of ship being removed in the ArrayList
     *****************************************************************/
    public void remove(int index){
        compareShip.remove(index);
        //Updates the table data
        fireTableDataChanged();
    }

    /******************************************************************
     * Checks to see if a specific Ship object is already in the table
     * @param ship Object being checked to see if it's in the table
     * @return true if Object is in the table. False otherwise
     *****************************************************************/
    public boolean inTable(Ship ship){
        return compareShip.contains(ship);
    }

    /******************************************************************
     * Returns the size of compareShip
     * @return a row count represented by the size of compareShip
     *****************************************************************/
    @Override
    public int getRowCount() {
        return compareShip.size();
    }

    /******************************************************************
     * Returns the column count of the compare table. Column count is
     * represented by the number of headers in the table
     * @return table header length
     *****************************************************************/
    @Override
    public int getColumnCount() {
        int sum = 0;
        //uses the boolHeader array to determine the column count
        //If an index is true then it is a column
        for (boolean boolHeader : boolHeaders) {
            if (boolHeader)
                sum++;
        }
        return sum;
    }

    /******************************************************************
     * Returns a name for the table headers
     * @param col column of the table
     * @return a string for the name of a header in position column
     *****************************************************************/
    @Override
    public String getColumnName(int col) {
        updateTableHeaders();
        // fireTableStructureChanged();
        return updatedTableHeaders[col];

    }

    /******************************************************************
     * Prints the results to the table on the given screen
     * @param row header column of the given screen
     * @param col index in the compareShip list
     * @return corresponding value for the given row and column
     * @throw RunTimeException if row or col are out of range
     ******************************************************************/
    @Override
    public Object getValueAt(int row, int col) {
        //Adds data to the table
        switch (tableOrder[col]) {
            case 0:
                return compareShip.get(row).getName(); //returns ship name

            case 1:
                return compareShip.get(row).getShipType(); //returns ship type

            case 2:
                return compareShip.get(row).getFaction(); //returns faction

            case 3:
                return compareShip.get(row).getArmorType(); //returns armor type

            case 4:
                return compareShip.get(row).getNumWeapons(); //returns num weapons

            case 5:
                return compareShip.get(row).getShields(); //returns shield HP

            case 6:
                return compareShip.get(row).getArmor(); //return armor HP

            case 7:
                return compareShip.get(row).getHull(); //return hull HP

            case 8:
                return compareShip.get(row).getFleetSupply(); //return fleet supply

            case 9:
                return compareShip.get(row).getCredits(); //return credits

            case 10:
                return compareShip.get(row).getMetals(); //return metals

            case 11:
                return compareShip.get(row).getCrystals(); //return crystals

            case 12:
                return compareShip.get(row).getBuildTime(); //return build time

            case 13:
                return compareShip.get(row).getXP(); //return XP

            case 14:
                return compareShip.get(row).getHullRestore(); //return hull restore

            case 15:
                return compareShip.get(row).getShieldRestore(); //return shield restore

            case 16:
                return compareShip.get(row).getMaxSpeed(); //return max speed

            case 17:
                return compareShip.get(row).getAntimatterSupply(); //return antimatter supply

        }
        throw new RuntimeException();
    }

    /*****************************************************************
     * Gets the list of ships names.
     * @return list of ships names.
     * ***************************************************************/
    public ArrayList<Ship> getShip() {
        return ship;
    }
}
