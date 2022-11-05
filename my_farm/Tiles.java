package my_farm;
public class Tiles {
   private int x;
   private int y;
   private String tileState;  
   private Seeds seed;

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

   public void setSeed(Seeds seed) {
      this.seed = seed;
   }
}
