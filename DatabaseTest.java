package DatabaseStuff;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {

    private Database database;

    public DatabaseTest(){

    }

    @Before
    public void setUp(){
        database = new Database();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testChangingName(){
        Ship testShip = new Ship();

        testShip.setName("Test");
        Assert.assertEquals("Test", testShip.getName());
    }

    @Test
    public void testChangingType(){
        Ship testShip = new Ship();

        testShip.setShipType("Test");
        Assert.assertEquals("Test", testShip.getShipType());
    }

    @Test
    public void testChangingArmorType(){
        Ship testShip = new Ship();

        testShip.setArmorType("Test");
        Assert.assertEquals("Test", testShip.getArmorType());
    }

    @Test
    public void testChangingFaction(){
        Ship testShip = new Ship();

        testShip.setFaction("Test");
        Assert.assertEquals("Test", testShip.getFaction());
    }

    @Test
    public void testChangingFleetSupply(){
        Ship testShip = new Ship();

        testShip.setFleetSupply(0);
        Assert.assertEquals(0, testShip.getFleetSupply());
    }

    @Test
    public void testChangingCredits(){
        Ship testShip = new Ship();

        testShip.setCredits(0);
        Assert.assertEquals(0, testShip.getCredits());
    }

    @Test
    public void testChangingMetals(){
        Ship testShip = new Ship();

        testShip.setMetals(0);
        Assert.assertEquals(0, testShip.getMetals());
    }

    @Test
    public void testChangingCrystals(){
        Ship testShip = new Ship();

        testShip.setCrystals(0);
        Assert.assertEquals(0, testShip.getCrystals());
    }

    @Test
    public void testChangingBuildTime(){
        Ship testShip = new Ship();

        testShip.setBuildTime(0);
        Assert.assertEquals(0, testShip.getBuildTime());
    }

    @Test
    public void testChangingXP(){
        Ship testShip = new Ship();

        testShip.setXP(0);
        Assert.assertEquals(0, testShip.getXP());
    }

    @Test
    public void testChangingHull(){
        Ship testShip = new Ship();

        testShip.setHull(0);
        Assert.assertEquals(0, testShip.getHull());
    }

    @Test
    public void testChangingHullRestore(){
        Ship testShip = new Ship();

        testShip.setHullRestore(0);
        Assert.assertEquals(0, testShip.getHullRestore());
    }

    @Test
    public void testChangingShields(){
        Ship testShip = new Ship();

        testShip.setShields(0);
        Assert.assertEquals(0, testShip.getShields());
    }

    @Test
    public void testChangingShieldRestore(){
        Ship testShip = new Ship();

        testShip.setShieldRestore(0);
        Assert.assertEquals(0, testShip.getShieldRestore());
    }

    @Test
    public void testChangingArmor(){
        Ship testShip = new Ship();

        testShip.setArmor(0);
        Assert.assertEquals(0, testShip.getArmor());
    }

    @Test
    public void testChangingDPS(){
        Ship testShip = new Ship();

        testShip.setDPS(0);
        Assert.assertEquals(0, testShip.getDPS(),0.01);
    }

    @Test
    public void testChangingMaxSpeed(){
        Ship testShip = new Ship();

        testShip.setMaxSpeed(0);
        Assert.assertEquals(0, testShip.getMaxSpeed());
    }

    @Test
    public void testChangingAntimatterSupply(){
        Ship testShip = new Ship();

        testShip.setAntimatterSupply(0);
        Assert.assertEquals(0, testShip.getAntimatterSupply());
    }

    @Test
    public void testChangingNumWeapons(){
        Ship testShip = new Ship();

        testShip.setNumWeapons(0);
        Assert.assertEquals(0, testShip.getNumWeapons());
    }

    @Test
    public void testPrinting(){
        Assert.assertEquals("Paris\n" +
                "Ship Type: Frigate\n" +
                "Faction: UNSC\n" +
                "Armor Type: Light Armor: 4\n" +
                "Fleet Supply: 5\n" +
                "Credits: 355 Metals: 40 Crystals: 5\n" +
                "Build Time: 10 XP: 5\n" +
                "Hull: 1800 Hull Restore: 3\n" +
                " Shield: 0 Shield Restore: 0\n" +
                "DPS: 22.0 Max Speed: 700\n" +
                "Antimatter: 0 Number of Weapons: 2", database.getShip()[0].print());
    }

    @Test
    public void testComparisons1(){

        Assert.assertEquals("Punic Has a better fleet supply\n" +
                "Paris Has a better credit cost\n" +
                "Paris Has a better metal cost\n" +
                "Paris Has a better crystal cost\n" +
                "Paris Has a better build time\n" +
                "Punic Has a better XP value\n" +
                "Punic Has a better Hull value\n" +
                "Punic Has a better Hull Restore rate\n" +
                "Both ships are even in Shield value\n" +
                "Both ships are even in Shield restore rate\n" +
                "Punic Has a better Armor value\n" +
                "Punic Has a better DPS\n" +
                "Paris Has a better Max Speed\n" +
                "Punic Has a better antimatter supply\n" +
                "Punic Has more weapons\n",database.compare(database.getShip()[0],database.getShip()[1]));

    }

    @Test
    public void testComparisons2(){
        Assert.assertEquals("Punic Has a better fleet supply\n" +
                "Paris Has a better credit cost\n" +
                "Paris Has a better metal cost\n" +
                "Paris Has a better crystal cost\n" +
                "Paris Has a better build time\n" +
                "Punic Has a better XP value\n" +
                "Punic Has a better Hull value\n" +
                "Punic Has a better Hull Restore rate\n" +
                "Both ships are even in Shield value\n" +
                "Both ships are even in Shield restore rate\n" +
                "Punic Has a better Armor value\n" +
                "Punic Has a better DPS\n" +
                "Paris Has a better Max Speed\n" +
                "Punic Has a better antimatter supply\n" +
                "Punic Has more weapons\n", database.compare(database.getShip()[1],database.getShip()[0]));
    }

    @Test
    public void testComparisons3(){
        Assert.assertEquals("Both ships are even in fleet supply\n" +
                "Both ships are even in credit cost\n" +
                "Both ships are even in metal cost\n" +
                "Both ships are even in crystal cost\n" +
                "Both ships are even in build time\n" +
                "Both ships are even in XP value\n" +
                "Both ships are even in Hull value\n" +
                "Both ships are even in Hull Restore rate\n" +
                "Both ships are even in Shield value\n" +
                "Both ships are even in Shield restore rate\n" +
                "Both ships are even in Armor value\n" +
                "Both ships are even in DPS\n" +
                "Both ships are even in Max Speed\n" +
                "Both ships are even in antimatter supply\n" +
                "Both ships have the same number of weapons\n",database.compare(database.getShip()[0],database.getShip()[0]));
    }

    @Test
    public void testComparisons4(){

        Assert.assertEquals("CAS Has a better fleet supply\n" +
                "CCS Has a better credit cost\n" +
                "CCS Has a better metal cost\n" +
                "CCS Has a better crystal cost\n" +
                "CCS Has a better build time\n" +
                "CAS Has a better XP value\n" +
                "CAS Has a better Hull value\n" +
                "CAS Has a better Hull Restore rate\n" +
                "CAS Has a better Shield value\n" +
                "CAS Has a better Shield restore rate\n" +
                "CAS Has a better Armor value\n" +
                "CAS Has a better DPS\n" +
                "CCS Has a better Max Speed\n" +
                "CAS Has a better antimatter supply\n" +
                "CAS Has more weapons\n",database.compare(database.getShip()[3],database.getShip()[4]));

    }

    @Test
    public void testComparisons5(){

        Assert.assertEquals("CAS Has a better fleet supply\n" +
                "CCS Has a better credit cost\n" +
                "CCS Has a better metal cost\n" +
                "CCS Has a better crystal cost\n" +
                "CCS Has a better build time\n" +
                "CAS Has a better XP value\n" +
                "CAS Has a better Hull value\n" +
                "CAS Has a better Hull Restore rate\n" +
                "CAS Has a better Shield value\n" +
                "CAS Has a better Shield restore rate\n" +
                "CAS Has a better Armor value\n" +
                "CAS Has a better DPS\n" +
                "CCS Has a better Max Speed\n" +
                "CAS Has a better antimatter supply\n" +
                "CAS Has more weapons\n",database.compare(database.getShip()[4],database.getShip()[3]));
    }

    @Test
    public void testInfo(){
        Assert.assertEquals(database.getShip()[0].print(),database.getInfo(0));
    }

    @Test
    public void testSetShips(){
        Ship testShip = new Ship();
        Ship[] test = {testShip};
        database.setShip(test);
        Assert.assertArrayEquals(test, database.getShip());
    }

    @Test
    public void testSetNames(){
        String[] testNames = {"Hi", "Tests"};
        database.setShipName(testNames);
        Assert.assertArrayEquals(testNames,database.getShipName());
    }



}
