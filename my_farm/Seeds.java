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

   public int generateProduce() {
      return (int) (Math.random() * (this.produceMax - this.produceMin + 1) + this.produceMin);
   }  

   public String getSeedName() {
      return seedName;
   }

   public void setSeedName(String seedName) {
      this.seedName = seedName;
   }

   public String getCropType() {
      return cropType;
   }

   public void setCropType(String cropType) {
      this.cropType = cropType;
   }

   public int getHarvestTime() {
      return harvestTime;
   }

   public void setHarvestTime(int harvestTime) {
      this.harvestTime = harvestTime;
   }

   public int getWaterNeed() {
      return waterNeed;
   }

   public void setWaterNeed(int waterNeed) {
      this.waterNeed = waterNeed;
   }

   public int getWaterBonus() {
      return waterBonus;
   }

   public void setWaterBonus(int waterBonus) {
      this.waterBonus = waterBonus;
   }

   public int getFertilizerNeed() {
      return fertilizerNeed;
   }

   public void setFertilizerNeed(int fertilizerNeed) {
      this.fertilizerNeed = fertilizerNeed;
   }

   public int getFertilizerBonus() {
      return fertilizerBonus;
   }

   public void setFertilizerBonus(int fertilizerBonus) {
      this.fertilizerBonus = fertilizerBonus;
   }

   public double getSeedCost() {
      return seedCost;
   }

   public void setSeedCost(double seedCost) {
      this.seedCost = seedCost;
   }

   public int getBasePrice() {
      return basePrice;
   }

   public void setBasePrice(int basePrice) {
      this.basePrice = basePrice;
   }

   public double getExpEarned() {
      return expEarned;
   }

   public void setExpEarned(double expEarned) {
      this.expEarned = expEarned;
   }

   public int getProduceMin() {
      return produceMin;
   }

   public void setProduceMin(int produceMin) {
      this.produceMin = produceMin;
   }

   public int getProduceMax() {
      return produceMax;
   }

   public void setProduceMax(int produceMax) {
      this.produceMax = produceMax;
   }   
}
