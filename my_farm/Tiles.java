package my_farm;
public class Tiles {
   private int x;
   private int y;
   private String tileState;  
   private Seeds seed;
   private int waterCount;
   private int fertilizerCount;
   private int dayOfHarvest;

   // A constructor.
   public Tiles(int x, int y, String tileState) {
      this.x = x;
      this.y = y;
      this.tileState = tileState;

      seed = null;
   }

   /**
    * This function returns the value of the variable x
    * 
    * @return The value of the x variable.
    */
   public int getX() {
      return x;
   }

   /**
    * This function sets the value of the variable x to the value of the parameter x.
    * 
    * @param x The x coordinate of the point.
    */
   public void setX(int x) {
      this.x = x;
   }

   /**
    * This function returns the value of the y variable.
    * 
    * @return The y value of the point.
    */
   public int getY() {
      return y;
   }

   /**
    * This function sets the y value of the object to the value of the parameter y.
    * 
    * @param y The y coordinate of the point.
    */
   public void setY(int y) {
      this.y = y;
   }
      
   /**
    * This function returns the tileState of the tile
    * 
    * @return The tileState variable is being returned.
    */
   public String getTileState() {
      return tileState;
   }

   /**
    * This function sets the tileState of the tile to the tileState passed in as a parameter
    * 
    * @param tileState The state of the tile. 
    */
   public void setTileState(String tileState) {
      this.tileState = tileState;
   }

   /**
    * This function returns the seed planted on the tile
    * 
    * @return The seed.
    */
   public Seeds getSeed() {
      return seed;
   }

   /**
    * This function returns the day of harvest
    * 
    * @return The day of harvest.
    */
   public int getDayOfHarvest() {
      return dayOfHarvest;
   }

   /**
    * This function sets the day of harvest to the value of the parameter day
    * 
    * @param day The day of the harvest.
    */
   public void setDayOfHarvest(int day){
      this.dayOfHarvest =  day;
   }

   /**
    * This function sets the seed of the field to the seed passed in, and sets the day of harvest to
    * the current day plus the harvest time of the seed.
    * 
    * @param seed The seed that is planted in the plot.
    * @param currentDay The current day of the game.
    */
   public void setSeed(Seeds seed, int currentDay) {
      this.seed = seed;
      this.dayOfHarvest = this.seed.getHarvestTime() + currentDay;
   }

   /**
    * This function returns the number of water tiles in the game
    * 
    * @return The number of water tiles in the map.
    */
   public int getWaterCount() {
      return waterCount;
   }

   /**
    * This function adds the amount of water to the plant, but it won't let the plant have more water
    * than it needs.
    * 
    * @param waterCount The amount of water the plant has.
    */
   public void setWaterCount(int waterCount) {
      this.waterCount += waterCount;

      if(this.waterCount > this.seed.getWaterBonus()) {
         this.waterCount = this.seed.getWaterBonus();
      }
   }

   /**
    * This function returns the number of fertilizer bags that are in the barn
    * 
    * @return The number of fertilizerCount.
    */
   public int getFertilizerCount() {
      return fertilizerCount;
   }

   /**
    * This function sets the fertilizerCount variable to the value of the parameter fertilizerCount
    * 
    * @param fertilizerCount The number of fertilizer items the player has.
    */
   public void setFertilizerCount(int fertilizerCount) {
      this.fertilizerCount = fertilizerCount;
   }
}
