package my_farm;
import java.lang.Math;

public class Seeds {
   private String seedName;
   private String cropType;
   private int harvestTime;
   private int waterNeed;
   private int waterBonus;
   private int fertilizerNeed;
   private int fertilizerBonus;
   private double seedCost;
   private int basePrice;
   private double expEarned;
   private int produceMin;
   private int produceMax;

// A constructor with produceMax.
   public Seeds(String seedName, String cropType, int harvestTime, int waterNeed, int waterBonus, int fertilizerNeed, int fertilizerBonus, double seedCost, int basePrice, double expEarned, int produceMin, int produceMax) {
      this.seedName = seedName;
      this.cropType = cropType;
      this.harvestTime = harvestTime;
      this.waterNeed = waterNeed;
      this.waterBonus = waterBonus;
      this.fertilizerNeed = fertilizerNeed;
      this.fertilizerBonus = fertilizerBonus;
      this.seedCost = seedCost;
      this.basePrice = basePrice;
      this.expEarned = expEarned;
      this.produceMin = produceMin;
      this.produceMax = produceMax;
   }

// A constructor without produceMax.
   public Seeds(String seedName, String cropType, int harvestTime, int waterNeed, int waterBonus, int fertilizerNeed, int fertilizerBonus, double seedCost, int basePrice, double expEarned, int produceMin) {
      this.seedName = seedName;
      this.cropType = cropType;
      this.harvestTime = harvestTime;
      this.waterNeed = waterNeed;
      this.waterBonus = waterBonus;
      this.fertilizerNeed = fertilizerNeed;
      this.fertilizerBonus = fertilizerBonus;
      this.seedCost = seedCost;
      this.basePrice = basePrice;
      this.expEarned = expEarned;
      this.produceMin = produceMin;
      this.produceMax = produceMin;
   }

   /**
    * Generate a random number between the minimum and maximum produce values
    * 
    * @return A random number between the produceMin and produceMax
    */
   public int generateProduce() {
      return (int) Math.floor((Math.random() * (this.produceMax - this.produceMin + 1) + this.produceMin));
   }  

   /**
    * This function returns the name of the seed
    * 
    * @return The seedName variable is being returned.
    */
   public String getSeedName() {
      return seedName;
   }

   /**
    * This function sets the seedName variable to the value of the seedName parameter
    * 
    * @param seedName The name of the seed.
    */
   public void setSeedName(String seedName) {
      this.seedName = seedName;
   }

   /**
    * This function returns the crop type of the crop object
    * 
    * @return The cropType variable is being returned.
    */
   public String getCropType() {
      return cropType;
   }

   /**
    * This function sets the crop type of the field
    * 
    * @param cropType The type of crop to be grown.
    */
   public void setCropType(String cropType) {
      this.cropType = cropType;
   }

   /**
    * This function returns the value of the variable harvestTime
    * 
    * @return The harvestTime variable is being returned.
    */
   public int getHarvestTime() {
      return harvestTime;
   }

   /**
    * This function sets the harvest time of the crop to the value passed in as a parameter
    * 
    * @param harvestTime The amount of time it takes to harvest the crop.
    */
   public void setHarvestTime(int harvestTime) {
      this.harvestTime = harvestTime;
   }

   /**
    * This function returns the value of the waterNeed variable.
    * 
    * @return The waterNeed variable is being returned.
    */
   public int getWaterNeed() {
      return waterNeed;
   }

   /**
    * This function sets the waterNeed variable to the value of the waterNeed parameter.
    * 
    * @param waterNeed The amount of water a plant needs
    */
   public void setWaterNeed(int waterNeed) {
      this.waterNeed = waterNeed;
   }

   /**
    * This function returns the waterBonus of the current object
    * 
    * @return The waterBonus variable is being returned.
    */
   public int getWaterBonus() {
      return waterBonus;
   }

   /**
    * This function sets the waterBonus variable to the value of the waterBonus parameter
    * 
    * @param waterBonus The amount of water that the plant will give to the soil when it dies.
    */
   public void setWaterBonus(int waterBonus) {
      this.waterBonus = waterBonus;
   }

   /**
    * This function returns the amount of fertilizer needed for the plant
    * 
    * @return The value of the fertilizerNeed variable.
    */
   public int getFertilizerNeed() {
      return fertilizerNeed;
   }

   /**
    * This function sets the fertilizerNeed variable to the value passed in as a parameter
    * 
    * @param fertilizerNeed The amount of fertilizer needed to grow the crop.
    */
   public void setFertilizerNeed(int fertilizerNeed) {
      this.fertilizerNeed = fertilizerNeed;
   }

   /**
    * This function returns the fertilizerBonus of the plant
    * 
    * @return The fertilizerBonus variable is being returned.
    */
   public int getFertilizerBonus() {
      return fertilizerBonus;
   }

   /**
    * This function sets the fertilizerBonus variable to the value of the fertilizerBonus parameter
    * 
    * @param fertilizerBonus The amount of fertilizer that is applied to the soil when the crop is
    * harvested.
    */
   public void setFertilizerBonus(int fertilizerBonus) {
      this.fertilizerBonus = fertilizerBonus;
   }

   /**
    * This function returns the seed cost of the crop
    * 
    * @return The seedCost variable is being returned.
    */
   public double getSeedCost() {
      return seedCost;
   }

   /**
    * This function sets the seed cost of the crop
    * 
    * @param seedCost The cost of the seed.
    */
   public void setSeedCost(double seedCost) {
      this.seedCost = seedCost;
   }

   /**
    * This function returns the base price of the car.
    * 
    * @return The basePrice variable is being returned.
    */
   public int getBasePrice() {
      return basePrice;
   }

   /**
    * This function sets the base price of the car.
    * 
    * @param basePrice The base price of the item.
    */
   public void setBasePrice(int basePrice) {
      this.basePrice = basePrice;
   }

   /**
    * This function returns the amount of experience earned by the player
    * 
    * @return The expEarned variable is being returned.
    */
   public double getExpEarned() {
      return expEarned;
   }

   /**
    * This function sets the value of the expEarned variable to the value of the expEarned parameter
    * 
    * @param expEarned The amount of experience earned by the player.
    */
   public void setExpEarned(double expEarned) {
      this.expEarned = expEarned;
   }

   /**
    * This function returns the minimum amount of produce that can be produced by the farm
    * 
    * @return The produceMin variable is being returned.
    */
   public int getProduceMin() {
      return produceMin;
   }

   /**
    * This function sets the minimum amount of produce that can be produced by a farm
    * 
    * @param produceMin The minimum amount of time (in seconds) that the producer will wait before
    * producing another item.
    */
   public void setProduceMin(int produceMin) {
      this.produceMin = produceMin;
   }

   /**
    * This function returns the maximum amount of produce that can be produced by the farm
    * 
    * @return The produceMax variable is being returned.
    */
   public int getProduceMax() {
      return produceMax;
   }

   /**
    * This function sets the maximum number of items that can be produced by the factory
    * 
    * @param produceMax The maximum amount of produce that can be produced in a single day.
    */
   public void setProduceMax(int produceMax) {
      this.produceMax = produceMax;
   }   
}
