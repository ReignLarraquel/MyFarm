package my_farm;

import java.util.ArrayList;

public class Farmer {
   private String name;
   private double objectCoins;
   private Level level;
   private ArrayList<Seeds> seeds;

   // A constructor.
   public Farmer(String name) {
      this.name = name;
      this.objectCoins = 100;
      this.level = new Level(0, 0);
      this.seeds = new ArrayList<Seeds>();
   }

   /**
   * This function returns the value of the objectCoins variable
   * 
   * @return The value of the objectCoins variable.
   */
   public double getObjectCoins() {
      return objectCoins;
   }

   /**
   * This function sets the value of the objectCoins variable to the value of the objectCoins parameter
   * 
   * @param objectCoins The amount of coins the object is worth.
   */
   // Setting the value of the objectCoins variable to the value of the objectCoins parameter.
   public void setObjectCoins(double objectCoins) {
      this.objectCoins = objectCoins;
   }

   /**
    * This function returns the name of the person
    * 
    * @return The name of the person.
    */
   public String getName() {
      return name;
   }

   /**
    * This function sets the name of the object to the name passed in as a parameter
    * 
    * @param name The name of the parameter.
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * This function returns the level of the logger.
    * 
    * @return The level of the logger.
    */
   public int getLevel() {
      return level.getLevel();
   }
   
   /**
    * This function returns the current experience of the player.
    * 
    * @return The exp of the level.
    */
   public double getExp(){
      return level.getExp();
   }

   public void setLevel(int level, double exp) {
      this.level = new Level(level, exp);
   }

   /**
    * This function returns the seeds of the current game
    * 
    * @return An ArrayList of Seeds.
    */
   public ArrayList<Seeds> getSeeds() {
      return seeds;
   }

   /**
    * This function adds a seed to the list of seeds
    * 
    * @param seed The seed to add to the list of seeds.
    */
   public void addSeeds(Seeds seed) {
      seeds.add(seed);
   }

}
