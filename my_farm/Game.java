package my_farm;

import java.util.*;

public class Game {
   public static int day;
   public static int gameStatus;

   public int menu(){
      Scanner input = new Scanner(System.in);
      day = 0;

      System.out.println("Welcome to the Farm!\n");
      System.out.print("[1] Start a new Game\n[2] Exit Game\n\nEnter your choice: ");
      gameStatus = input.nextInt();
      return gameStatus;
   }

   public String monologue(){
      Scanner input = new Scanner(System.in);
      Scanner key = new Scanner(System.in);

      String name = "";

      System.out.println("\nHey you, you're finally awake.");
      System.out.println("What is your name?");
      name = input.next();

      System.out.print("\nHello " + name + "!\nWell, what do you think? This was your grandpa's farm. (Enter to continue)");
      key.nextLine();
      System.out.print("It's been neglected for quite some time, but I'm sure you can bring it back to life. (Enter to continue)");
      key.nextLine();
      System.out.print("I'll be here to help you along the way. (Enter to continue)");
      key.nextLine();

      return name;
   }

   public void header(Farmer farmer, Farm farm) {
      System.out.println("\n[" + farmer.getName().toUpperCase() + "'s farm]");
      System.out.println("\nDay " + day);
      System.out.println("Level: " + farmer.getLevel() + "\t\tCoins: " + farmer.getObjectCoins() + "\nEXP: " + farmer.getExp());
      farm.checkHarvestDay(day);            
      farm.displayFarm();
   }

   public int footer(){
      Scanner input = new Scanner(System.in);
      int choice = 0;

      System.out.println("\nACTION:\n [1]Use Tools\t\t[4]Sleep\n [2]Shop\t\t[5]Exit\n [3]Harvest");
      choice = input.nextInt();
      return choice;
   }
   
   public int advanceDay(){
      Scanner input = new Scanner(System.in);
      int advanceDay;

      System.out.print("\nAdvance to the next day? \n[1]Yes\n[2]No\n");
      advanceDay = input.nextInt();
      return advanceDay;
   }

   public int gameOver(Farm farm){
      int withered = 0;
      for(int i = 0; i < 1; i++) {
         for(int j = 0; j < 1; j++) {
            if(farm.checkTileState(i, j) == "Withered") withered++;
         }
      }

      if(withered == 1) return 1;
      return 0;
   }

   public int getDay() {
      return day;
   }

   public void setDay(int day) {
      Game.day = day;
   }

   public static int getGameStatus() {
      return gameStatus;
   }

   public static void setGameStatus(int gameStatus) {
      Game.gameStatus = gameStatus;
   }
}
