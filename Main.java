import my_farm.*;
import java.util.Scanner;

public class Main {
   public static int gameStatus = 0;
   public static int day = 0;

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

            if(game.gameOver(farm, farmer) == 1) {
               gameStatus = 2;
               advanceDay = 1;
               System.out.println("\nAll your plants have withered...\n\n[YOU LOSE]");
            }
            else if(game.gameOver(farm, farmer) == 2) {
               gameStatus = 2;
               advanceDay = 1;
               System.out.println("\nYou have no more coins...\n\n[YOU LOSE]");
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
                  gameStatus = game.menu();
                  advanceDay = 1;
                  if(gameStatus == 1) farmer = new Farmer(game.monologue());
               }
   
            }
         }


      }
   }
}
