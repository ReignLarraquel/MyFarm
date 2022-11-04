package my_farm;

public class Tools {
   private String toolName;
   private int usageCost;
   private double expEarned;

   public Tools(String toolName, int usageCost, double expEarned) {
      this.toolName = toolName;
      this.usageCost = usageCost;
      this.expEarned = expEarned;
   }

   public String getToolName() {
      return this.toolName;
   }

   public int getUsageCost() {
      return this.usageCost;
   }

   public double getExpEarned() {
      return this.expEarned;
   }

   public void setToolName(String toolName) {
      this.toolName = toolName;
   }

   public void setUsageCost(int usageCost) {
      this.usageCost = usageCost;
   }

   public void setExpEarned(double expEarned) {
      this.expEarned = expEarned;
   }
}
