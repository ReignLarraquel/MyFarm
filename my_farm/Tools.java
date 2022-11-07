package my_farm;

public class Tools {
   private String toolName;
   private double usageCost;
   private double expEarned;

   // A constructor.
   public Tools(String toolName, double usageCost, double expEarned) {
      this.toolName = toolName;
      this.usageCost = usageCost;
      this.expEarned = expEarned;
   }

   /**
    * This function returns the name of the tool
    * 
    * @return The tool name.
    */
   public String getToolName() {
      return this.toolName;
   }

   /**
    * This function returns the usage cost of the current instance of the class
    * 
    * @return The usage cost of the appliance.
    */
   public double getUsageCost() {
      return this.usageCost;
   }

   /**
    * This function returns the amount of experience earned by the player
    * 
    * @return The expEarned variable is being returned.
    */
   public double getExpEarned() {
      return this.expEarned;
   }

   /**
    * This function sets the tool name to the value of the parameter
    * 
    * @param toolName The name of the tool.
    */
   public void setToolName(String toolName) {
      this.toolName = toolName;
   }

   /**
    * This function sets the usage cost of the phone
    * 
    * @param usageCost The cost of the usage.
    */
   public void setUsageCost(double usageCost) {
      this.usageCost = usageCost;
   }

   /**
    * This function sets the value of the expEarned variable to the value of the expEarned parameter
    * 
    * @param expEarned The amount of experience earned by the player.
    */
   public void setExpEarned(double expEarned) {
      this.expEarned = expEarned;
   }
}
