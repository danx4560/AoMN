import java.util.*;

public class main {
 public static void main(String[] args) {
  //Imports used classes
  Scanner in = new Scanner(System.in);
  Battle fight = new Battle();
  Main_Character Shad = new Main_Character();
  GetEnemyInfo EInfo = new GetEnemyInfo();
  Shop shop = new Shop();
  //Player choices
  int c, c2, c3, c4;
  //MAIN SCREEN
  do {
   System.out.println("0. Exit");
   System.out.println("1. Stats");
   System.out.println("2. Battle");
   System.out.println("3. Shop");
   c = in.nextInt();
   switch (c) {
   case 1:
    do {
     //STAT SCREEN
     System.out.println("0. Exit");
     System.out.println("1. Display Stats");
     System.out.println("2. Allocate Stats");
     c2 = in.nextInt();
     //Grabs stats
     Shad.loadStats();
     switch (c2) {
     case 1://Display Character Stats
      //Grab Stats
      Shad.viewInv();
      Shad.displayChar();
      break;
     case 2://Change Character Stats
      Shad.statsPoints();
      //Save
      Shad.saveStats();
      break;
     }

    } while (c2 != 0);
    break;
   case 2:
    do {
     //BATTLE SCREEN
     System.out.println("0. Exit");
     System.out.println("1. Change Area");
     System.out.println("2. Battle");
     c3 = in.nextInt();
     switch (c3) {

     case 1://Change Area
      //Grab Stats
      Shad.loadStats();
      Shad.viewBoss();
      //Change Area
      Shad.locationOfArea();
      //Save
      Shad.saveStats();
      break;

     case 2://Battle
      //Generate Monster Stat
      EInfo.GrabStats();
      EInfo.writeEnmeyFile();
      //Grab All Stats
      fight.GrabStats();
      fight.GrabMonsterStats();
      fight.GrabEquipStats();
      fight.GrabBoss();
      //Battle
      fight.Fight();
      //Save Stats
      fight.SaveStats();
      break;

     }
    } while (c3 != 0);
    break;
   case 3:
    do {
     //Display Inv
     System.out.println("Current Equip");
     Shad.loadStats();
     Shad.viewInv();
     Shad.displayinv();

     System.out.println("What would you like to buy");
     System.out.println("0. Exit");
     System.out.println("1. Weapon");
     System.out.println("2. Armor");
     System.out.println("3. Gem");
     c4 = in.nextInt();
     //Grab Stats
     shop.GrabEquipStats();
     shop.GrabStats();
     switch (c4) {
     
     case 1:
      shop.SwordShop();
      shop.SaveStats();
      shop.SaveEquipStats();
      break;

     case 2:
      shop.ArmorShop();
      shop.SaveStats();
      shop.SaveEquipStats();
      break;
     case 3: 
      shop.GemShop();
      shop.SaveStats();
      shop.SaveEquipStats();
      break;
     }
    } while (c4 != 0);
    break;
   }
  } while (c != 0);
  in.close();
 }
}