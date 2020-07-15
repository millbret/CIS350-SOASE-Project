package DatabaseStuff;

/******************************************************************************************
 * @author :    Bret Miller, Omar Tiba, Robert Saunders
 * @version :   Version 1 for Summer 2020
 * date:        7/15/2020
 * class:       Ship
 * description: Used for creating and holding all of a ships stats.
 ******************************************************************************************/
public class Ship {

    /** Holds the name of the ship.*/
    private String name;

    /** Holds the name of the type of ship.*/
    private String shipType;

    /** Holds what the armor type of the ship is.*/
    private String armorType;

    /** Holds what faction the ship belongs to.*/
    private String faction;

    /** Holds the fleet supply of the ship.*/
    private int fleetSupply;

    /** Holds the number of credits the ship costs.*/
    private int credits;

    /** Holds the number of metals the ship costs.*/
    private int metals;

    /** Holds the number of crystals the ship costs.*/
    private int crystals;

    /** Holds the time it takes to build the ship.*/
    private int buildTime;

    /** Holds how much XP the ship is worth.*/
    private int XP;

    /** Holds the hull value of the ship.*/
    private int hull;

    /** Holds how fast the hull regenerates over time.*/
    private int hullRestore;

    /** Holds how much shielding the ship has.*/
    private int shields;

    /** Holds how fast the shield restores over time.*/
    private int shieldRestore;

    /** Holds how much armor the ship has.*/
    private int armor;

    /** Holds the damage per second the ship has.*/
    private double DPS;

    /** Holds the max speed of the ship.*/
    private int maxSpeed;

    /** Holds the max antimatter supply the ship has.*/
    private int antimatterSupply;

    /** Holds the number of weapons the ship has.*/
    private int numWeapons;

    /*****************************************************************
     * Constructor  creates a ship with default empty values.
     * ***************************************************************/
    public Ship() {
        this.name = "";
        this.shipType = "";
        this.armorType = "";
        this.faction = "";
        this.fleetSupply = 0;
        this.credits = 0;
        this.metals = 0;
        this.crystals = 0;
        this.buildTime = 0;
        this.XP = 0;
        this.hull = 0;
        this.hullRestore = 0;
        this.shields = 0;
        this.shieldRestore = 0;
        this.armor = 0;
        this.DPS = 0;
        this.maxSpeed = 0;
        this.antimatterSupply = 0;
        this.numWeapons = 0;
    }

    /*****************************************************************
     * Constructor  creates a ship with the specified values given.
     * @param name Name of the ship..
     * @param type The classification of the ship.
     * @param armor Armor type of the ship.
     * @param faction What faction the ship belongs to.
     * @param supply Whe supply cost of the ship.
     * @param credits How many credits the ship costs.
     * @param metals How many metals the ship costs.
     * @param crystals How many crystals the ship costs.
     * @param buildTime How long the ship takes to build in seconds.
     * @param xp How much experience the ship is worth when destroyed.
     * @param hull How many hull points the ship has.
     * @param hullRestore How many hull points the ship restores per second.
     * @param shields How many shield points the ship has.
     * @param shieldRestore How many shield points the ship restores per second.
     * @param armorNum The armor pints of the ship.
     * @param dps How much damage per second the ship can output.
     * @param maxSpd The maximum speed of the ship.
     * @param antimatter How much antimatter the ship can hold.
     * @param weaponNum Number of weapons that the ship has.
     * ***************************************************************/
    public Ship(String name, String type, String armor, String faction, int supply,
                int credits, int metals, int crystals, int buildTime,
                int xp, int hull, int hullRestore, int shields,
                int shieldRestore, int armorNum, double dps,
                int maxSpd, int antimatter, int weaponNum) {
        this.name = name;
        this.shipType = type;
        this.armorType = armor;
        this.faction = faction;
        this.fleetSupply = supply;
        this.credits = credits;
        this.metals = metals;
        this.crystals = crystals;
        this.buildTime = buildTime;
        this.XP = xp;
        this.hull = hull;
        this.hullRestore = hullRestore;
        this.shields = shields;
        this.shieldRestore = shieldRestore;
        this.armor = armorNum;
        this.DPS = dps;
        this.maxSpeed = maxSpd;
        this.antimatterSupply = antimatter;
        this.numWeapons = weaponNum;
    }

