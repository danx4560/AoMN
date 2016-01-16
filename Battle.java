/*Daniel Xiong
 * 15 june,2015
 * Mr. Paterson
 */
import java.io.*;

public class Battle {
 private int attmin, def, agi, luck, hp, area, level, gold, statpoint; // hero base stats
 private int totatt, totdef, totagi, tothp; // hero stats plus
             // equipment
 private int matt, mdef, mhp, mgold, mexp; // monster stats
 String mname;
 private int exp; // exp for level up
 private  boolean[] boss = new boolean [11];
 private int[] totalexp = { 100, 210, 330, 460, 600, 750, 860, 980, 1110,
   1250, 1400, 1520, 1660, 1820, 2000, 2200, 2200, 2320, 2460, 2620,
   2800 };// Array storing max exp for each level
 private File Hstat = new File(
   "HeroStat.txt");// Grab
                   // hero
                   // stat
                   // file
 private File Mstat = new File(
   "MonsterStat.txt");// Grab
                    // monster
                    // stat
                    // file
 private File Equipstat = new File(
   "EquipStat.txt");// Grab
                    // equip
                    // stat
                    // file
 private File Bosses = new File(
   "Bosses.txt"); //Defeated Boss FIle

 public void GrabStats() {
  FileReader in; // Initializes a filereader which creates a file stream
  BufferedReader read; // BufferedReader reads the file stream
  String line; // Used to get each line of the text file;
  int check = 0; // Used to check which line is viewed in the file
  // stream, and which one I would parse to a int/int

  try {
   in = new FileReader(Hstat);
   read = new BufferedReader(in);

   while ((line = read.readLine()) != null) {
    check++;// adds a number to check
     switch (check) { // grabs value of stats
     case 1:
      level = Integer.parseInt(line);
      break;
     case 2:
      attmin = Integer.parseInt(line);
      break;
     case 3:
      def = Integer.parseInt(line);
      break;
     case 4:
      agi = Integer.parseInt(line);
      break;
     case 5:
      luck = Integer.parseInt(line);
      break;
     case 6:
      hp = Integer.parseInt(line);
      break;
     case 7:
      gold = Integer.parseInt(line);
      break;
     case 8:
      area = Integer.parseInt(line);
      break;
     case 9:
      statpoint = Integer.parseInt(line);
      break;
     case 10:
      exp = Integer.parseInt(line);
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

 public void GrabBoss(){
 FileReader in; // Initializes a filereader which creates a file stream
 BufferedReader read; // BufferedReader reads the file streamSaveStats()
 String line; // Used to get each line of the text file;
 int check = 0; // Used to check which line is viewed in the file
 // stream, and which one I would parse to a int/int

 try {
  in = new FileReader(Bosses);
  read = new BufferedReader(in);

  while ((line = read.readLine()) != null) {
    int x = Integer.parseInt(line);
    if(x==1){boss[check]=true;}
    else{boss[check]=false;}
    check++;
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

 public void GrabMonsterStats() {
  FileReader in; // Initializes a filereader which creates a file stream
  BufferedReader read; // BufferedReader reads the file stream
  String line; // Used to get each line of the text file;
  int check = 0; // Used to check which line is viewed in the file
  // stream, and which one I would parse to a int/int

  try {
   in = new FileReader(Mstat);
   read = new BufferedReader(in);
   int stat = 0; // used to check which stat is which

   while ((line = read.readLine()) != null) {
    check++;// adds a number to check


     stat++;// Adds every second line
     switch (stat) { // grabs value of stats
     case 1:
      matt = Integer.parseInt(line);
      break;
     case 2:
      mdef = Integer.parseInt(line);
      break;
     case 3:
      mhp = Integer.parseInt(line);
      break;
     case 4:
      mgold = Integer.parseInt(line);
      break;
     case 5:
      mexp = Integer.parseInt(line);
      break;
     case 6:
      mname = line;
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

 public void GrabEquipStats() {
  FileReader in; // Initializes a filereader which creates a file stream
  BufferedReader read; // BufferedReader reads the file stream
  String line; // Used to get each line of the text file;
  int check = 0; // Used to check which line is viewed in the file
  // stream, and which one I would parse to a int/int

  try {
   in = new FileReader(Equipstat);
   read = new BufferedReader(in);
   int stat = 0; // used to check which stat is which

   while ((line = read.readLine()) != null) {
    check++;// adds a number to check

    if (check == 2) {
     stat++;// Adds every second line
     check = 0;// resets check
     switch (stat) { // grabs value of stats
     case 1:
      tothp = Integer.parseInt(line);
      tothp = tothp + hp;
      break;
     case 2:
      totatt = Integer.parseInt(line);
      totatt = totatt + attmin;
      break;
     case 3:
      totdef = Integer.parseInt(line);
      totdef =totdef + def;
      break;
     }
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

 public void Fight() {
  int Php = tothp;//battle hp value
  int Mhp = mhp;//battle hp value
  int pdamage, mdamage;//damage done
  int pdef;
  int bossdeath = 0;//checks if boss has been killed
  int crit, dodge;
  System.out.println("Battle Start");
  System.out.println("Mubarakan Hp: "+ Php + "/"+tothp);
  System.out.println(mname + " Hp: "+ Mhp + "/"+mhp);
  if(mname=="Tyreal"){System.out.println("HA! You think you can just march in my throne and take me out? No way, you are done for.");}
  try {
      //thread to sleep for the specified number of milliseconds
      Thread.sleep(2000);
  } catch (java.lang.InterruptedException ie) {
      System.out.println(ie);
  }



  while(Php>0 && Mhp>0){
   System.out.println();
   //Player attacks first
   pdamage = (int)(Math.random()*(totatt-attmin)+attmin);//generates damage
   //System.out.println(totatt + " " + attmin + "   " + pdamage);

   pdamage = pdamage-mdef;//subtract def
   if(pdamage<0){pdamage=0;}//makes sure damage doesnt go below 0
   crit = (int)(Math.random()*100);
   if(crit>0&&crit<=luck){
    pdamage=pdamage*3;
    System.out.println("CRIIITTTICALLL STTTTTRIKEEEE! "+ pdamage);
    Mhp=Mhp-pdamage;
    }else{
     System.out.println("You hit: "+ pdamage);
     Mhp=Mhp-pdamage;
    }
   if(Mhp<0){Mhp=0;break;}
   System.out.println(mname + " Hp: "+ Mhp + "/"+mhp);

   try {
       //thread to sleep for the specified number of milliseconds
       Thread.sleep(1000);
   } catch (java.lang.InterruptedException ie) {
       System.out.println(ie);
   }

   if(Php<=0 || Mhp<=0){break;}//Stoping whnm player or monster is dead
   System.out.println();
   //Monster Att
   pdef = (int)(Math.random()*(totdef-def)+def);//generates damage
   //System.out.println(pdef + " "+ def +" "+totdef+ " ");
   mdamage=matt-pdef;//Subtract def
   if(mdamage<0){mdamage=0;}//makes sure damage doesnt go below 0
   dodge = (int)(Math.random()*100);
   if(dodge>0&&crit<=agi){
    mdamage = 0;
    System.out.println(mname + " misses ");
    Php=Php-mdamage;
    }else{
     System.out.println(mname + " hit: " +mdamage);
     Php=Php-mdamage;
    }
   if(Php<0){Php=0;}
   System.out.println("Mubarakan Hp: "+ Php + "/"+hp);
   try {
       //thread to sleep for the specified number of milliseconds
       Thread.sleep(1000);
   } catch ( java.lang.InterruptedException ie) {
       System.out.println(ie);
   }

  }

  //Win/Lose
  if(Mhp<=0){//winning statement
   System.out.println("You Win! + "+ mgold + " gold and "+ mexp+" exp");
   gold=gold+mgold;
   exp=exp+mexp;
   //boss death check and area unlocks

   if (mname.equals("Saber")){bossdeath=1;}
   else if(mname.equals("Assassin")){bossdeath=2;}
   else if(mname.equals("Illfang")){bossdeath=3;}
   else if(mname.equals("Kayran")){bossdeath=4;}
   else if(mname.equals("Shadolala")){bossdeath=5;}
   else if(mname.equals("Amaterasu")){bossdeath=6;}
   else if(mname.equals("Morrigan")){bossdeath=7;}
   else if(mname.equals("Emiya")){bossdeath=8;}
   else if(mname.equals("Solas")){bossdeath=9;}
   else if(mname.equals("Vesemir")){bossdeath=10;}

   switch(bossdeath){
   case 1:
    System.out.println("You will not get away with this! Those jewels represent the Kingdom! We won’t be able to – (Dies)"); //STORYLINE
    boss[bossdeath] = true;
    break;
   case 2:
    System.out.println("Return back the jewels! We won’t be able to survive with the- (Dies)"); //STORYLINE
    boss[bossdeath] = true;
    break;
   case 3:
    System.out.println("KAHAHAHHH- (Dies)"); //STORYLINE
    boss[bossdeath] = true;
    break;
   case 4:
    System.out.println("GEEEEMMMYYY- (Dies)"); //STORYLINE
    boss[bossdeath] = true;
    break;
   case 5:
    System.out.println("Upon his dying breath, the shadolala hollers, 'MUDA MUDA MUDA!!!', and drops a letter. The letter read, 'Give this letter to Chief Tyreal, tell him that the messenger Mubarakan has fallen for the trap and is now approaching back to the Castle of Thieves. He does not know that the jewels hold the power of 1000 kings that its’ very will can topple kingdoms. This letter must not go to anyone else.' Mubarakan discovers this and heads on to the Castle of Thieves to confront Chief Tyreal"); //STORYLINE
    boss[bossdeath] = true;
    break;
   case 6:
    System.out.println("Juuh (Whimpers - Dies)"); //STORYLINE
    boss[bossdeath] = true;
    break;
   case 7:
    System.out.println("Traitor! We trusted you! Why did you betray us? - Dies"); //STORYLINE
    boss[bossdeath] = true;
    break;
   case 8:
    System.out.println("You were supposed to be on our side! You were supposed to - Dies"); //STORYLINE
    boss[bossdeath] = true;
    break;
   case 9:
    System.out.println("Traitor! I curse you to the depths of hell! How can you do this to Chief Tyreal? - Dies"); //STORYLINE
    boss[bossdeath] = true;
    break;
   case 10:
    System.out.println("Liar! Scum! Trash! That is all you are, you’ll never beat Chief Tyreal! - Dies"); //STORYLINE
    boss[bossdeath] = true;
    break;
   }

   bossdeath=0;
  }
  else{//losing statement
   if(mname=="Tyreal"&& boss[10]==true){
    System.out.println("What did I say, you are no match for me. I am stronger than you in every way, there is no possibility where you can kill me");
    try {
        //thread to sleep for the specified number of milliseconds
        Thread.sleep(1500);
    } catch ( java.lang.InterruptedException ie) {
        System.out.println(ie);
    }
    System.out.println("As Chief Tyreal brings up his sword to slay Mubarakan, a glimpse of hope arises and his sword is suddenly knocked out of his hand. Mubarakan looks up and sees a golden crown, he realizes that it was the King Foltmed himself, coming to save him and the King’s priceless jewels.");
    try {
        //thread to sleep for the specified number of milliseconds
        Thread.sleep(1500);
    } catch ( java.lang.InterruptedException ie) {
        System.out.println(ie);
    }
    System.out.println("Chief Tyreal falls to the floor as the last thing he saw was King Foltmed’s blade penetrating his body. He screams in agony but ultimately accepts his death as he laid down on the floor with stiff movements. King Foltmed steps over his body and retrieves the jewels, he then helped carry Mubarakan out of the castle and back home to the Kingdom of Terimera.");
    System.out.println("GAME OVER!!!, now we hate our brothers, no longer can we..., but its keep on keeping on, and i just want to knowm ");
   }

   else{System.out.println("You Lose");}
   }
  }

 public void SaveStats() {
  if(exp>=totalexp[(int)(level-1)]&&level!=20){
   System.out.println("Level Up!!!");
   System.out.println("+15 Hp");
   System.out.println("+3 Stat Points");
   exp=exp-totalexp[(int)(level-1)];
   level++;
   hp=hp+15;
   statpoint=statpoint+3;
   }//Changes done when hero levels up
  System.out.println("EXP: " + exp + "/" + totalexp[(int) level-1]);
  FileWriter out; //creates a output file stream
  BufferedWriter write; //reads output file stream

  try {
   out = new FileWriter(Hstat);
   write = new BufferedWriter(out);
   for(int i=1;i<=10;i++){//from 1-10
    switch (i) {
    case 1:
     write.write(String.valueOf(level));//write stat value
     write.newLine();
     break;
    case 2:
     write.write(String.valueOf(attmin));
     write.newLine();;
     break;
    case 3:
     write.write(String.valueOf(def));
     write.newLine();
     break;
    case 4:
     write.write(String.valueOf(agi));
     write.newLine();
     break;
    case 5:
     write.write(String.valueOf(luck));
     write.newLine();
     break;
    case 6:
     write.write(String.valueOf(hp));
     write.newLine();
     break;
    case 7:
     write.write(String.valueOf(gold));
     write.newLine();
     break;
    case 8:
     write.write(String.valueOf(area));
     write.newLine();
     break;
    case 9:
     write.write(String.valueOf(statpoint));
     write.newLine();
     break;
    case 10:
     write.write(String.valueOf(exp));
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

  try {
   out = new FileWriter(Bosses);
   write = new BufferedWriter(out);
   for(int i=0;i<=10;i++){//from 1-10
    if(boss[i]==true){write.write("1");write.newLine();}
    else{write.write("0");write.newLine();}
   }
   write.close();
   out.close();
  } catch (IOException e) {
   //System.out.println("File could not be created.");
   System.err.println("IOException: " + e.getMessage());
  }

 }
}
