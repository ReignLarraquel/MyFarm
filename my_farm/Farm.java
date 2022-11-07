package my_farm;
/*
 * Plow:       [_]
 * Unplowed:   [ ]
 * Rock:       [¤]
 * Planted:    [v]
 * Crop ready: [Y]
 * Withered:   […]
*/

import java.util.*;

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

   public String checkTileState(int x, int y) {
      for(Tiles tile : tileList) {
         if(tile.getX() == x && tile.getY() == y) {
            return tile.getTileState();
         }
      }
      return null;
   }

   public static void changeTileState(int x, int y, String tileState) {
      for(Tiles tile : Farm.tileList) {
         if(tile.getX() == x && tile.getY() == y) {
            tile.setTileState(tileState);
         }
      }
   }

   public int plantSeed(Seeds seed, int currentDay) {
      Scanner input = new Scanner(System.in);
      int x;
      int y;

      System.out.println("Where would you like to plant your " + seed.getSeedName() + " seeds?");
      System.out.print("X: ");
      x = input.nextInt();
      System.out.print("Y: ");
      y = input.nextInt();
      if(checkTileState(x, y) == "Plowed") { //Fix to check tileState if plowed
         Farm.setTile(x, y, "[v]");
         Farm.changeTileState(x, y, "Planted");

         for(Tiles tile : Farm.tileList) { //This may or may not be error but too lazy to checkS
            if(tile.getX() == x && tile.getY() == y) {
               tile.setSeed(seed, currentDay);
            }
         }
         return 1;
      }

      return 0;
   }

   public static void waterPlant(Farmer farmer, int x, int y) {
      for(Tiles tile : Farm.tileList) {
         if(tile.getX() == x && tile.getY() == y) {
            if(tile.getTileState() == "Planted") {
               tile.setWaterCount(1);
               System.out.println("You watered the plant " + tile.getWaterCount() + " times.");
            } else {
               System.out.println("There is no plant to water.");
            }

         }
      }
   }

   public void checkHarvestDay(int currentDay) {
      for(Tiles tile : Farm.tileList) {
         if(tile.getTileState() == "Planted") {
            if(tile.getDayOfHarvest() == currentDay) {
               if(tile.getWaterCount() >= tile.getSeed().getWaterNeed()){
                  System.out.println("\n  - Your " + tile.getSeed().getSeedName() + " is ready to harvest!");
                  Farm.changeTileState(tile.getX(), tile.getY(), "Must Harvest");
                  Farm.setTile(tile.getX(), tile.getY(), "[Y]");
               }
               else{
                  Farm.changeTileState(tile.getX(), tile.getY(), "Withered");
                  Farm.setTile(tile.getX(), tile.getY(), "[…]");
                  System.out.println("\n  - Your " + tile.getSeed().getSeedName() + " crop has withered.");
               }
            }
         }
      }
   }

   public void harvestPlant(Farmer farmer, int x, int y, int currentDay) {
      double harvestTotal = 0;
      double finalTotal = 0;
      double waterBonus = 0;
      int produce;

      for(Tiles tile : Farm.tileList) {
         if(tile.getX() == x && tile.getY() == y) {
            if(tile.getTileState() == "Must Harvest") {
               produce = tile.getSeed().generateProduce();
               tile.setTileState("Unplowed");
               Farm.setTile(x, y, "[ ]");
               tile.setWaterCount(0);
               tile.setDayOfHarvest(0);
               System.out.println("You harvested " + produce + tile.getSeed().getSeedName() + "s!");

               harvestTotal = produce * (tile.getSeed().getBasePrice() + 0); //Temporarily set to 0
               waterBonus = harvestTotal * 0.2 * (tile.getWaterCount() -1);
               finalTotal = harvestTotal + waterBonus;
               farmer.setObjectCoins(farmer.getObjectCoins() + finalTotal);
               System.out.println("You earned " + finalTotal + " coins!");
               
               farmer.setLevel(farmer.getLevel(), farmer.getExp() + tile.getSeed().getExpEarned());
            }
            else if(tile.getTileState() == "Planted") {
               System.out.println("Your plant is not ready to harvest yet.");
            }
            else if(tile.getTileState() == "Withered")  {
               System.out.println("This has already withered.");
            }
            else if(tile.getTileState() == "Plowed" || tile.getTileState() == "Unplowed") {
               System.out.println("There is no plant to harvest.");
            }
         }
      }
   }
   
}