    /*****************************************************************
     * Gets a string with all of the values of the ship to display.
     * @return Ship's information for the gui.
     * ***************************************************************/
    public String print() {
        String info;
        return (info = new String("" + this.name +  "\nShip Type: "
                + this.shipType  + "\nFaction: " + this.faction
                + "\nArmor Type: " + this.armorType
                + " Armor: " + this.armor + "\nFleet Supply: " + this.fleetSupply
                + "\nCredits: " + this.credits + " Metals: " + this.metals
                + " Crystals: " + this.crystals + "\nBuild Time: " + this.buildTime
                + " XP: " + this.XP + "\nHull: " + this.hull
                + " Hull Restore: " + this.hullRestore + "\n Shield: " + this.shields
                + " Shield Restore: " + this.shieldRestore + "\nDPS: "
                + this.DPS + " Max Speed: " + this.maxSpeed + "\nAntimatter: "
                + this.antimatterSupply + " Number of Weapons: " + this.numWeapons));
    }

    /*****************************************************************
     * Gets the Ship's name.
     * @return Ship's name.
     * ***************************************************************/
    public String getName() {
        return name;
    }

    /*****************************************************************
     * sets the ship's name.
     * @param name the name that is being set for the ship.
     * ***************************************************************/
    public void setName(String name) {
        this.name = name;
    }

    /*****************************************************************
     * Gets the Ship's type.
     * @return Ship's type.
     * ***************************************************************/
    public String getShipType() {
        return shipType;
    }

    /*****************************************************************
     * sets the ship's type.
     * @param shipType the type of ship that is being set for the ship.
     * ***************************************************************/
    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    /*****************************************************************
     * Gets the Ship's armor type.
     * @return Ship's armor type.
     * ***************************************************************/
    public String getArmorType() {
        return armorType;
    }

    /*****************************************************************
     * sets the ship's armor type.
     * @param armorType the armor type that is being set for the ship.
     * ***************************************************************/
    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    /*****************************************************************
     * Gets the Ship's fleet supply.
     * @return Ship's fleet supply.
     * ***************************************************************/
    public int getFleetSupply() {
        return fleetSupply;
    }

    /*****************************************************************
     * sets the ship's fleet supply.
     * @param fleetSupply the fleet supply that is being set for the ship.
     * ***************************************************************/
    public void setFleetSupply(int fleetSupply) {
        this.fleetSupply = fleetSupply;
    }

    /*****************************************************************
     * Gets the Ship's credit cost.
     * @return Ship's credit cost.
     * ***************************************************************/
    public int getCredits() {
        return credits;
    }

    /*****************************************************************
     * sets the ship's credit cost.
     * @param credits the credit cost that is being set for the ship.
     * ***************************************************************/
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /*****************************************************************
     * Gets the Ship's metal cost.
     * @return Ship's metal cost.
     * ***************************************************************/
    public int getMetals() {
        return metals;
    }

    /*****************************************************************
     * sets the ship's metal cost.
     * @param metals the metal cost that is being set for the ship.
     * ***************************************************************/
    public void setMetals(int metals) {
        this.metals = metals;
    }

    /*****************************************************************
     * Gets the Ship's crystal cost.
     * @return Ship's crystal cost.
     * ***************************************************************/
    public int getCrystals() {
        return crystals;
    }

    /*****************************************************************
     * sets the ship's crystal cost.
     * @param crystals the crystal cost that is being set for the ship.
     * ***************************************************************/
    public void setCrystals(int crystals) {
        this.crystals = crystals;
    }

    /*****************************************************************
     * Gets the Ship's build time.
     * @return Ship's build time.
     * ***************************************************************/
    public int getBuildTime() {
        return buildTime;
    }

