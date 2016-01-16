/* Sean Ly
 * 15 June, 2015
 * Mr. Paterson
 */
import java.io.*;
import java.util.*;

public class Shop { // Grabbing all variables because you can't write single
     // line
 private int Gold;
 private int Level;
 private int Attack;
 private int Defense;
 private int Agility;
 private int Luck;
 private int Hp;
 private int Area;
 private int StatPoints;
 private int EXP;
 private String HpGem;
 private int HpGemBonus;
 private String Weapon;
 private int WeaponBonus;
 private String Cloth;
 private int ClothBonus;


 File HeroStat = new File("HeroStat.txt");
 File EquipStat = new File("EquipStat.txt");

 public void GrabStats() { // Grabs amount of gold person has

  FileReader in;
  BufferedReader readFile;
  String lineOfText;
  int check = 0; // check is used to look at a line in a file

  try {
   in = new FileReader(HeroStat);
   readFile = new BufferedReader(in);

   while ((lineOfText = readFile.readLine()) != null) {
    check++;// adds a number to check the file
    switch (check) {// saves and grabs the stat values
    // case-switch is used to read every line and grab values
    case 1:
     Level = Integer.parseInt(lineOfText);// grabbing level
               // line
     break;
    case 2:
     Attack = Integer.parseInt(lineOfText); //grabbing attack line
     break;
    case 3:
     Defense = Integer.parseInt(lineOfText); //grabbing defense line
     break;
    case 4:
     Agility = Integer.parseInt(lineOfText); //grabbing agility line
     break;
    case 5:
     Luck = Integer.parseInt(lineOfText); //grabbing luck line
     break;
    case 6:
     Hp = Integer.parseInt(lineOfText); //grabbing hp line
     break;
    case 7:
     Gold = Integer.parseInt(lineOfText); //grabbing gold line
     break;
    case 8:
     Area = Integer.parseInt(lineOfText); //grabbing area line
     break;
    case 9:
     StatPoints = Integer.parseInt(lineOfText); //grabbing statpoints
     break;
    case 10:
     EXP = Integer.parseInt(lineOfText); //grabbing exp line
     break;

    }
   }

   readFile.close();
   in.close();

  } catch (FileNotFoundException e) {
   System.out.println("File does not exist or could not be found.");
   System.err.println("FileNotFoundException: " + e.getMessage());
  } catch (IOException e) {
   System.out.println("Problem reading file.");
   System.err.println("IOException: " + e.getMessage());
  }
 }

 public void GrabEquipStats() { // Grabs Equipment Stats

  FileReader in;
  BufferedReader readFile;
  String lineOfText;
  int check = 0; // check is used to look at a line in a file

  try {
   in = new FileReader(EquipStat);
   readFile = new BufferedReader(in);
   while ((lineOfText = readFile.readLine()) != null) {
    check++;// adds a number to check the file

    switch (check) {// saves and grabs the stat values
    // case-switch is used to read every line and grab values

    case 1:
     HpGem = lineOfText;
     break;
    case 2:
     HpGemBonus = Integer.parseInt(lineOfText);
     break;
    case 3:
     Weapon = lineOfText;
     break;
    case 4:
     WeaponBonus = Integer.parseInt(lineOfText);
     break;
    case 5:
     Cloth = lineOfText;
     break;
    case 6:
     ClothBonus = Integer.parseInt(lineOfText);
     break;
    }
   }
   readFile.close();
   in.close();

  } catch (FileNotFoundException e) {
   System.out.println("File does not exist or could not be found.");
   System.err.println("FileNotFoundException: " + e.getMessage());
  } catch (IOException e) {
   System.out.println("Problem reading file.");
   System.err.println("IOException: " + e.getMessage());
  }
 }

