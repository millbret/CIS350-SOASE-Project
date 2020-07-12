package DatabaseStuff;

public class Database {

    /******************************************
     * Insert all the ships as object ship
     ******************************************/
    private Ship example;
    private Ship example2;
    private String[] shipName = {"example", "hi"};
    private Ship[] ship;

    private String search;

    public Database() {
        /*************************************************
         * Insert all of the values of the ships in here
         ************************************************/
        this.example = new Ship();
        this.example2 = new Ship();
        ship = new Ship[]{example, example2};
        this.search = "";
    }

    public String getInfo(int x){
       return (ship[x].print());
    }

    public Ship getExample() {
        return example;
    }

    public void setExample(Ship example) {
        this.example = example;
    }

    public String[] getShipName() {
        return shipName;
    }

    public void setShipName(String[] ships) {
        this.shipName = ships;
    }

    public Ship[] getShip() {
        return ship;
    }

    public void setShip(Ship[] ship) {
        this.ship = ship;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
