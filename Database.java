package DatabaseStuff;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.ArrayList;

/******************************************************************************************
 * @author :    Bret Miller, Omar Tiba, Robert Saunders
 * @version :   Version 1 for Summer 2020
 * date:        7/15/2020
 * class:       Database
 * description: Holds all of the ships to be displayed by the GUI for users.
 ******************************************************************************************/

class Database extends AbstractTableModel {

    private Search search = new Search();

    /** Holds the list of different ships in the game **/
    private ArrayList<Ship> ship = new ArrayList<Ship>();

    /** Holds the list of ships to be compared.**/
    private ArrayList<Ship> compareShip = new ArrayList<Ship>();

    /** Array of Table headers that can be used for comparing ships **/
    private String[] tableHeaders = {"Name", "Type", "Faction", "Armor Type", "Number of Weapons", "Shield",
            "Armor", "Hull", "Supply", "Credits", "Metals", "Crystals", "BuildTime", "XP", "Hull Restore",
            "Shield Restore", "Max Speed", "Antimatter"};

    /**Array of booleans to check which headers to display on the table **/
    private boolean[] boolHeaders = {true, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false};

    /**Array to display correct table header order **/
    private String[] updatedTableHeaders = new String[18];

    /** Array to determine and display correct table order **/
    private int[] tableOrder = new int[18];

    /*****************************************************************
     * Constructor  creates a database including ships and.
     * a two lists one containing the names of the ships and another.
     * that contains the ships themselves.
     * ***************************************************************/
    public Database() {
        try {
            search.storeShips(ship);

        }catch(Exception e){
            System.out.print(e);
        }

//        ship.add(new Ship("Paris", "Frigate", "Light", "UNSC", 5, 355,
//                40, 5, 10, 5, 1800, 3, 0, 0,
//                4, 700, 0, 2));
//        ship.add(new Ship("Punic", "Carrier", "VeryHeavy", "UNSC", 75, 5500,
//                1000, 1150, 110, 50,
//                16000, 24, 0, 0,
//                14, 500, 24, 5));
//        ship.add(new Ship("Marathon", "Cruiser", "Medium", "UNSC", 25, 950,
//                250, 90, 45, 50, 6000, 10, 0, 0,
//                7, 600, 3, 4));
//        ship.add(new Ship("CCS", "Cruiser", "Medium", "Covenant", 21, 1650,
//                220, 90, 35, 21, 4400, 5, 12000, 600,
//                3, 700, 16, 3));
//        ship.add(new Ship("CAS", "Carrier", "VeryHeavy", "Covenant", 100, 10000,
//                2600, 1850, 120, 50, 14000, 15, 50000, 2500,
//                8, 600, 62, 5));
//        //ship = new Ship[]{paris, punic, marathon, CCS, CAS};
//        //shipName = new String[]{"Paris", "Punic", "Marathon", "CCS", "CAS"};
////        this.search = "";
    }

    private void updateTableHeaders() {
        int count = 0;
        for(int i = 0; i < boolHeaders.length; i++){
            if(boolHeaders[i]) {
                updatedTableHeaders[count] = tableHeaders[i];
                tableOrder[count] = i;
                count++;
            }
        }
    }

    public void setTableHeaders(int index, boolean flag) {
        boolHeaders[index] = flag;
        fireTableStructureChanged();
    }

    public void add(Object a) {
        compareShip.add((Ship)a);
        fireTableDataChanged();
    }

    public void remove(int index){
        compareShip.remove(index);
        fireTableDataChanged();
    }

    public boolean inTable(Ship ship){
        return compareShip.contains(ship);
    }

    @Override
    public int getRowCount() {
        return compareShip.size();
    }

    @Override
    public int getColumnCount() {
        int sum = 0;
        for(int i = 0; i < boolHeaders.length; i++){
            if(boolHeaders[i] == true)
                sum++;
        }
        return sum;
    }

    @Override
    public String getColumnName(int col) {
        updateTableHeaders();
        // fireTableStructureChanged();
        return updatedTableHeaders[col];

    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (tableOrder[col]) {
            case 0:
                return compareShip.get(row).getName();

            case 1:
                return compareShip.get(row).getShipType();

            case 2:
                return compareShip.get(row).getFaction();

            case 3:
                return compareShip.get(row).getArmorType();

            case 4:
                return compareShip.get(row).getNumWeapons();

            case 5:
                return compareShip.get(row).getShields();

            case 6:
                return compareShip.get(row).getArmor();

            case 7:
                return compareShip.get(row).getHull();

            case 8:
                return compareShip.get(row).getFleetSupply();

            case 9:
                return compareShip.get(row).getCredits();

            case 10:
                return compareShip.get(row).getMetals();

            case 11:
                return compareShip.get(row).getCrystals();

            case 12:
                return compareShip.get(row).getBuildTime();

            case 13:
                return compareShip.get(row).getXP();

            case 14:
                return compareShip.get(row).getHullRestore();

            case 15:
                return compareShip.get(row).getShieldRestore();

            case 16:
                return compareShip.get(row).getMaxSpeed();

            case 17:
                return compareShip.get(row).getAntimatterSupply();

        }
        throw new RuntimeException();
    }

