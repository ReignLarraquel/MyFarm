import my_farm.*;
import java.util.Scanner;

public class Main {
   public static int gameStatus = 0;
   public static int day = 1;

   public static void menu(){
      Scanner input = new Scanner(System.in);
      day = 1;

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

      System.out.print("\nHello " + name + ".\nWell, what do you think? This was your grandpa's farm. (Enter to continue)");
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
      Shop shop = new Shop();
      UseItem useItem = new UseItem();
      int choice = 0;
      int buy = 0;

      Scanner input = new Scanner(System.in);

      menu();
      farmer = new Farmer(monologue());

      while(gameStatus == 1){
         System.out.println("\n[" + farmer.getName().toUpperCase() + "'s farm]");
         System.out.println("\nDay " + day);
         System.out.println("Level: " + farmer.getLevel() + "\t\tCoins: " + farmer.getObjectCoins() + "\nEXP: " + farmer.getExp());
         farm.displayFarm();
         System.out.println("\nACTION:\n [1]Use Tools\t\t[3]Harvest\n [2]Shop\t\t[4]Exit");
         choice = input.nextInt();
         
         if(choice == 1){
            System.out.println("\nTOOLS:\n [1]Plow\t\t [4]Pickaxe\n [2]Watering Can\t [5]Shovel\n [3]Fertilizer");
            choice = input.nextInt();

            System.out.println("\n" + useItem.getTools().get(choice - 1).getToolName().toUpperCase());
            System.out.println("Enter the coordinates of the tile you wish to use the tool: ");
            System.out.print("X: ");
            int x = input.nextInt();
            System.out.print("Y: ");
            int y = input.nextInt();

            switch(choice){
               case 1:
                  useItem.use(farmer, "Plow", x, y);
                  break;
               case 2:
                  useItem.use(farmer, "Watering Can", x, y);
                  break;
               case 3:
                  useItem.use(farmer, "Fertilizer", x, y);
                  break;
               case 4:
              useItem.use(farmer, "Pickaxe", x, y);
                  break;
               case 5:
                  useItem.use(farmer, "Shovel", x, y);
                  break;
            }
         }
         if(choice == 2){
            shop.displayShop();
            buy = input.nextInt();
            shop.buySeeds(farmer, buy, farm);
         }
         if(choice == 4) {
            menu();
            if(gameStatus == 1) farmer = new Farmer(monologue());
         }

         day++;
      }
   }
}
