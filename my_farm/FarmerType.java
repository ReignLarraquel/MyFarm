package my_farm;

public class FarmerType {
   private String farmerType;   
   private int level;
   private int bonusEarn;
   private int seedCostReduct;
   private int waterBonus;
   private int fertilizerBonus;
   private int fee;

   public FarmerType(String farmerType, int level, int bonusEarn, int seedCostReduct, int waterBonus, int fertilizerBonus, int fee) {
      this.farmerType = farmerType;
      this.level = level;
      this.bonusEarn = bonusEarn;
      this.seedCostReduct = seedCostReduct;
      this.waterBonus = waterBonus;
      this.fertilizerBonus = fertilizerBonus;
      this.fee = fee;
   }
   
   public String getFarmerType() {
      return farmerType;
   }

   public void setFarmerType(String farmerType) {
      this.farmerType = farmerType;
   }

   public int getLevel() {
      return level;
   }

   public void setLevel(int level) {
      this.level = level;
   }

   public int getBonusEarn() {
      return bonusEarn;
   }

   public void setBonusEarn(int bonusEarn) {
      this.bonusEarn = bonusEarn;
   }

   public int getSeedCostReduct() {
      return seedCostReduct;
   }

   public void setSeedCostReduct(int seedCostReduct) {
      this.seedCostReduct = seedCostReduct;
   }

   public int getWaterBonus() {
      return waterBonus;
   }

   public void setWaterBonus(int waterBonus) {
      this.waterBonus = waterBonus;
   }

   public int getFertilizerBonus() {
      return fertilizerBonus;
   }

   public void setFertilizerBonus(int fertilizerBonus) {
      this.fertilizerBonus = fertilizerBonus;
   }

   public int getFee() {
      return fee;
   }

   public void setFee(int fee) {
      this.fee = fee;
   }

}