    /*****************************************************************
     * Gets the info about a selected ship.
     * @param x the ship in the list we want the info from.
     * @return The information about the ship.
     * ***************************************************************/
//    public String getInfo(int x) {
//       return (ship[x].print());
//    }

   // public Ship getExample() {
    //    return example;
   // }

   // public void setExample(Ship example) {
  //      this.example = example;
  //  }

    /*****************************************************************
     * Gets the List of ship names.
     * @return list of the ships' names.
     * ***************************************************************/
//    public String[] getShipName() {
//        return ship.get(a.getShipName);
//    }

    /*****************************************************************
     * sets the list of ship names.
     * @param ships the list of ships.
     * ***************************************************************/
//    //public void setShipName(String[] ships) {
//        this.shipName = ships;
//    }

    /*****************************************************************
     * Gets the list of ships names.
     * @return list of ships names.
     * ***************************************************************/
    public ArrayList<Ship> getShip() {
        return ship;
    }

    /*****************************************************************
     * sets the ship's in the list.
     *
     * ***************************************************************/
//    public void setShip(Ship[] ship) {
//        this.ship = ship;
//    }

//    public String getSearch() {
//        return search;
//    }
//
//    public void setSearch(String search) {
//        this.search = search;
//    }


    public String compare(Ship a, Ship b){
        String message = new String();

        message += compareFleetSupply(a,b);
        message += compareCredits(a,b);
        message += compareMetals(a,b);
        message += compareCrystals(a,b);
        message += compareBuildTimes(a,b);
        message += compareXP(a,b);
        message += compareHull(a,b);
        message += compareHullRestore(a,b);
        message += compareShields(a,b);
        message += compareShieldRestore(a,b);
        message += compareMaxSpeed(a,b);
        message += compareArmor(a,b);
        message += compareAntimatterSupply(a,b);
        message += compareNumWeapons(a,b);

        JOptionPane.showMessageDialog(null,message);

        return message;
    }


    public String compareFleetSupply(Ship a, Ship b){

        if(a.getFleetSupply() > b.getFleetSupply()){
            return "" +a.getName() +" Has a better fleet supply\n";
        }
        else if(a.getFleetSupply() < b.getFleetSupply()){
            return "" +b.getName() +" Has a better fleet supply\n";
        }
        else if(a.getFleetSupply() == b.getFleetSupply()){
            return "Both ships are even in fleet supply\n";
        }
        else{
            return "Error with Fleet Supply Comparison\n";
        }
    }

    public String compareCredits(Ship a, Ship b){
        if(a.getCredits() > b.getCredits()){
            return "" +b.getName() +" Has a better credit cost\n";
        }
        else if(a.getCredits() < b.getCredits()){
            return "" +a.getName() +" Has a better credit cost\n";
        }
        else if(a.getCredits() == b.getCredits()){
            return "Both ships are even in credit cost\n";
        }
        else{
            return "Error with Credit Comparison\n";
        }
    }

    public String compareCrystals(Ship a, Ship b){
        if(a.getCrystals() > b.getCrystals()){
            return "" +b.getName() +" Has a better crystal cost\n";
        }
        else if(a.getCrystals() < b.getCrystals()){
            return "" +a.getName() +" Has a better crystal cost\n";
        }
        else if(a.getCrystals() == b.getCrystals()){
            return "Both ships are even in crystal cost\n";
        }
        else{
            return "Error with Crystal Comparison\n";
        }
    }

    public String compareMetals(Ship a, Ship b){
        if(a.getCrystals() > b.getCrystals()){
            return "" +b.getName() +" Has a better metal cost\n";
        }
        else if(a.getCrystals() < b.getCrystals()){
            return "" +a.getName() +" Has a better metal cost\n";
        }
        else if(a.getCrystals() == b.getCrystals()){
            return "Both ships are even in metal cost\n";
        }
        else{
            return "Error with Metal Comparison\n";
        }
    }

    public String compareBuildTimes(Ship a, Ship b){
        if(a.getBuildTime() > b.getBuildTime()){
            return "" +b.getName() +" Has a better build time\n";
        }
        else if(a.getBuildTime() < b.getBuildTime()){
            return "" +a.getName() +" Has a better build time\n";
        }
        else if(a.getBuildTime() == b.getBuildTime()){
            return "Both ships are even in build time\n";
        }
        else{
            return "Error with build time Comparison\n";
        }
    }

