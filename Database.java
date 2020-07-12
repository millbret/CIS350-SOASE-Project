package DatabaseStuff;

public class Database {

    /******************************************
     * Insert all the ships as object ship
     ******************************************/
    private Ship example;
    private String[] ships = {"example"};
    private Ship[] ship = {example};

    private String search;

    public Database() {
        /*************************************************
         * Insert all of the values of the ships in here
         ************************************************/
        this.example = new Ship();
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

    public String[] getShips() {
        return ships;
    }

    public void setShips(String[] ships) {
        this.ships = ships;
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
