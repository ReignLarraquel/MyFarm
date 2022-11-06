package my_farm;

public class Tools {
   private String toolName;
   private double usageCost;
   private double expEarned;

   public Tools(String toolName, double usageCost, double expEarned) {
      this.toolName = toolName;
      this.usageCost = usageCost;
      this.expEarned = expEarned;
   }

   public String getToolName() {
      return this.toolName;
   }

   public double getUsageCost() {
      return this.usageCost;
   }

   public double getExpEarned() {
      return this.expEarned;
   }

   public void setToolName(String toolName) {
      this.toolName = toolName;
   }

   public void setUsageCost(double usageCost) {
      this.usageCost = usageCost;
   }

   public void setExpEarned(double expEarned) {
      this.expEarned = expEarned;
   }
}