 public void ArmorShop() {
  int playerChoice;
 

  Scanner input = new Scanner(System.in);
  System.out.println("Hi, welcome to the shop In order to buy, type in the number that the item is corresponds to");
  
  System.out.format("%-4s %-25s %-9s %-4s" , "1. ", "Cloth Armor", "+3 Def", "300g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "2. ", "Leather Doublet", "+5 Def", "1000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "3. ", "Aquila Cuirass", "+8 Def", "1500g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "4. ", "Heart of Metal", "+12 Def", "3000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "5. ", "Chain Mail", "+16 Def", "4500g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "6. ", "Splint Cuirass", "+26 Def", "6000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "7. ", "Chaingmail", "+35 Def", "7000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "8. ", "Etched Jacket", "+47 Def", "8500g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "9. ", "Aughild's Dominion", "+64 Def", "9800g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "10. ", "Goldskin", "+84 Def", "15000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "11. ", "Magnificent Balor Armor", "+98 Def", "24000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "12. ", "Tyreal's Might", "+180 Def", "36000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "13. ", "Blackthorne's Surcoat", "+200 Def", "40000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "14. ", "Inna's Great Expanse", "+250 Def", "55000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "15. ", "Glorious Doom Armor", "+350 Def", "70000g\n");

  playerChoice = input.nextInt();

  switch (playerChoice) { //switch statement for options in player menu  

  case 1:  //item 1
   Gold = Gold - 300; //current gold and deducting from item price 
   if (Gold < 0) { // if statement for if player has less than 300 gold
    Gold = Gold + 300; // Add back 300 gold to the player
    System.out
      .println("You have an insufficent amount of gold to buy this equipment"); //tells the player that gold is insufficent 
   } else { //else statement
    Cloth = "Cloth Armor"; //cloth variable is now titled as Cloth Armor  
    ClothBonus = 3; //BonusDef or ClothBonus is added to Defense stat
   }
   break;
  case 2:
   Gold = Gold - 1000;
   if (Gold < 0) {
    Gold = Gold + 1000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Leather Doublet";
    ClothBonus = 5;
   }
   break;
  case 3:
   Gold = Gold - 1500;
   if (Gold < 0) {
    Gold = Gold + 1500;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Aquila Cuirass";
    ClothBonus = 8;
   }
   break;
  case 4:
   Gold = Gold - 3000;
   if (Gold < 0) {
    Gold = Gold + 3000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Heart of Metal";
    ClothBonus = 12;
   }
   break;
  case 5:
   Gold = Gold - 4500;
   if (Gold < 0) {
    Gold = Gold + 4500;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Chain Mail";
    ClothBonus = 16;
   }
   break;
  case 6:
   Gold = Gold - 6000;
   if (Gold < 0) {
    Gold = Gold + 6000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Splint Cuirass";
    ClothBonus = 26;
   }
   break;
  case 7:
   Gold = Gold - 7000;
   if (Gold < 0) {
    Gold = Gold + 7000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Chaingmail";
    ClothBonus = 35;
   }
   break;
  case 8:
   Gold = Gold - 8500;
   if (Gold < 0) {
    Gold = Gold + 8500;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Etched Jacket";
    ClothBonus = 48;
   }
   break;
  case 9:
   Gold = Gold - 9800;
   if (Gold < 0) {
    Gold = Gold + 9800;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Aughild's Dominion";
    ClothBonus = 63;
   }
   break;
  case 10:
   Gold = Gold - 15000;
   if (Gold < 0) {
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Goldskin";
    ClothBonus = 15000;
   }
   break;
  case 11:
   Gold = Gold - 24000;
   if (Gold < 0) {
    Gold = Gold + 24000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Magnificent Balor Armor";
    ClothBonus = 98;
   }
   break;
  case 12:
   Gold = Gold - 36000;
   if (Gold < 0) {
    Gold = Gold + 36000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Tyreal's Might";
    ClothBonus = 180;
   }
   break;
  case 13:
   Gold = Gold - 40000;
   if (Gold < 0) {
    Gold = Gold + 40000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Blackthorne's Surcoat";
    ClothBonus = 200;
   }
   break;
  case 14:
   Gold = Gold - 55000;
   if (Gold < 0) {
    Gold = Gold + 55000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Inna's Great Expanse";
    ClothBonus = 250;
   }
   break;
  case 15:
   Gold = Gold - 70000;
   if (Gold < 0) {
    Gold = Gold + 70000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Cloth = "Glorious Doom Armor";
    ClothBonus = 350;
   }
   break;
  }
  
 }

 public void SwordShop() {
  int playerChoice2;

  Scanner input = new Scanner(System.in);

  System.out.println("Hi, welcome to the shop In order to buy, type in the number that the item is corresponds to");
  System.out.format("%-4s %-35s %-10s %-4s" , "1. ", "Sword of Andrew", "+2 Attk", "600g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "2. ", "Sword of JongJin", "+3 Attk", "1200g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "3. ", "Shield of Snose", "+4 Attk", "2000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "4. ", "Axe of Shad", "+5 Attk", "2750g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "5. ", "Hammer of Creation", "+6 Attk", "3400g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "6. ", "Cutlass of Cutting", "+7 Attk", "4000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "7. ", "Rusty Katana", "+8 Attk", "5000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "8. ", "Spear of Shen", "+9 Attk", "575g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "9. ", "Sword of the Fallen", "+10 Attk", "7000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "10. ", "Long Sword of the Mist", "+11 Attk", "8000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "11. ", "Short Sword of Assassins", "+12 Attk", "9500g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "12. ", "Kunai of the Ninja", "+13 Attk", "11000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "13. ", "Two Handed Sword of the Mountain", "+14 Attk", "12500g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "14. ", "Spear of the Red Viper", "+15 Attk", "14000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "15. ", "King's Sword", "+16 Attk", "16500g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "16. ", "Brotherhood Short Sword", "+18 Attk", "18000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "17. ", "Jack's Sword", "+25 Attk", "30000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "18. ", "Queen's Sword", "+40 Attk", "50000g\n");
  System.out.format("%-4s %-35s %-10s %-4s" , "19. ", "Joker's Sword", "+60 Attk", "70000g\n");
  playerChoice2 = input.nextInt();
  switch (playerChoice2) {
  case 1:
   Gold = Gold - 600;
   if (Gold < 0) {
    Gold = Gold + 600;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Sword of Andrew";
    WeaponBonus = 2;
   }
   break;
  case 2:
   Gold = Gold - 1200;
   if (Gold < 0) {
    Gold = Gold + 1200;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Sword of JongJin";
    WeaponBonus = 3;
   }
   break;
  case 3:
   Gold = Gold - 2000;
   if (Gold < 0) {
    Gold = Gold + 2000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Shield of Snose";
    WeaponBonus = 4;
   }
   break;
  case 4:
   Gold = Gold - 2750;
   if (Gold < 0) {
    Gold = Gold + 2750;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Axe of Shad";
    WeaponBonus = 5;
   }
   break;
  case 5:
   Gold = Gold - 3400;
   if (Gold < 0) {
    Gold = Gold + 3400;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Hammer of Creation";
    WeaponBonus = 6;
   }
   break;
  case 6:
   Gold = Gold - 4000;
   if (Gold < 0) {
    Gold = Gold + 4000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Cutlass of Cutting";
    WeaponBonus = 7;
   }
   break;
  case 7:
   Gold = Gold - 5000;
   if (Gold < 0) {
    Gold = Gold + 5000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Rusty Katana";
    WeaponBonus = 8;
   }
   break;
  case 8:
   Gold = Gold - 5750;
   if (Gold < 0) {
    Gold = Gold + 5750;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Spear of Shen";
    WeaponBonus = 9;
   }
   break;
  case 9:
   Gold = Gold - 7000;
   if (Gold < 0) {
    Gold = Gold + 7000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Sword of the Fallen";
    WeaponBonus = 10;
   }
   break;
  case 10:
   Gold = Gold - 8000;
   if (Gold < 0) {
    Gold = Gold + 8000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Long Sword of the Mist";
    WeaponBonus = 11;
   }
   break;
  case 11:
   Gold = Gold - 9500;
   if (Gold < 0) {
    Gold = Gold + 9500;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Short Sword of Assassins";
    WeaponBonus = 12;
   }
   break;
  case 12:
   Gold = Gold - 11000;
   if (Gold < 0) {
    Gold = Gold + 11000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Kunai of the Ninja";
    WeaponBonus = 14;
   }
   break;
  case 13:
   Gold = Gold - 12500;
   if (Gold < 0) {
    Gold = Gold + 12500;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Two Handed Sword of the Mountain";
    WeaponBonus = 15;
   }
   break;
  case 14:
   Gold = Gold - 14000;
   if (Gold < 0) {
    Gold = Gold + 14000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Spear of the Red Viper";
    WeaponBonus = 15;
   }
   break;
  case 15:
   Gold = Gold - 16500;
   if (Gold < 0) {
    Gold = Gold + 16500;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "King's Sword";
    WeaponBonus = 16;
   }
   break;
  case 16:
   Gold = Gold - 18000;
   if (Gold < 0) {
    Gold = Gold + 18000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Brotherhood Short Sword";
    WeaponBonus = 18;
   }
   break;
  case 17:
   Gold = Gold - 30000;
   if (Gold < 0) {
    Gold = Gold + 30000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Jack's Sword";
    WeaponBonus = 25;
   }
   break;
  case 18:
   Gold = Gold - 50000;
   if (Gold < 0) {
    Gold = Gold + 50000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Queen's Sword";
    WeaponBonus = 40;
   }
   break;
  case 19:
   Gold = Gold - 70000;
   if (Gold < 0) {
    Gold = Gold + 70000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    Weapon = "Joker's Sword";
    WeaponBonus = 60;
   }
  }
  //input.close();
 }

 public void GemShop() {
  
  int playerChoice3;

  Scanner input = new Scanner(System.in);

  System.out
    .println("Hi, welcome to the shop In order to buy, type in the number that the item is corresponds to");
  System.out.format("%-4s %-25s %-9s %-4s" , "1. ", "Chipped Health Gem", "+100 Health", "5000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "2. ", "Flawed Health Gem", "+200 Health", "10000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "3. ", "Health Gem", "+300 Health", "15000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "4. ", "Flawless Health Gem", "+400 Health", "20000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "5. ", "Perfect Health Gem", "+500 Health", "25000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "6. ", "Radiant Health Gem", "+600 Health", "30000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "7. ", "Square Health Gem", "+700 Health", "35000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "8. ", "Flawless Square Health Gem", "+800 Health", "40000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "9. ", "Perfect Square Health Gem", "+900 Health", "45000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "10. ", "Radiant Square Health Gem", "+1000 Health", "50000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "11. ", "Perfect Star Health Gem", "+1300 Health", "60000g\n");
  System.out.format("%-4s %-25s %-9s %-4s" , "12. ", "Flawless Royal Health Gem", "+5000 Health", "80000g\n");

  playerChoice3 = input.nextInt();
  switch (playerChoice3) {
  case 1:
   Gold = Gold - 5000;
   if (Gold < 0) {
    Gold = Gold + 5000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Chipped Health Gem";
    HpGemBonus = 100;
   }
   break;
  case 2:
   Gold = Gold - 10000;
   if (Gold < 0) {
    Gold = Gold - 10000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Flawed Health Gem";
    HpGemBonus = 200;
   }
   break;
  case 3:
   Gold = Gold - 15000;
   if (Gold < 0) {
    Gold = Gold + 15000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Health Gem";
    HpGemBonus = 300;
   }
   break;
  case 4:
   Gold = Gold - 20000;
   if (Gold < 0) {
    Gold = Gold + 20000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Flawless Health Gem";
    HpGemBonus = 400;
   }
   break;
  case 5:
   Gold = Gold - 25000;
   if (Gold < 0) {
    Gold = Gold + 25000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Perfect Health Gem";
    HpGemBonus = 500;
   }
   break;
  case 6:
   Gold = Gold - 30000;
   if (Gold < 0) {
    Gold = Gold + 30000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Radiant Health Gem";
    HpGemBonus = 600;
   }
   break;
  case 7:
   Gold = Gold - 35000;
   if (Gold < 0) {
    Gold = Gold + 35000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Square Health Gem";
    HpGemBonus = 700;
   }
   break;
  case 8:
   Gold = Gold - 40000;
   if (Gold < 0) {
    Gold = Gold + 40000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Flawless Square Health Gem";
    HpGemBonus = 800;
   }
   break;
  case 9:
   Gold = Gold - 45000;
   if (Gold < 0) {
    Gold = Gold + 45000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Perfect Square Health Gem";
    HpGemBonus = 900;
   }
   break;
  case 10:
   Gold = Gold - 50000;
   if (Gold < 0) {
    Gold = Gold + 50000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Radiant Square Health Gem";
    HpGemBonus = 1000;
   }
   break;

  case 11:
   Gold = Gold - 60000;
   if (Gold < 0) {
    Gold = Gold + 600000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Perfect Star Health Gem";
    HpGemBonus = 1300;
   }
   break;
  case 12:
   Gold = Gold - 80000;
   if (Gold < 0) {
    Gold = Gold + 80000;
    System.out
      .println("You have an insufficent amount of gold to buy this equipment");
   } else {
    HpGem = "Flawless Royal Health Gem";
    HpGemBonus = 5000;
   }
   break;
  }
  //input.close();
 }

 public void SaveStats() {

  FileWriter out; //creates a output file stream 
  BufferedWriter write; //reads output file stream
  
  try {
   out = new FileWriter(HeroStat);
   write = new BufferedWriter(out);
   for(int i=1;i<=10;i++){//from 1-10
    switch (i) {
    case 1:
     write.write(String.valueOf(Level));//write stat value
     write.newLine();
     break;
    case 2:
     write.write(String.valueOf(Attack));
     write.newLine();;
     break;
    case 3:
     write.write(String.valueOf(Defense));
     write.newLine();
     break;
    case 4:
     write.write(String.valueOf(Agility));
     write.newLine();
     break;
    case 5:
     write.write(String.valueOf(Luck));
     write.newLine();
     break;
    case 6:
     write.write(String.valueOf(Hp));
     write.newLine();
     break;
    case 7:
     write.write(String.valueOf(Gold));
     write.newLine();
     break;
    case 8:
     write.write(String.valueOf(Area));
     write.newLine();
     break;
    case 9:
     write.write(String.valueOf(StatPoints));
     write.newLine();
     break;
    case 10:
     write.write(String.valueOf(EXP));
     write.newLine();
     break;
    }
    
   }
   write.close();
   out.close();
  } catch (IOException e) {
   //System.out.println("File could not be created.");
   System.err.println("IOException: " + e.getMessage());
  }
  
 }

 public void SaveEquipStats() {
  
  FileWriter out; //creates a output file stream 
  BufferedWriter write; //reads output file stream
  
  try {
   out = new FileWriter(EquipStat);
   write = new BufferedWriter(out);
   for(int i=1;i<=10;i++){//from 1-10
    switch (i) {
    case 1:
     write.write(String.valueOf(HpGem));//write stat value
     write.newLine();
     break;
    case 2:
     write.write(String.valueOf(HpGemBonus));
     write.newLine();;
     break;
    case 3:
     write.write(String.valueOf(Weapon));
     write.newLine();
     break;
    case 4:
     write.write(String.valueOf(WeaponBonus));
     write.newLine();
     break;
    case 5:
     write.write(String.valueOf(Cloth));
     write.newLine();
     break;
    case 6:
     write.write(String.valueOf(ClothBonus));
     write.newLine();
     break;
   
    }
    
   }
   write.close();
   out.close();
  } catch (IOException e) {
   System.err.println("IOException: " + e.getMessage());
  }
  
 }
  
 }