    public String compareXP(Ship a, Ship b){

        if(a.getXP() > b.getXP()){
            return "" +a.getName() +" Has a better XP value\n";
        }
        else if(a.getXP() < b.getXP()){
            return "" +b.getName() +" Has a better XP value\n";
        }
        else if(a.getXP() == b.getXP()){
            return "Both ships are even in XP value\n";
        }
        else{
            return "Error with XP Comparison\n";
        }
    }

    public String compareHull(Ship a, Ship b){

        if(a.getHull() > b.getHull()){
            return "" +a.getName() +" Has a better Hull value\n";
        }
        else if(a.getHull() < b.getHull()){
            return "" +b.getName() +" Has a better Hull value\n";
        }
        else if(a.getHull() == b.getHull()){
            return "Both ships are even in Hull value\n";
        }
        else{
            return "Error with Hull Comparison\n";
        }
    }

    public String compareHullRestore(Ship a, Ship b){

        if(a.getHullRestore() > b.getHullRestore()){
            return "" +a.getName() +" Has a better Hull Restore rate\n";
        }
        else if(a.getHullRestore() < b.getHullRestore()){
            return "" +b.getName() +" Has a better Hull Restore rate\n";
        }
        else if(a.getHullRestore() == b.getHullRestore()){
            return "Both ships are even in Hull Restore rate\n";
        }
        else{
            return "Error with Hull Restore Comparison\n";
        }
    }

    public String compareShields(Ship a, Ship b){

        if(a.getShields() > b.getShields()){
            return "" +a.getName() +" Has a better Shield value\n";
        }
        else if(a.getShields() < b.getShields()){
            return "" +b.getName() +" Has a better Shield value\n";
        }
        else if(a.getShields() == b.getShields()){
            return "Both ships are even in Shield value\n";
        }
        else{
            return "Error with Shield Comparison\n";
        }
    }

    public String compareShieldRestore(Ship a, Ship b){

        if(a.getShieldRestore() > b.getShieldRestore()){
            return "" +a.getName() +" Has a better Shield restore rate\n";
        }
        else if(a.getShieldRestore() < b.getShieldRestore()){
            return "" +b.getName() +" Has a better Shield restore rate\n";
        }
        else if(a.getShieldRestore() == b.getShieldRestore()){
            return "Both ships are even in Shield restore rate\n";
        }
        else{
            return "Error with Shield restore Comparison\n";
        }
    }

    public String compareArmor(Ship a, Ship b){

        if(a.getArmor() > b.getArmor()){
            return "" +a.getName() +" Has a better Armor value\n";
        }
        else if(a.getArmor() < b.getArmor()){
            return "" +b.getName() +" Has a better Armor value\n";
        }
        else if(a.getArmor() == b.getArmor()){
            return "Both ships are even in Armor value\n";
        }
        else{
            return "Error with Armor Comparison\n";
        }
    }


    public String compareMaxSpeed(Ship a, Ship b){

        if(a.getMaxSpeed() > b.getMaxSpeed()){
            return "" +a.getName() +" Has a better Max Speed\n";
        }
        else if(a.getMaxSpeed() < b.getMaxSpeed()){
            return "" +b.getName() +" Has a better Max Speed\n";
        }
        else if(a.getMaxSpeed() == b.getMaxSpeed()){
            return "Both ships are even in Max Speed\n";
        }
        else{
            return "Error with Max Speed Comparison\n";
        }
    }

    public String compareAntimatterSupply(Ship a, Ship b){

        if(a.getAntimatterSupply() > b.getAntimatterSupply()){
            return "" +a.getName() +" Has a better antimatter supply\n";
        }
        else if(a.getAntimatterSupply() < b.getAntimatterSupply()){
            return "" +b.getName() +" Has a better antimatter supply\n";
        }
        else if(a.getAntimatterSupply() == b.getAntimatterSupply()){
            return "Both ships are even in antimatter supply\n";
        }
        else{
            return "Error with antimatter supply Comparison\n";
        }
    }

    public String compareNumWeapons(Ship a, Ship b){

        if(a.getNumWeapons() > b.getNumWeapons()){
            return "" +a.getName() +" Has more weapons\n";
        }
        else if(a.getNumWeapons() < b.getNumWeapons()){
            return "" +b.getName() +" Has more weapons\n";
        }
        else if(a.getNumWeapons() == b.getNumWeapons()){
            return "Both ships have the same number of weapons\n";
        }
        else{
            return "Error with weapon number Comparison\n";
        }
    }

}
