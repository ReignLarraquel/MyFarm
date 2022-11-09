package my_farm;

import java.util.*;

public class Game {
   public static int day;
   public static int gameStatus;

/**
 * This function is the main menu of the game. It asks the user to choose between starting a new game
 * or exiting the game
 * 
 * @return The gameStatus variable is being returned.
 */
   public int menu(){
      Scanner input = new Scanner(System.in);
      day = 0;
      gameStatus = 0;

      while(checkInput(1, 2, gameStatus)){
         System.out.println("Welcome to the Farm!\n");
         System.out.print("[1] Start a new Game\n[2] Exit Game\n\nEnter your choice: ");
         gameStatus = input.nextInt();
         if(checkInput(1, 2, gameStatus)) InvalidInput();
      }
      return gameStatus;
   }

/**
 * This function is used to introduce the player to the game and get their name
 * 
 * @return The name of the player.
 */
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

/**
 * This function prints out the header of the game, which includes the farmer's name, the day, the
 * farmer's level, the farmer's coins, the farmer's experience, and the farm
 * 
 * @param farmer the farmer object
 * @param farm the farm object
 */
   public void header(Farmer farmer, Farm farm) {
      System.out.println("\n[" + farmer.getName().toUpperCase() + "'s farm]");
      System.out.println("\nDay " + day);
      System.out.println("Level: " + farmer.getLevel() + "\t\tCoins: " + farmer.getObjectCoins() + "\nEXP: " + farmer.getExp());
      farm.checkHarvestDay(day);            
      farm.displayFarm();
   }

/**
 * This function prints out the menu options for the player to choose from
 * 
 * @return The user's choice.
 */
   public int footer(){
      Scanner input = new Scanner(System.in);
      int choice = 0;

      while(checkInput(1, 5, choice)){
         System.out.println("\nACTION:\n [1]Use Tools\t\t[4]Sleep\n [2]Shop\t\t[5]Exit\n [3]Harvest");
         choice = input.nextInt();
         if(checkInput(1, 5, choice)) InvalidInput();         
      }

      return choice;
   }
   
/**
 * This function asks the user if they want to advance to the next day
 * 
 * @return The user's input.
 */
   public int advanceDay(){
      Scanner input = new Scanner(System.in);
      int advanceDay = 0;

      while(checkInput(1, 2, advanceDay)){
            System.out.print("\nAdvance to the next day? \n[1]Yes\n[2]No\n");
            advanceDay = input.nextInt();
         if(checkInput(1, 2, advanceDay)) InvalidInput();
      }

      return advanceDay;
   }

/**
 * If all tiles withered it, returns 1. If the number of coins is less than or
 * equal to 0, return 2. Otherwise, return 0
 * 
 * @param farm the farm object
 * @param farmer the farmer object
 * 
 * @return The gameOver method is returning an integer.
 */
   public int gameOver(Farm farm, Farmer farmer){
      int withered = 0;
      for(int i = 0; i < 1; i++) {
         for(int j = 0; j < 1; j++) {
            if(farm.checkTileState(i, j) == "Withered") withered++;
         }
      }

      if(withered == 1) return 1;
      else if(farmer.getObjectCoins() <= 0) return 2;
      return 0;
   }

   public boolean checkInput(int min, int max, int input){
      while(input < min || input > max){
         return true;
      }
      return false;
   }

   public void InvalidInput(){
      System.out.println("Invalid input. Please try again.\n\n");
   }

/**
 * This function returns the day of the game.
 * 
 * @return The day of the game.
 */
   public int getDay() {
      return day;
   }

/**
 * This function sets the day to the value of the parameter.
 * 
 * @param day The current day of the game.
 */
   public void setDay(int day) {
      Game.day = day;
   }

/**
 * > This function returns the value of the gameStatus variable
 * 
 * @return The gameStatus variable.
 */
   public static int getGameStatus() {
      return gameStatus;
   }

/**
 * This function sets the game status to the value passed in as a parameter
 * 
 * @param gameStatus This is the status of the game. 
 */
   public static void setGameStatus(int gameStatus) {
      Game.gameStatus = gameStatus;
   }
}
