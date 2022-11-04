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

   
}
