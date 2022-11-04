package my_farm;

public class Level {
   private int level = 0;
   private double exp = 0;

   public void gainExp(double exp) {
      this.exp += exp;
      if (this.exp >= 100) {
         this.level++;
         this.exp -= 100;
         System.out.println("You have leveled up to level " + this.level + "!");
      }
   }

   public int getLevel() {
      return this.level;
   }

   public double getExp() {
      return this.exp;
   }
}
