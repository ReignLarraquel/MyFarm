package my_farm;
/*
 * Plow:       [_]
 * Unplowed:   [ ]
 * Rock:       [¤]
 * Planted:    [v]
 * Crop ready: [Y]
 * Withered:   […]
*/

public class Farm {
   private static String[][] tiles;

   public Farm() {
      Farm.tiles = new String[5][10];

      for(int i = 0; i < 5; i++) {
         for(int j = 0; j < 10; j++) {
            tiles[i][j] = "[]";
         }
      }
   }

   public void printOut() {
      for(int i = 0; i < 5; i++) {
         for(int j = 0; j < 10; j++) {
            System.out.print(tiles[i][j] + " ");
         }
         System.out.println();
      }
   }

   public static void setTile(int x, int y, String tile) {
      tiles[x][y] = tile;
   }

}
