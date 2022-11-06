package my_farm;

import java.util.ArrayList;
import java.util.Scanner;

public class UseItem {
   private ArrayList<Tools> tools;

   public UseItem() {
      this.tools = new ArrayList<Tools>();

      this.tools.add(new Tools("Plow", 0.0, 0.5));
      this.tools.add(new Tools("Watering Can", 0, 0.5));
      this.tools.add(new Tools("Fertilizer", 10, 4));
      this.tools.add(new Tools("Pickaxe", 50, 15));
      this.tools.add(new Tools("Shovel", 7, 2));
   }

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
                     Farm.waterPlant(farmer, x, y);
                     break;
                  case "Fertilizer":
                     Farm.changeTileState(x, y, "Fertilized");
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

   public void toolMenu(int choice, Farmer farmer){
      Scanner input = new Scanner(System.in);
      int tool = 0;
      int x;
      int y;

      System.out.println("\nTOOLS:\n [1]Plow\t\t [4]Pickaxe\n [2]Watering Can\t [5]Shovel\n [3]Fertilizer");
      tool = input.nextInt();
      
      System.out.println("\n" + getTools().get(choice - 1).getToolName().toUpperCase());
      System.out.println("Enter the coordinates of the tile you wish to use the tool: ");
      System.out.print("X: ");
      x = input.nextInt();
      System.out.print("Y: ");
      y = input.nextInt();

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

   public ArrayList<Tools> getTools() {
      return tools;
   }

   public void setTools(ArrayList<Tools> tools) {
      this.tools = tools;
   }

}
