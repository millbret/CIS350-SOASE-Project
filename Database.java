package DatabaseStuff;

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
    public String getInfo(int x) {
       return (ship[x].print());
    }

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
}
