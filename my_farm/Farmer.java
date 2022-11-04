package my_farm;

import java.util.ArrayList;

public class Farmer {
   private int objectCoins;
   private Level level;
   private ArrayList<Seeds> seeds;

   public Farmer(int objectCoins, Level level) {
      this.objectCoins = objectCoins;
      this.level = level;
      this.seeds = new ArrayList<Seeds>();
   }

   public int getObjectCoins() {
      return objectCoins;
   }

   public void setObjectCoins(int objectCoins) {
      this.objectCoins = objectCoins;
   }

   public Level getLevel() {
      return level;
   }

   public void setLevel(Level level) {
      this.level = level;
   }

   public ArrayList<Seeds> getSeeds() {
      return seeds;
   }

   public void addSeeds(Seeds seed) {
      seeds.add(seed);
   }

}
