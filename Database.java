package DatabaseStuff;

import javax.swing.*;

/******************************************************************************************
 * @author :    Bret Miller, Omar Tiba, Robert Saunders
 * @version :   Version 1 for Summer 2020
 * date:        7/15/2020
 * class:       Database
 * description: Holds all of the ships to be displayed by the GUI for users.
 ******************************************************************************************/

class Database {

    /** Holds the list of ship names.*/
    private String[] shipName;

    /** Holds the list of ships.*/
    private Ship[] ship;

//    private String search;

    /*****************************************************************
     * Constructor  creates a database including ships and.
     * a two lists one containing the names of the ships and another.
     * that contains the ships themselves.
     * ***************************************************************/
    public Database() {

        Ship paris = new Ship("Paris", "Frigate", "Light", "UNSC", 5, 355,
                40, 5, 10, 5, 1800, 3, 0, 0,
                4, 22, 700, 0, 2);
        Ship punic = new Ship("Punic", "Carrier", "VeryHeavy", "UNSC", 75, 5500,
                1000, 1150, 110, 50,
                16000, 24, 0, 0,
                14, 269, 500, 24, 5);
        Ship marathon = new Ship("Marathon", "Cruiser", "Medium", "UNSC", 25, 950,
                250, 90, 45, 50, 6000, 10, 0, 0,
                7, 132, 600, 3, 4);
        Ship CCS = new Ship("CCS", "Cruiser", "Medium", "Covenant", 21, 1650,
                220, 90, 35, 21, 4400, 5, 12000, 600,
                3, 130, 700, 16, 3);
        Ship CAS = new Ship("CAS", "Carrier", "VeryHeavy", "Covenant", 100, 10000,
                2600, 1850, 120, 50, 14000, 15, 50000, 2500,
                8, 480, 600, 62, 5);
        ship = new Ship[]{paris, punic, marathon, CCS, CAS};
        shipName = new String[]{"Paris", "Punic", "Marathon", "CCS", "CAS"};
//        this.search = "";
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
    public String[] getShipName() {
        return shipName;
    }

    /*****************************************************************
     * sets the list of ship names.
     * @param ships the list of ships.
     * ***************************************************************/
    public void setShipName(String[] ships) {
        this.shipName = ships;
    }

    /*****************************************************************
     * Gets the list of ships names.
     * @return list of ships names.
     * ***************************************************************/
    public Ship[] getShip() {
        return ship;
    }

    /*****************************************************************
     * sets the ship's in the list.
     * @param ship the ships going in the list.
     * ***************************************************************/
    public void setShip(Ship[] ship) {
        this.ship = ship;
    }

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
        message += compareArmor(a,b);
        message += compareDPS(a,b);
        message += compareMaxSpeed(a,b);
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

    public String compareDPS(Ship a, Ship b){

        if(a.getDPS() > b.getDPS()){
            return "" +a.getName() +" Has a better DPS\n";
        }
        else if(a.getDPS() < b.getDPS()){
            return "" +b.getName() +" Has a better DPS\n";
        }
        else if(a.getDPS() == b.getDPS()){
            return "Both ships are even in DPS\n";
        }
        else{
            return "Error with DPS Comparison\n";
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
