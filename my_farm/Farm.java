package my_farm;
/*
 * Plow:       [_]
 * Unplowed:   [ ]
 * Rock:       [¤]
 * Planted:    [v]
 * Crop ready: [Y]
 * Withered:   […]
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Farm {
   private static String[][] tiles;
   private static ArrayList<Tiles> tileList;

   public Farm() {
      Farm.tiles = new String[1][1]; // Change to 5x10 after MCO1
      Farm.tileList = new ArrayList<Tiles>();

      //Remove after MCO1
      tiles[0][0] = "[ ]";
      tileList.add(new Tiles(0, 0, "Unplowed"));

      //Uncomment after MCO1
      // Farm.tiles = new String[5][10];
      // for(int i = 0; i < 5; i++) {
      //    for(int j = 0; j < 10; j++) {
      //       tiles[i][j] = "[ ]";
      //       tileList.add(new Tiles(i, j, "Unplowed"));
      //    }
      // }
   }

   public void displayFarm() {
      System.out.println("\n\t\t" + tiles[0][0]);

      // Uncomment once MCO1 is complete
      // System.out.println(" ___________________________________________");
      // System.out.println("/                                           \\");

      // for(int i = 0; i < 5; i++) {
      //    System.out.print("|  ");
      //    for(int j = 0; j < 10; j++) {
      //       System.out.print(tiles[i][j] + " ");
      //    }
      //    System.out.print(" |");
      //    System.out.println();
      // }
      // System.out.println("\\___________________________________________/");
   }

   public static void setTile(int x, int y, String tile) {
      tiles[x][y] = tile;
   }

   public void checkTileState(int x, int y) {
      for(Tiles tile : tileList) {
         if(tile.getX() == x && tile.getY() == y) {
            System.out.println(tile.getTileState());
         }
      }
   }

   public static void changeTileState(int x, int y, String tileState) {
      for(Tiles tile : Farm.tileList) {
         if(tile.getX() == x && tile.getY() == y) {
            tile.setTileState(tileState);
         }
      }
   }

   public void plantSeed(Seeds seed) {
      Scanner input = new Scanner(System.in);
      int x;
      int y;

      System.out.println("Where would you like to plant your " + seed.getSeedName() + " seeds?");
      System.out.println("X: ");
      x = input.nextInt();
      System.out.println("Y: ");
      y = input.nextInt();
      //if(Farm.getTileState(x, y).equals("Unplowed")) { //Fix to check tileState if plowed
            Farm.setTile(x, y, "[v]");
            Farm.changeTileState(x, y, "Planted");

            for(Tiles tile : Farm.tileList) { //This may or may not be error but too lazy to checkS
               if(tile.getX() == x && tile.getY() == y) {
                  tile.setSeed(seed);
               }
            }
      //}


   }

}