    /*****************************************************************
     * sets the ship's build time.
     * @param buildTime the build time that is being set for the ship.
     * ***************************************************************/
    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }

    /*****************************************************************
     * Gets the Ship's XP.
     * @return Ship's XP.
     * ***************************************************************/
    public int getXP() {
        return XP;
    }

    /*****************************************************************
     * sets the ship's XP.
     * @param XP the XP that is being set for the ship.
     * ***************************************************************/
    public void setXP(int XP) {
        this.XP = XP;
    }

    /*****************************************************************
     * Gets the Ship's hull value.
     * @return Ship's hull value.
     * ***************************************************************/
    public int getHull() {
        return hull;
    }

    /*****************************************************************
     * sets the ship's hull value.
     * @param hull the hull value that is being set for the ship.
     * ***************************************************************/
    public void setHull(int hull) {
        this.hull = hull;
    }

    /*****************************************************************
     * Gets the Ship's hull restore.
     * @return Ship's hull restore.
     * ***************************************************************/
    public int getHullRestore() {
        return hullRestore;
    }

    /*****************************************************************
     * sets the ship's hull restore.
     * @param hullRestore the hull restore that is being set for the ship.
     * ***************************************************************/
    public void setHullRestore(int hullRestore) {
        this.hullRestore = hullRestore;
    }

    /*****************************************************************
     * Gets the Ship's shield value.
     * @return Ship's shield value.
     * ***************************************************************/
    public int getShields() {
        return shields;
    }

    /*****************************************************************
     * sets the ship's shield value.
     * @param shields the shield value that is being set for the ship.
     * ***************************************************************/
    public void setShields(int shields) {
        this.shields = shields;
    }

    /*****************************************************************
     * Gets the Ship's shield restore.
     * @return Ship's shield restore.
     * ***************************************************************/
    public int getShieldRestore() {
        return shieldRestore;
    }

    /*****************************************************************
     * sets the ship's shield restore.
     * @param shieldRestore the shield restore that is being set for the ship.
     * ***************************************************************/
    public void setShieldRestore(int shieldRestore) {
        this.shieldRestore = shieldRestore;
    }

    /*****************************************************************
     * Gets the Ship's DPS.
     * @return Ship's DPS.
     * ***************************************************************/
    public double getDPS() {
        return DPS;
    }

    /*****************************************************************
     * sets the ship's DPS.
     * @param DPS the DPS that is being set for the ship.
     * ***************************************************************/
    public void setDPS(double DPS) {
        this.DPS = DPS;
    }

    /*****************************************************************
     * Gets the Ship's max speed.
     * @return Ship's max speed.
     * ***************************************************************/
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /*****************************************************************
     * sets the ship's max speed.
     * @param maxSpeed the max speed that is being set for the ship.
     * ***************************************************************/
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /*****************************************************************
     * Gets the Ship's armor value.
     * @return Ship's armor value.
     * ***************************************************************/
    public int getArmor() {
        return armor;
    }

    /*****************************************************************
     * sets the ship's armor value.
     * @param armor the armor value that is being set for the ship.
     * ***************************************************************/
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /*****************************************************************
     * Gets the Ship's antimatter supply.
     * @return Ship's antimatter supply.
     * ***************************************************************/
    public int getAntimatterSupply() {
        return antimatterSupply;
    }

    /*****************************************************************
     * sets the ship's antimatter supply.
     * @param antimatterSupply the antimatter supply that is being set for the ship.
     * ***************************************************************/
    public void setAntimatterSupply(int antimatterSupply) {
        this.antimatterSupply = antimatterSupply;
    }

    /*****************************************************************
     * Gets the Ship's faction.
     * @return Ship's faction.
     * ***************************************************************/
    public String getFaction() {
        return faction;
    }

    /*****************************************************************
     * sets the ship's faction.
     * @param faction the faction that is being set for the ship.
     * ***************************************************************/
    public void setFaction(String faction) {
        this.faction = faction;
    }

    /*****************************************************************
     * Gets the Ship's number of weapons.
     * @return Ship's number of weapons.
     * ***************************************************************/
    public int getNumWeapons() {
        return numWeapons;
    }

    /*****************************************************************
     * sets the ship's number of weapons.
     * @param numWeapons the number of weapons that is being set for the ship.
     * ***************************************************************/
    public void setNumWeapons(int numWeapons) {
        this.numWeapons = numWeapons;
    }
}
