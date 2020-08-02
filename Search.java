package DatabaseStuff;

/******************************************************************************************
 * @author :    Bret Miller, Omar Tiba, Robert Saunders
 * @version :   Version 2 for Summer 2020
 * date:        8/2/2020
 * class:       Search
 * description: Function that searches through file directory and finds all files with .Entity
 * and adds them to a list to be searched through to create a filled ArrayList of ships.
 ******************************************************************************************/
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import static java.lang.Double.parseDouble;


/*****************************************************************
 * Constructor  creates a ship to then fill getting the info from
 * files that contain ship related info.
 * ***************************************************************/
    public class Search {


        /** Makes a ship to then fill later.**/
        private static DatabaseStuff.Ship Ship;


    /******************************************************************************************
     * Description: Checks if the given move is a valid move
     *
     * @param shipList an ArrayList that gets filled with ships after they are filled with info.
     * @throws IOException exception for if the files it is looking for are not there.
     *******************************************************************************************/
        public static void storeShips(ArrayList<Ship> shipList) throws IOException {

            /**Gets the current directory of the Search.java file. **/
            File dir = new File(System.getProperty("user.dir"));

            /**A String array for holding the directory names **/
            String[] childs = dir.list();
            String pathName = dir.getPath();

            /**Creates a file called fileNames.txt to store the list of all file names. **/
            File myObj = new File(pathName + "/src/DatabaseStuff/fileNames.txt");
            myObj.createNewFile();

            /**A counter for keeping track of the number of values that have been filled in each ship. **/
            int counter = 0;

            /**Booleans for keeping track of if a key word was found so it knows to come back on the next loop **/
            boolean nextPassName = false;
            boolean nextPassCred = false;
            boolean nextPassMetal = false;
            boolean nextPassCrystal = false;
            boolean nextPassSlot = false;
            boolean nextPassBuild = false;
            boolean nextPassMaxHull = false;
            boolean nextPassMaxShield = false;
            boolean nextPassHullRestore = false;
            boolean nextPassShieldRestore = false;
            boolean nextPassArmor = false;
            boolean nextPassMaxAnti = false;
            boolean nextPassNumWeapons = false;
            boolean nextPassMaxSpeed = false;
            boolean nextPassXP = false;
            boolean nextPassArmorType = false;

            /**Booleans for keeping track of what values where input into the Ship object. **/
            boolean notDoneName = true;
            boolean notDoneCred = true;
            boolean notDoneMetal = true;
            boolean notDoneCrystal = true;
            boolean notDoneSlotCount = true;
            boolean notDoneBuildTime = true;
            boolean notDoneMaxHullPoints = true;
            boolean notDoneMaxShieldPoints = true;
            boolean notDoneHullPointRestoreRate = true;
            boolean notDoneShieldPointRestoreRate = true;
            boolean notDoneArmor = true;
            boolean notDoneMaxAntiMatter = true;
            boolean notDoneNumWeapons = true;
            boolean notDoneMaxSpeed = true;
            boolean notDoneXP = true;
            boolean notDoneArmorType = true;
            boolean notDoneFaction = true;
            boolean notDoneType = true;

            /**Writes all the names into fileNames.txt. **/
            FileWriter myWriter = new FileWriter(pathName + "/src/DatabaseStuff/fileNames.txt");
            for (String child : childs) {
                myWriter.write(child);
                myWriter.write("\n");
            }
            myWriter.close();

            /**Stores the file name gotten from fileNames.txt. **/
            String s1;
            File f1 = new File(pathName+"/src/DatabaseStuff/fileNames.txt");

            /**Reads file names from fileNames.txt.**/
            FileReader fr1 = new FileReader(f1);
            BufferedReader br1 = new BufferedReader(fr1);

            /**While loop to keep going untill all lines in fileNames.txt have been gone through. **/
            while((s1 = br1.readLine()) != null) {

                /**A Ship object to fill with info **/
               Ship = new DatabaseStuff.Ship();

                /**If statement to check if file name from fileNames.txt is a file type that contains ship info.**/
                if (s1.contains("FRIGATE") || s1.contains("CAPITAL")) {

                    /**Makes new file with the name gotten from fileNames.txt **/
                    File f2 = new File(s1);
                    String[] words = null;
                    FileReader fr2 = new FileReader(f2);
                    BufferedReader br2 = new BufferedReader(fr2);

                    /**String to hold a the line read from the current file **/
                    String s2;

                    /**While loop to read through every line in the current file **/
                    while ((s2 = br2.readLine()) != null) {

                        /**Separates the line using spaces, tabs, and underscores as delimiters **/
                        words = s2.split("\"|\\s|\\t|\\_" );

                        /**For loop to go through all the words gotten from splitting the line up. **/
                        for (String word : words) {
                            String[] fileName = words;



                            if (word.equals("UNSC") && notDoneFaction) {
                                Ship.setFaction(word);
                                notDoneFaction = false;
                                counter++;
                            }

                            if (word.equals("Cov") && notDoneFaction) {
                                Ship.setFaction(word);
                                notDoneFaction = false;
                                counter++;
                            }

                            if (word.equals("CapitalShip") && notDoneType) {
                                Ship.setShipType(word);
                                notDoneType = false;
                                counter++;
                            }

                            if (word.equals("Frigate") && notDoneType) {
                                Ship.setShipType(word);
                                notDoneType = false;
                                counter++;
                            }

                            if (word.equals("NameStringID") || (nextPassName && notDoneName)&& !word.equals("")
                                    &&!word.equals("FRIGATE") &&!word.equals("CAPITALSHIP")) {
                                String name = word.replaceAll("UNSC|COV", "");
                                if (nextPassName) {
                                    Ship.setName(name);
                                    notDoneName = false;
                                    counter++;

                                }

                                nextPassName = true;

                                if (!notDoneName) {
                                    nextPassName = false;
                                }

                            }

                            if (word.equals("credits") || (nextPassCred && notDoneCred)) {

                                if (nextPassCred) {
                                    Ship.setCredits((int) Math.round(parseDouble(word)));
                                    notDoneCred = false;
                                    counter++;

                                }

                                nextPassCred = true;

                                if (!notDoneCred) {
                                    nextPassCred = false;
                                }
                            }

                            if (word.equals("metal") || (nextPassMetal && notDoneMetal)) {

                                if (nextPassMetal) {
                                    Ship.setMetals((int) Math.round(parseDouble(word)));
                                    notDoneMetal = false;
                                    counter++;

                                }

                                nextPassMetal = true;

                                if (!notDoneMetal) {
                                    nextPassMetal = false;
                                }
                            }

                            if (word.equals("crystal") || (nextPassCrystal && notDoneCrystal)) {

                                if (nextPassCrystal) {
                                    Ship.setCrystals((int) Math.round(parseDouble(word)));
                                    notDoneCrystal = false;
                                    counter++;

                                }
                                nextPassCrystal = true;

                                if (!notDoneCrystal) {
                                    nextPassCrystal = false;
                                }

                            }

                            if (word.equals("slotCount") || (nextPassSlot && notDoneSlotCount)) {
                                if (nextPassSlot) {
                                    Ship.setFleetSupply((int) Math.round(parseDouble(word)));
                                    notDoneSlotCount = false;
                                    counter++;

                                }

                                nextPassSlot = true;

                                if (!notDoneSlotCount) {
                                    nextPassSlot = false;
                                }

                            }

                            if (word.equals("BuildTime") || (nextPassBuild && notDoneBuildTime)) {
                                if (nextPassBuild) {
                                    Ship.setBuildTime((int) Math.round(parseDouble(word)));
                                    notDoneBuildTime = false;
                                    counter++;

                                }
                                nextPassBuild = true;

                                if (!notDoneBuildTime) {
                                    nextPassBuild = false;
                                }

                            }

                            if (word.equals("ExperiencePointsForDestroying") || (Ship.getShipType().equals("CapitalShip")
                                    && Ship.getXP() != 50) || (nextPassXP && notDoneXP))
                            {

                                if (nextPassXP) {
                                    Ship.setXP((int) Math.round(parseDouble(word)));
                                    notDoneXP = false;
                                    counter++;

                                }
                                nextPassXP = true;

                                if (Ship.getShipType().equals("CapitalShip")) {
                                    Ship.setXP(50);
                                    notDoneXP = false;
                                    counter++;

                                }

                                if (!notDoneXP) {
                                    nextPassXP = false;
                                }
                            }

                            if (word.equals("MaxHullPoints") || (nextPassMaxHull && notDoneMaxHullPoints)
                                    && !word.equals("")&&!word.equals("StartValue")) {

                                if (nextPassMaxHull) {
                                    Ship.setHull((int) Math.round(parseDouble(word)));
                                    notDoneMaxHullPoints = false;
                                    counter++;

                                }
                                nextPassMaxHull = true;

                                if (!notDoneMaxHullPoints) {
                                    nextPassMaxHull = false;
                                }
                            }

                            if (word.equals("MaxShieldPoints") || (nextPassMaxShield && notDoneMaxShieldPoints)
                                    && !word.equals("")&&!word.equals("StartValue")) {
                                if (nextPassMaxShield) {
                                    Ship.setShields((int) Math.round(parseDouble(word)));
                                    notDoneMaxShieldPoints = false;
                                    counter++;

                                }
                                nextPassMaxShield = true;

                                if (!notDoneMaxShieldPoints) {
                                    nextPassMaxShield = false;
                                }
                            }

                            if (word.equals("HullPointRestoreRate") || (nextPassHullRestore
                                    && notDoneHullPointRestoreRate)&& !word.equals("")&&!word.equals("StartValue")) {
                                if (nextPassHullRestore) {
                                    Ship.setHullRestore((int) Math.round(parseDouble(word)));
                                    notDoneHullPointRestoreRate = false;
                                    counter++;

                                }
                                nextPassHullRestore = true;

                                if (!notDoneHullPointRestoreRate) {
                                    nextPassHullRestore = false;
                                }
                            }

                            if (word.equals("ShieldPointRestoreRate") || (nextPassShieldRestore
                                    && notDoneShieldPointRestoreRate)&& !word.equals("")&&!word.equals("StartValue")) {
                                if (nextPassShieldRestore) {
                                    Ship.setShieldRestore((int) Math.round(parseDouble(word)));
                                    notDoneShieldPointRestoreRate = false;
                                    counter++;

                                }
                                nextPassShieldRestore = true;

                                if (!notDoneShieldPointRestoreRate) {
                                    nextPassShieldRestore = false;
                                }
                            }

                            if (word.equals("ArmorPointsFromExperience") || word.equals("BaseArmorPoints")
                                    || (nextPassArmor && notDoneArmor)&&!word.equals("")&& !word.equals("StartValue")) {
                                if (nextPassArmor) {
                                    Ship.setArmor((int) Math.round(parseDouble(word)));
                                    notDoneArmor = false;
                                    counter++;

                                }
                                nextPassArmor = true;

                                if (!notDoneArmor) {
                                    nextPassArmor = false;
                                }
                            }

                            if (word.equals("MaxAntiMatter") || (nextPassMaxAnti && notDoneMaxAntiMatter)
                                    && !word.equals("")&&!word.equals("StartValue")) {
                                if (nextPassMaxAnti) {
                                    Ship.setAntimatterSupply((int) Math.round(parseDouble(word)));
                                    notDoneMaxAntiMatter = false;
                                    counter++;

                                }
                                nextPassMaxAnti = true;

                                if (!notDoneMaxAntiMatter) {
                                    nextPassMaxAnti = false;
                                }
                            }

                            if (word.equals("armorType")|| (nextPassArmorType && notDoneArmorType
                                    && !word.equals(""))) {
                                if (nextPassArmorType) {
                                    Ship.setArmorType(word);
                                    notDoneArmorType = false;
                                    counter++;

                                }
                                nextPassArmorType = true;

                                if (!notDoneArmorType) {
                                    nextPassArmorType = false;
                                }
                            }

                            if (word.equals("NumWeapons") || (nextPassNumWeapons && notDoneNumWeapons)) {
                                if (nextPassNumWeapons) {
                                    Ship.setNumWeapons((int) Math.round(parseDouble(word)));
                                    notDoneNumWeapons = false;
                                    counter++;

                                }
                                nextPassNumWeapons = true;

                                if (!notDoneNumWeapons) {
                                    nextPassNumWeapons = false;
                                }
                            }

                            if (word.equals("maxSpeedLinear") || (nextPassMaxSpeed && notDoneMaxSpeed)) {
                                if (nextPassMaxSpeed) {
                                    Ship.setMaxSpeed((int) Math.round(parseDouble(word)));
                                    notDoneMaxSpeed = false;
                                    counter++;

                                }
                                nextPassMaxSpeed = true;

                                if (!notDoneMaxSpeed) {
                                    nextPassMaxSpeed = false;
                                }

                            }


                        }




                    }

                    /**Closes the currently open file. **/
                    fr2.close();

                    /**Checks to see if all the info has been put into the Ship. **/
                    if(counter == 18){

                        /**Adds the filled Ship into the ShipList. **/
                        shipList.add(Ship);

                        /**Resets the counter in preparation of filling a new Ship object. **/
                        counter=0;

                        /**Resets all Booleans in preparation of filling a new Ship object. **/
                        nextPassName = false;
                        nextPassCred = false;
                        nextPassMetal = false;
                        nextPassCrystal = false;
                        nextPassSlot = false;
                        nextPassBuild = false;
                        nextPassMaxHull = false;
                        nextPassMaxShield = false;
                        nextPassHullRestore = false;
                        nextPassShieldRestore = false;
                        nextPassArmor = false;
                        nextPassMaxAnti = false;
                        nextPassNumWeapons = false;
                        nextPassMaxSpeed = false;
                        nextPassXP = false;
                        nextPassArmorType = false;
                        notDoneName = true;
                        notDoneCred = true;
                        notDoneMetal = true;
                        notDoneCrystal = true;
                        notDoneSlotCount = true;
                        notDoneBuildTime = true;
                        notDoneMaxHullPoints = true;
                        notDoneMaxShieldPoints = true;
                        notDoneHullPointRestoreRate = true;
                        notDoneShieldPointRestoreRate = true;
                        notDoneArmor = true;
                        notDoneMaxAntiMatter = true;
                        notDoneNumWeapons = true;
                        notDoneMaxSpeed = true;
                        notDoneXP = true;
                        notDoneArmorType = true;
                        notDoneFaction = true;
                        notDoneType = true;
                    }
                }
            }

            /**Closes the fileNames.txt file. **/
            fr1.close();
        }


    }
