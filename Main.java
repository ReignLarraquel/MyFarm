import my_farm.*;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Farm farm = new Farm();
      Farmer farmer;
      String name = "";

      //Setup Map:
      Game game = new Game();
      Shop shop = new Shop();
      UseItem useItem = new UseItem();
      int gameStatus = 0;
      int choice = 0;
      int buy = 0;
      int advanceDay = 2;
      int x = 10;
      int y = 10;

      Scanner input = new Scanner(System.in);

      gameStatus = game.menu();
      if(gameStatus == 1) name = game.monologue();
      farmer = new Farmer(name);

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
                  useItem.toolMenu(game, choice, farmer);
                  
                  advanceDay = game.advanceDay();
               }
               if(choice == 2){
                  while(game.checkInput(1, 1, buy)){
                     shop.displayShop();
                     buy = input.nextInt();
                     if(game.checkInput(1, 1, buy)) game.InvalidInput();
                  }
                     shop.buySeeds(game, farmer, buy - 1, farm, game.getDay());
   
                  advanceDay = game.advanceDay();
               }
               if(choice == 3){
                  while(game.checkInput(0, 0, x) || game.checkInput(0, 0, y)){
                     System.out.println("Enter the coordinates of the tile you wish to harvest: ");
                     System.out.print("X: ");
                     x = input.nextInt();
                     System.out.print("Y: ");
                     y = input.nextInt();   

                     if(game.checkInput(0, 0, x) || game.checkInput(0, 0, y)) System.out.println("Coordinates does not exist. Try again.\n\n");
                  }
   
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
