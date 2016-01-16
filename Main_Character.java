/*Ahmed Shad
 * June 15,2015
 * Final Project
 * Mr. Patterson
 */
import java.io.*;
import java.util.Scanner;
public class Main_Character {
 private int [] mainStats = new int [10];
 
 int swords,armors,gems;
 String sword, armor, gem;
 private  boolean[] bosses = new boolean [11];//Stores all values of stats
 File dataFile = new File("HeroStat.txt");//File Pathway
 File dataInv = new File ("EquipStat.txt");
 File dataBoss = new File ("Bosses.txt");
 Scanner input = new Scanner (System.in);
 FileWriter out;
 BufferedWriter writeFile;
 //Loading up stats from the textbased file
 public void loadStats(){
  FileReader read;
  BufferedReader readFile;
  String stats;
  int readLine = 0;
  //Trys to read the file and give out infromation
  try{
   read = new FileReader(dataFile);
   readFile = new BufferedReader(read);
   while ((stats = readFile.readLine()) != null){
    readLine++; 
    //Reads each line, then stores into the array with each element
    switch (readLine){
    case 1:
     mainStats[0] = Integer.parseInt(stats);
     break;
    case 2:
     mainStats[1] = Integer.parseInt(stats);
     break;
    case 3:
     mainStats[2] = Integer.parseInt(stats);
     break;
    case 4:
     mainStats[3] = Integer.parseInt(stats);
     break;
    case 5:
     mainStats[4] = Integer.parseInt(stats);
     break;
    case 6:
     mainStats[5] = Integer.parseInt(stats);
     break;
    case 7:
     mainStats[6] = Integer.parseInt(stats);
     break;
    case 8:
     mainStats[7] = Integer.parseInt(stats);
     break;
    case 9:
     mainStats[8] = Integer.parseInt(stats);
     break;
    case 10:
     mainStats[9] = Integer.parseInt(stats);
     break;
    }
   }
   readFile.close();
   read.close();
   //Checks for anytype of error occurs during the processs and outputs if any
  }catch (FileNotFoundException e){
   System.out.println("File does not exist or could not be found");
   System.err.println("FileNotFoundException: " + e.getMessage());
  }catch (IOException e){
   System.out.println("Problem reading file.");
   System.err.println("IOException: " + e.getMessage());
  }
 }
 
 public void displayChar() {
  //Goes into a loop does each case and displays the name of each stat
    for (int i = 0; i <= 9; i++) {
     switch(i){
     case 0:
     System.out.println("Level: ");
     break;
     case 1:
      System.out.println("Attack: "); 
     break;
    case 2:
     System.out.println("Defense: "); 
     break;
    case 3:
     System.out.println("Agility: "); 
     break;
    case 4:
     System.out.println("Luck: "); 
     break;
    case 5:
     System.out.println("Hp: "); 
     break;
    case 6:
     System.out.println("Gold: "); 
     break; 
    case 7:
     System.out.println("Area: "); 
     break;
    case 8:
     System.out.println("Stat Points: "); 
     break;
    case 9:
     System.out.println("Exp: "); 
     break;

     }
     System.out.println(mainStats[i]);
    }
    System.out.println();
    System.out.format("%-35s %-5s %-5s",gem+":", "+ "+ gems," Hp\n");
    System.out.format("%-34s %-5s %-5s",armor+":", "+ "+ armors," Defense\n");
    System.out.format("%-35s %-5s %-5s",sword+":", "+ "+ swords," Attack\n");
   }

  public void viewInv() {
   FileReader read;
   BufferedReader readFile;
   String stats;
   int readLine = 0;
   try{
   //Reads the item name from the textbased file is saved on and displays the stats and add
   //value to the player
    read = new FileReader(dataInv);
    readFile = new BufferedReader(read);
    while ((stats = readFile.readLine()) != null){
     readLine++;
     switch(readLine){
     case 1:
      gem = stats;
      break;
     case 2:
      gems = Integer.parseInt(stats);
      break;
     case 3:
      sword = stats;
      break;
     case 4:
      swords = Integer.parseInt(stats);
      break;
     case 5:
      armor = stats;
      break;
     case 6:
      armors = Integer.parseInt(stats);
      break;
     }
    }
    readFile.close();
    read.close();
   }catch (FileNotFoundException e){
    System.out.println("File does not exist or could not be found");
    System.err.println("FileNotFoundException: " + e.getMessage());
   }catch (IOException e){
    System.out.println("Problem reading file.");
    System.err.println("IOException: " + e.getMessage());
   }
  }
  public void statsPoints() {
   //Checks if the players wants to use the stat or
    if (mainStats[8] > 0) {
     System.out.print("Where do you want to use your stats point(Defense or Attack):");
     String use = input.nextLine();
     //It will either add to defense or attack as the player wanted to be
     if (use.equalsIgnoreCase("defense")) {
   System.out.println("Defense +1");
      mainStats[2] += 1;
      mainStats[8] -= 1;
     } else {
   System.out.println("Attack +1");
      mainStats[1] += 1;
      mainStats[8] -= 1;
     }
    } else {
     System.out.println("No stat points left");
    }
   }
  
 public void viewBoss() {
   FileReader in; // Initializes a filereader which creates a file stream
   BufferedReader read; // BufferedReader reads the file stream
   String line; // Used to get each line of the text file;
   int check = 0; // Used to check which line is viewed in the file
   // stream, and which one I would parse to a int/int

   try {
    in = new FileReader(dataBoss);
    read = new BufferedReader(in);
    
    while ((line = read.readLine()) != null) {
      int x = Integer.parseInt(line);
      if(x==1){bosses[check]=true;}
      else{bosses[check]=false;}
      check++;
      
     }
    

   } catch (FileNotFoundException e) {
    System.out.println("File does not exist or could not be found.");
    System.err.println("FileNotFoundException: " + e.getMessage());
   } catch (IOException e) {
    System.out.println("Problem reading file.");
    System.err.println("IOException: " + e.getMessage());
   }
  }
  
 public void locationOfArea(){
  int area;
  System.out.print("Choose a Area: (1-11)");
  do{
  area = input.nextInt();
  if(bosses[area-1]==false){System.out.println("Last Boss hasn't been defeated");area=20;}
  }while(area>11);
  
  mainStats[7] = area;
  /*for(int i =0;i<=10;i++){
   System.out.println("Area "+i+" " + bosses[i]);
  }*/
 }
 
 public void saveStats(){
//saves the stats only for attack,defense and health
  //similar to loading up the character stats,expect different functions
  try{
   out = new FileWriter(dataFile);
   writeFile = new BufferedWriter(out);
   //writes the file inot the textbased file
   writeFile.write(String.valueOf(mainStats [0]));
   //skips to the next line
   writeFile.newLine();
   writeFile.write(String.valueOf(mainStats [1]));
   writeFile.newLine();
   writeFile.write(String.valueOf(mainStats [2]));
   writeFile.newLine();
   for (int i = 3; i <= 9; i++){
    writeFile.write(String.valueOf(mainStats[i]));
    writeFile.newLine();
   }
   writeFile.close();
   out.close();
  }catch(IOException e){
   System.out.println("Problem writing to file");
   System.out.println("IOException: " + e.getMessage());
  }
 }

 public void displayinv(){
  System.out.format("%-35s %-5s %-5s",gem+":", "+ "+ gems," Hp\n");
  System.out.format("%-34s %-5s %-5s",armor+":", "+ "+ armors," Defense\n");
  System.out.format("%-35s %-5s %-5s",sword+":", "+ "+ swords," Attack\n");
 }
} 