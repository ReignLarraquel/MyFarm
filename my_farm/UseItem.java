package my_farm;

import java.util.ArrayList;

public class UseItem {
   private ArrayList<Tools> tools;

   public UseItem() {
      this.tools = new ArrayList<Tools>();

      this.tools.add(new Tools("Plow", 0, 0.5));
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
               
               switch(toolName) {
                  case "Plow":
                     Farm.setTile(x, y, "[_]");
                     Farm.changeTileState(x, y, "Plowed");
                     break;
                  case "Watering Can":
                     Farm.changeTileState(x, y, "Watered");
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

            } else {
               System.out.println("You do not have enough coins to use a" + tool.getToolName() + ".");
            }
         }
      }
   }
}
