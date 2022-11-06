import my_farm.*;
import java.util.Scanner;

public class Main {
   public static int gameStatus = 0;
   public static int day = 0;

   public static void menu(){
      Scanner input = new Scanner(System.in);
      day = 0;

      System.out.println("Welcome to the Farm!\n");
      System.out.print("[1] Start a new Game\n[2] Exit Game\n\nEnter your choice: ");
      gameStatus = input.nextInt();
   }

   public static String monologue(){
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

   public static void main(String[] args) {
      Farm farm = new Farm();
      Farmer farmer;
      String name;

      //Setup Map:
      Game game = new Game();
      Shop shop = new Shop();
      UseItem useItem = new UseItem();
      int choice = 0;
      int buy = 0;
      int advanceDay = 2;
      int x;
      int y;

      Scanner input = new Scanner(System.in);

      gameStatus = game.menu();
      farmer = new Farmer(game.monologue());

      while(gameStatus == 1){
         game.setDay(game.getDay() + 1);;
         advanceDay = 2;

         while(advanceDay == 2){

            game.header(farmer, farm);

            if(game.gameOver(farm) == 1) {
               gameStatus = 2;
               advanceDay = 1;
               System.out.println("\nAll your plants have withered...\n\n[YOU LOSE]");
            }
            else{
               choice = game.footer();
               
               if(choice == 1){
                  useItem.toolMenu(choice, farmer);
                  
                  advanceDay = game.advanceDay();
               }
               if(choice == 2){
                  shop.displayShop();
                  buy = input.nextInt();
                  shop.buySeeds(farmer, buy - 1, farm, game.getDay());
   
                  advanceDay = game.advanceDay();
               }
               if(choice == 3){
                  System.out.println("Enter the coordinates of the tile you wish to harvest: ");
                  System.out.print("X: ");
                  x = input.nextInt();
                  System.out.print("Y: ");
                  y = input.nextInt();
   
                  farm.harvestPlant(farmer, x, y, game.getDay());
   
                  advanceDay = game.advanceDay();
               }
               if(choice == 4){
                  advanceDay = 1;
               }
               if(choice == 5) {
                  menu();
                  advanceDay = 1;
                  if(gameStatus == 1) farmer = new Farmer(monologue());
               }
   
            }
         }


      }
   }
}
