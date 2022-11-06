package my_farm;
public class Tiles {
   private int x;
   private int y;
   private String tileState;  
   private Seeds seed;
   private int waterCount;
   private int fertilizerCount;
   private int dayOfHarvest;

   public Tiles(int x, int y, String tileState) {
      this.x = x;
      this.y = y;
      this.tileState = tileState;

      seed = null;
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }
      
   public String getTileState() {
      return tileState;
   }

   public void setTileState(String tileState) {
      this.tileState = tileState;
   }

   public Seeds getSeed() {
      return seed;
   }

   public int getDayOfHarvest() {
      return dayOfHarvest;
   }

   public void setDayOfHarvest(int day){
      this.dayOfHarvest =  day;
   }

   public void setSeed(Seeds seed, int currentDay) {
      this.seed = seed;
      this.dayOfHarvest = this.seed.getHarvestTime() + currentDay;
   }

   public int getWaterCount() {
      return waterCount;
   }

   public void setWaterCount(int waterCount) {
      this.waterCount += waterCount;

      if(this.waterCount > this.seed.getWaterBonus()) {
         this.waterCount = this.seed.getWaterBonus();
      }
   }

   public int getFertilizerCount() {
      return fertilizerCount;
   }

   public void setFertilizerCount(int fertilizerCount) {
      this.fertilizerCount = fertilizerCount;
   }
}
