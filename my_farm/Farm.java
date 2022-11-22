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

   // This is the constructor of the Farm class. It initializes the tiles array and the tileList
   // ArrayList.
   public Farm() {
      Farm.tiles = new String[5][10]; 
      Farm.tileList = new ArrayList<Tiles>();

      Farm.tiles = new String[5][10];
      for(int i = 0; i < 5; i++) {
         for(int j = 0; j < 10; j++) {
            tiles[i][j] = "[ ]";
            tileList.add(new Tiles(i, j, "Unplowed"));
         }
      }

      generateRocks();
   }

/**
 * It prints out the farm
 */
   public void displayFarm() {
      System.out.println(" ___________________________________________");
      System.out.println("/                                           \\");

      for(int i = 0; i < 5; i++) {
         System.out.print("|  ");
         for(int j = 0; j < 10; j++) {
            System.out.print(tiles[i][j] + " ");
         }
         System.out.print(" |");
         System.out.println();
      }
      System.out.println("\\___________________________________________/");
   }

   public void generateRocks() {
      int rockCount = (int)Math.floor(Math.random() * ( 30 - 10 + 1) + 10);
      int i = 0;

      while(i <= rockCount) {
         int x = (int)Math.floor(Math.random() * 5);
         int y = (int)Math.floor(Math.random() * 10);
         if(checkTileState(x, y) == "Unplowed") {
            setTile(x, y, "[¤]");
            changeTileState(x, y, "rock");
            i++;
         }
      }
   }

/**
 * This function sets the tile at the given x and y coordinates to the given tile.
 * 
 * @param x The x coordinate of the tile you want to change.
 * @param y The y coordinate of the tile to set.
 * @param tile The tile to be set.
 */
   public static void setTile(int x, int y, String tile) {
      tiles[x][y] = tile;
   }

/**
 * This function checks the state of a tile at a given x and y coordinate
 * 
 * @param x The x coordinate of the tile you want to check.
 * @param y The y coordinate of the tile
 * 
 * @return The tile state of the tile at the given coordinates.
 */
   public String checkTileState(int x, int y) {
      for(Tiles tile : tileList) {
         if(tile.getX() == x && tile.getY() == y) {
            return tile.getTileState();
         }
      }
      return null;
   }

/**
 * This function takes in an x and y coordinate and a tile state, and then it loops through the
 * tileList and finds the tile that matches the x and y coordinate, and then it changes the tile state
 * of that tile to the tile state that was passed in
 * 
 * @param x The x coordinate of the tile you want to change.
 * @param y The y coordinate of the tile you want to change.
 * @param tileState The state of the tile.
 */
   public static void changeTileState(int x, int y, String tileState) {
      for(Tiles tile : Farm.tileList) {
         if(tile.getX() == x && tile.getY() == y) {
            tile.setTileState(tileState);
         }
      }
   }

   /**
    * It takes in a seed and the current day, and then plants the seed in the tile the user specifies
    * 
    * @param seed The seed that the user wants to plant
    * @param currentDay The current day of the game
    * 
    * @return The method is returning an int.
    */
   public int plantSeed(Game game, Seeds seed, int currentDay) {
      Scanner input = new Scanner(System.in);
      int x = 10;
      int y = 10;

      while(Tiles.isTileExist(x, y) == false){
         System.out.println("Where would you like to plant your " + seed.getSeedName() + " seeds?");
         System.out.print("X: ");
         x = input.nextInt();
         System.out.print("Y: ");
         y = input.nextInt();         
         if(Tiles.isTileExist(x, y) == false) System.out.println("Coordinates does not exist. Try again.\n\n");
      }

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

/**
 * It counts the number of times the plant is watered
 * 
 * @param farmer The farmer object that is currently playing the game.
 * @param x the x coordinate of the tile
 * @param y The y coordinate of the tile you want to water.
 */
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

/**
 * If the current day is the same as the day of harvest, then the tile state is changed to "Must
 * Harvest" or "Withered" depending on the water count
 * 
 * @param currentDay The current day of the game.
 */
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

  /**
   * The harvestPlant function checks if the tile is ready to be harvested, and if it is, it will
   * harvest the plant and give the player the coins and experience earned
   * 
   * @param farmer The farmer object
   * @param x x-coordinate of the tile
   * @param y y-coordinate of the tile
   * @param currentDay The current day of the game.
   */
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

   public static ArrayList<Tiles> getTileList() {
      return tileList;
   }

   
}
