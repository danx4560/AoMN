/* Andrew Shen
June 15 2015
The purpose of this program is to create a runable class file with methods that can create a file that will contain a randomly choosen enemy that the player will fight in his
or her current area
*/

import java.io.*;


public class GetEnemyInfo {
 private int randEnemy;
 private int enemyAtt, att1, att2;
 private int enemyDef, def1, def2;
 private int enemyGold, gold1, gold2;
 private int enemyExp;
 private int enemyHp;
 private String enemyName;
 private String enemyLocation;

 private File Hstat = new File(
   "HeroStat.txt");// Grab
                   // hero
                   // stat
                   // file
 private int area;

public void writeEnmeyFile () { //turns the location area of the player from a int in the herostat file to a string name that can be used to call upon area files

 switch((int)area){
 case 1:
  enemyLocation = "Castle Outskirt";
  break;
 case 2:
  enemyLocation = "Road";
  break;
 case 3:
  enemyLocation = "Forest";
  break;
 case 4:
  enemyLocation = "River";
  break;
 case 5:
  enemyLocation = "Forest Encampment";
  break;
 case 6:
  enemyLocation = "Desert";
  break;
 case 7:
  enemyLocation = "Canyon";
  break;
 case 8:
  enemyLocation = "Deserted Road";
  break;
 case 9:
  enemyLocation = "Dragonstone Outskirt";
  break;
 case 10:
  enemyLocation = "Dragonstone Keep";
  break;
 case 11:
  enemyLocation = "Dragonstone Throne";
  break;


 }


 //Grab Info
 randEnemy = (int) (Math.random()*(5-0)+0); //generates which monster player fights
 randEnemy = randEnemy * 10;
 int i = 1;
 File textFile = new File("Areas\\" + enemyLocation + ".txt" );
 FileReader in;
 BufferedReader readFile;
 String lineOfText;
 try {
  in = new FileReader(textFile);
  readFile = new BufferedReader(in);
  while ((lineOfText = readFile.readLine()) != null) {
  if (i == (randEnemy+1)) { // read the line number starting from which enemy the player is fighting
  enemyName = lineOfText; //Grab Enemy Name
  }
  if (i == (randEnemy+2)) {
  enemyHp = (int) (Integer.parseInt(lineOfText)); // Grab Enemy Hp
  }
  if (i == (randEnemy+3)) {
  att1 = (int) (Integer.parseInt(lineOfText)); // Grab Enemy Att 1
  }
  if (i == (randEnemy+4)) {
  att2 = (int) (Integer.parseInt(lineOfText)); // Grab Enemy Att 2
  }
  if (i == (randEnemy+5)) {
  def1 = (int) (Integer.parseInt(lineOfText)); // Grab Enemy Def 1
  }
  if (i == (randEnemy+6)) {
  def2 = (int) (Integer.parseInt(lineOfText)); // Grab Enemy Def 2
  }
  if (i == (randEnemy+7)) {
  gold1 = (int) (Integer.parseInt(lineOfText)); // Grab Enemy Def 1
  }
  if (i == (randEnemy+8)) {
  gold2 = (int) (Integer.parseInt(lineOfText)); // Grab Enemy Def 2
  }
  if (i == (randEnemy+9)) {
  enemyExp = (int) (Integer.parseInt(lineOfText)); // Grab Enemy Def 2
  }
  i = i + 1; //increase counter
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

 //Make Info
 att2 = att2 + 1; //adds values to att, def, gold in order to make sure it is randomly generated from the pre determined amount
 def2 = def2 + 1;
 gold2 = gold2 + 1;
 enemyAtt = (int)(Math.random()*(att2-att1)+att1); //randomly generates the values from the predetermined range
 enemyDef = (int)(Math.random()*(def2-def1)+def1);
 enemyGold = (int)(Math.random()*(gold2-gold1)+gold1);
 //write file
 File dataFile = new File("MonsterStat.txt");
 FileWriter out; // Initializes a filewriter which creates a file stream
 BufferedWriter writeFile; //BufferedWriter writes the file stream
 try {
  out = new FileWriter(dataFile);
  writeFile = new BufferedWriter(out);
  writeFile.write(String.valueOf(enemyAtt));
  writeFile.newLine();
  writeFile.write(String.valueOf(enemyDef));
  writeFile.newLine();
  writeFile.write(String.valueOf(enemyHp));
  writeFile.newLine();
  writeFile.write(String.valueOf(enemyGold));
  writeFile.newLine();
  writeFile.write(String.valueOf(enemyExp));
  writeFile.newLine();
  writeFile.write(enemyName);
  writeFile.close();
  out.close();
 } catch (IOException e) {
  System.out.println("Problem writing to file.");
  System.err.println("IOException: " + e.getMessage());
 }
}

public void GrabStats() {
 FileReader in; // Initializes a filereader which creates a file stream
 BufferedReader read; // BufferedReader reads the file stream
 String line; // Used to get each line of the text file;
 int check = 0; // Used to check which line is viewed in the file
 // stream, and which one I would parse to a int/int

 try {
  in = new FileReader(Hstat);
  read = new BufferedReader(in);
  int stat = 0; // used to check which stat is which

  while ((line = read.readLine()) != null) {
   check++;// adds a number to check
    switch (check) { // grabs value of stats
    case 8:
     area = Integer.parseInt(line);
     break;

    }
   }
  in.close();
  read.close();

 } catch (FileNotFoundException e) {
  System.out.println("File does not exist or could not be found.");
  System.err.println("FileNotFoundException: " + e.getMessage());
 } catch (IOException e) {
  System.out.println("Problem reading file.");
  System.err.println("IOException: " + e.getMessage());
 }
}

}
