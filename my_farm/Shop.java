package my_farm;

import java.util.ArrayList;

public class Shop {
   private ArrayList<Seeds> seeds;

// This is the constructor of the Shop class. It is initializing the seeds ArrayList and adding the
// different types of seeds to the ArrayList.
   public Shop() {
      this.seeds = new ArrayList<Seeds>();

      this.seeds.add(new Seeds("Turnip", "Root crop", 2, 1, 2, 0, 1, 5.0, 6, 5, 1, 2));
      this.seeds.add(new Seeds("Carrot", "Root crop", 3, 1, 2, 0, 1, 10, 9, 7.5, 1, 2));
      this.seeds.add(new Seeds("Potato", "Root crop", 5, 3, 4, 1, 2, 20, 3, 12.5, 1, 10));
      this.seeds.add(new Seeds("Rose", "Flower", 1, 1, 2, 0, 1, 5, 5, 2.5, 1));
      this.seeds.add(new Seeds("Tulips", "Flower", 2, 2, 3, 0, 1, 10, 9, 5, 1));
      this.seeds.add(new Seeds("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0));
      this.seeds.add(new Seeds("Sunflower", "Flower", 3, 2, 3, 1, 2, 20, 19, 7.5, 1));
      this.seeds.add(new Seeds("Mango", "Fruit tree", 10, 7, 7, 4, 4, 100, 8, 25, 5, 15));
      this.seeds.add(new Seeds("Apple", "Fruit tree", 10, 7, 7, 5, 5, 200, 5, 25, 10, 15));
   }

   
 /**
  * This function allows the user to buy seeds from the seed store
  * 
  * @param farmer the farmer object
  * @param index the index of the seed in the seeds arraylist
  * @param farm the farm object
  * @param currentDay the current day of the game
  */
   public void buySeeds(Game game, Farmer farmer, int index, Farm farm, int currentDay) {


      for (Seeds seed : this.seeds) {
         if (seeds.get(index) == seed) {
            if (farmer.getObjectCoins() >= seed.getSeedCost()) {
               if (farm.plantSeed(game, seed, currentDay) == 1){
               farmer.setObjectCoins(farmer.getObjectCoins() - seed.getSeedCost());
               farmer.addSeeds(seed);
               System.out.println("You have bought " + seed.getSeedName() + " seeds.");       
               System.out.println("You have planted your " + seed.getSeedName() + " seeds!");           
               }
               else{
                  System.out.println("You cannot plant your " + seed.getSeedName() + " seeds here!");
               }
            } 
            else {
               System.out.println("You do not have enough coins to buy " + seed.getSeedName() + " seeds.");
            }
         }
      }
   }

   /**
    * This function returns the seeds of the current plant
    * 
    * @return An ArrayList of Seeds.
    */
   public ArrayList<Seeds> getSeeds() {
      return this.seeds;
   }

   /**
    * This function prints out the seeds that are available in the shop
    *
    */
   public void displayShop(){
      System.out.println("Welcome to the shop!");
      System.out.println("Here are the seeds you can buy:");
      int i = 1;
      for (Seeds seed : this.seeds) {
         System.out.println("["+ i + "] " + seed.getSeedName() + " seeds: " + seed.getSeedCost() + " coins");
         i++;
      }
   }
}
