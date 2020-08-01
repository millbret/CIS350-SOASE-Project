package DatabaseStuff;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;



    public class Search {

        private static DatabaseStuff.Ship Ship;
        public static void storeShips(ArrayList<Ship> shipList) throws IOException {

            File dir = new File(System.getProperty("user.dir"));
            String[] childs = dir.list();
            File myObj = new File("C:/Users/Omar Tiba/IdeaProjects/CIS350/src/DatabaseStuff/fileNames.txt");
            myObj.createNewFile();
            int counter = 0;
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

            FileWriter myWriter = new FileWriter("C:/Users/Omar Tiba/IdeaProjects/CIS350/src/DatabaseStuff/fileNames.txt");
            for (String child : childs) {
                myWriter.write(child);
                myWriter.write("\n");
            }
            myWriter.close();
            String s1;
            File f1 = new File("C:/Users/Omar Tiba/IdeaProjects/CIS350/src/DatabaseStuff/fileNames.txt"); //Creation of File Descriptor for input file
            FileReader fr1 = new FileReader(f1);  //Creation of File Reader object
            BufferedReader br1 = new BufferedReader(fr1); //Creation of Buffered
            while((s1 = br1.readLine()) != null) {

               Ship = new DatabaseStuff.Ship();


                if (s1.contains("FRIGATE") || s1.contains("CAPITAL")) {
                    File f2 = new File(s1);
                    String[] words = null;  //Initialize the word Array
                    FileReader fr2 = new FileReader(f2);  //Creation of File Reader object
                    BufferedReader br2 = new BufferedReader(fr2); //Creation of BufferedReader object
                    String s2;
                    while ((s2 = br2.readLine()) != null) {  //Reading Content from the file

                        words = s2.split("\"|\\s|\\t|\\_" );//Split the word using quotation marks

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
                                String name = word.replaceAll("UNSC", "");
                                name = word.replaceAll( "COV", "");
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

                            if (word.equals("ExperiencePointsForDestroying") || (Ship.getShipType().equals("CapitalShip") && Ship.getXP() != 50) || (nextPassXP && notDoneXP))
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

                            if (word.equals("MaxHullPoints") || (nextPassMaxHull && notDoneMaxHullPoints) && !word.equals("")&&!word.equals("StartValue")) {

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

                            if (word.equals("MaxShieldPoints") || (nextPassMaxShield && notDoneMaxShieldPoints)&& !word.equals("")&&!word.equals("StartValue")) {
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

                            if (word.equals("HullPointRestoreRate") || (nextPassHullRestore && notDoneHullPointRestoreRate)&& !word.equals("")&&!word.equals("StartValue")) {
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

                            if (word.equals("ShieldPointRestoreRate") || (nextPassShieldRestore && notDoneShieldPointRestoreRate)&& !word.equals("")&&!word.equals("StartValue")) {
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

                            if (word.equals("ArmorPointsFromExperience") || word.equals("BaseArmorPoints")|| (nextPassArmor && notDoneArmor)&&!word.equals("")&& !word.equals("StartValue")) {
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

                            if (word.equals("MaxAntiMatter") || (nextPassMaxAnti && notDoneMaxAntiMatter)&& !word.equals("")&&!word.equals("StartValue")) {
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

                            if (word.equals("armorType")|| (nextPassArmorType && notDoneArmorType && !word.equals(""))) {
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

                        if(counter == 18){

                            shipList.add(Ship);
                            counter=0;
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

                    fr2.close();
                }
            }
            fr1.close();
        }


    }
