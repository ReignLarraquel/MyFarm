package my_farm;

import java.util.ArrayList;

public class Farmer {
   private String name;
   private int objectCoins;
   private Level level;
   private ArrayList<Seeds> seeds;

   public Farmer(String name) {
      this.objectCoins = 100;
      this.level = new Level(0, 0);
      this.seeds = new ArrayList<Seeds>();
   }

   public int getObjectCoins() {
      return objectCoins;
   }

   public void setObjectCoins(int objectCoins) {
      this.objectCoins = objectCoins;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Level getLevel() {
      return level;
   }

   public void setLevel(int level, double exp) {
      this.level = new Level(level, exp);
   }

   public ArrayList<Seeds> getSeeds() {
      return seeds;
   }

   public void addSeeds(Seeds seed) {
      seeds.add(seed);
   }

}
