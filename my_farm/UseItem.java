package my_farm;

import java.util.ArrayList;
import java.util.Scanner;

public class UseItem {
   private ArrayList<Tools> tools;

   // A constructor that initializes the tools arraylist and adds the tools to it.
   public UseItem() {
      this.tools = new ArrayList<Tools>();

      this.tools.add(new Tools("Plow", 0.0, 0.5));
      this.tools.add(new Tools("Watering Can", 0, 0.5));
      this.tools.add(new Tools("Fertilizer", 10, 4));
      this.tools.add(new Tools("Pickaxe", 50, 15));
      this.tools.add(new Tools("Shovel", 7, 2));
   }

   /**
    * The function checks if the tool is in the farmer's inventory, and if it is, it checks if the
    * farmer has enough coins to use the tool, and if he does, it uses the tool
    * 
    * @param farmer the farmer object
    * @param toolName The name of the tool to be used.
    * @param x x-coordinate of the tile
    * @param y the y coordinate of the tile
    */
   public void use(Farmer farmer, String toolName, int x, int y) {
      for (Tools tool : this.tools) {
         if (toolName == tool.getToolName()) {
            if (farmer.getObjectCoins() >= tool.getUsageCost()) {
               farmer.setObjectCoins(farmer.getObjectCoins() - tool.getUsageCost());
               farmer.setLevel(farmer.getLevel(), farmer.getExp() + tool.getExpEarned());
               
               switch(toolName) {
                  case "Plow":
                     Farm.setTile(x, y, "[_]");
                     Farm.changeTileState(x, y, "Plowed");
                     break;
                  case "Watering Can":
                     waterPlant(farmer, x, y);
                     break;
                  case "Fertilizer":
                     //Add fertilizer code here
                     break;
                  case "Pickaxe":
                     Farm.setTile(x, y, "[ ]");
                     Farm.changeTileState(x, y, "Unplowed");
                     break;
                  case "Shovel":
                     Farm.setTile(x, y, "[ ]");
                     Farm.changeTileState(x, y, "Unplowed");
                     break;
               } 
            } 
            else {
               System.out.println("You do not have enough coins to use a" + tool.getToolName() + ".");
            }
         }
      }
   }

   /**
    * It's a function that allows the user to choose a tool from the tool menu and use it on a tile
    * 
    * @param choice the choice of the user in the menu
    * @param farmer the farmer object
    */
   public void toolMenu(Game game, int choice, Farmer farmer){
      Scanner input = new Scanner(System.in);
      int tool = 0;
      int x = 10;
      int y = 10;

      while(game.checkInput(1, 5, tool)){
         System.out.println("\nTOOLS:\n [1]Plow\t\t [4]Pickaxe\n [2]Watering Can\t [5]Shovel\n [3]Fertilizer");
         tool = input.nextInt();      
         if(game.checkInput(1, 5, tool)) game.InvalidInput();
      }

      while(game.checkInput(0, 4, x) || game.checkInput(0, 9, y)){
         System.out.println("\n" + getTools().get(choice - 1).getToolName().toUpperCase());
         System.out.println("Enter the coordinates of the tile you wish to use the tool: ");
         System.out.print("X: ");
         x = input.nextInt();
         System.out.print("Y: ");
         y = input.nextInt();
         if(game.checkInput(0, 4, x) || game.checkInput(0, 9, y)) System.out.println("Coordinates does not exist. Try again.\n\n");
      }

      switch(tool){
         case 1:
            use(farmer, "Plow", x, y);
            break;
         case 2:
            use(farmer, "Watering Can", x, y);
            break;
         case 3:
            use(farmer, "Fertilizer", x, y);
            break;
         case 4:
            use(farmer, "Pickaxe", x, y);
            break;
         case 5:
            use(farmer, "Shovel", x, y);
            break;
      }
   }

      /**
    * It counts the number of times the plant is watered
    * 
    * @param farmer The farmer object that is currently playing the game.
    * @param x the x coordinate of the tile
    * @param y The y coordinate of the tile you want to water.
    */
   public static void waterPlant(Farmer farmer, int x, int y) {
      for(Tiles tile : Farm.getTileList()) {
         if(tile.getX() == x && tile.getY() == y) {
            if(tile.getTileState() == "Planted") {
               tile.setWaterCount(1);
               System.out.println("You watered the plant " + tile.getWaterCount() + " times.");
            } else {
               System.out.println("There is no plant to water.");
            }

         }
      }
   }  
      
   /**
    * This function returns the tools array list
    * 
    * @return An ArrayList of Tools
    */
   public ArrayList<Tools> getTools() {
      return tools;
   }

   /**
    * This function sets the tools of the class to the tools passed in
    * 
    * @param tools The list of tools that the user has.
    */
   public void setTools(ArrayList<Tools> tools) {
      this.tools = tools;
   }

}
