package DatabaseStuff;

public class Ship {

    private String name;

    private String shipType;

    private String armorType;

    private String faction;

    private int fleetSupply;

    private int credits;

    private int metals;

    private int crystals;

    private int buildTime;

    private int XP;

    private int hull;

    private int hullRestore;

    private int shields;

    private int shieldRestore;

    private int armor;

    private double DPS;

    private int maxSpeed;

    private int antimatterSupply;

    private int numWeapons;

    public Ship(){
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


    public Ship(String name, String type, String armor, String faction, int supply,
                int credits, int metals, int crystals, int buildtime, int xp, int hull, int hullrestore, int shields,
                int shieldrestore, int armorNum, double dps, int maxSpd, int antimatter, int weaponNum){
        this.name = name;
        this.shipType = type;
        this.armorType = armor;
        this.faction = faction;
        this.fleetSupply = supply;
        this.credits = credits;
        this.metals = metals;
        this.crystals = crystals;
        this.buildTime = buildtime;
        this.XP = xp;
        this.hull = hull;
        this.hullRestore = hullrestore;
        this.shields = shields;
        this.shieldRestore = shieldrestore;
        this.armor = armorNum;
        this.DPS = dps;
        this.maxSpeed = maxSpd;
        this.antimatterSupply = antimatter;
        this.numWeapons = weaponNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public int getFleetSupply() {
        return fleetSupply;
    }

    public void setFleetSupply(int fleetSupply) {
        this.fleetSupply = fleetSupply;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMetals() {
        return metals;
    }

    public void setMetals(int metals) {
        this.metals = metals;
    }

    public int getCrystals() {
        return crystals;
    }

    public void setCrystals(int crystals) {
        this.crystals = crystals;
    }

    public int getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }

    public int getHullRestore() {
        return hullRestore;
    }

    public void setHullRestore(int hullRestore) {
        this.hullRestore = hullRestore;
    }

    public int getShields() {
        return shields;
    }

    public void setShields(int shields) {
        this.shields = shields;
    }

    public int getShieldRestore() {
        return shieldRestore;
    }

    public void setShieldRestore(int shieldRestore) {
        this.shieldRestore = shieldRestore;
    }

    public double getDPS() {
        return DPS;
    }

    public void setDPS(double DPS) {
        this.DPS = DPS;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAntimatterSupply() {
        return antimatterSupply;
    }

    public void setAntimatterSupply(int antimatterSupply) {
        this.antimatterSupply = antimatterSupply;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public int getNumWeapons() {
        return numWeapons;
    }

    public void setNumWeapons(int numWeapons) {
        this.numWeapons = numWeapons;
    }
}
