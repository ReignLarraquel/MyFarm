package my_farm;

import java.util.ArrayList;

public class Farmer {
   private String name;
   private double objectCoins;
   private Level level;
   private ArrayList<Seeds> seeds;

   public Farmer(String name) {
      this.name = name;
      this.objectCoins = 100;
      this.level = new Level(0, 0);
      this.seeds = new ArrayList<Seeds>();
   }

   public double getObjectCoins() {
      return objectCoins;
   }

   public void setObjectCoins(double objectCoins) {
      this.objectCoins = objectCoins;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getLevel() {
      return level.getLevel();
   }
   public double getExp(){
      return level.getExp();
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
