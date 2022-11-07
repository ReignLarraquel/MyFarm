package my_farm;

public class Level {
   private int level;
   private double exp;

   // A constructor.
   public Level(int level, double exp) {
      this.level = level;
      this.exp = exp;
   }

   /**
    * This function returns the level of the current object.
    * 
    * @return The level of the player.
    */
   public int getLevel() {
      return this.level;
   }

   /**
    * This function returns the value of the private variable exp
    * 
    * @return The value of the instance variable exp.
    */
   public double getExp() {
      return this.exp;
   }

   /**
    * This function sets the level of the player to the level passed in as a parameter.
    * 
    * @param level The level of the player.
    */
   public void setLevel(int level) {
      this.level = level;
   }

   /**
    * This function sets the value of the exp variable to the value of the exp parameter.
    * 
    * @param exp The amount of experience the player has.
    */
   public void setExp(double exp) {
      this.exp = exp;
   }
   
}
