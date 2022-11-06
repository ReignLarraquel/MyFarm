package my_farm;

import java.util.ArrayList;

public class Shop {
   private ArrayList<Seeds> seeds;

   public Shop() {
      this.seeds = new ArrayList<Seeds>();

      this.seeds.add(new Seeds("Turnip", "Root crop", 2, 1, 2, 0, 1, 5, 6, 5, 1, 2));
      // this.seeds.add(new Seeds("Carrot", "Root crop", 3, 1, 2, 0, 1, 10, 9, 7.5, 1, 2));
      // this.seeds.add(new Seeds("Potato", "Root crop", 5, 3, 4, 1, 2, 20, 3, 12.5, 1, 10));
      // this.seeds.add(new Seeds("Rose", "Flower", 1, 1, 2, 0, 1, 5, 5, 2.5, 1));
      // this.seeds.add(new Seeds("Tulips", "Flower", 2, 2, 3, 0, 1, 10, 9, 5, 1));
      // this.seeds.add(new Seeds("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0));
      // this.seeds.add(new Seeds("Sunflower", "Flower", 3, 2, 3, 1, 2, 20, 19, 7.5, 1));
      // this.seeds.add(new Seeds("Mango", "Fruit tree", 10, 7, 7, 4, 4, 100, 8, 25, 5, 15));
      // this.seeds.add(new Seeds("Apple", "Fruit tree", 10, 7, 7, 5, 5, 200, 5, 25, 10, 15));
   }

   
   //this method is to buy seeds
   public void buySeeds(Farmer farmer, int index, Farm farm) {


      for (Seeds seed : this.seeds) {
         if (seeds.get(index) == seed) {
            if (farmer.getObjectCoins() >= seed.getSeedCost()) {
               if (farm.plantSeed(seed) == 1){
               farmer.setObjectCoins(farmer.getObjectCoins() - seed.getSeedCost());
               farmer.setLevel(farmer.getLevel(), farmer.getExp() + seed.getExpEarned());
               farmer.addSeeds(seed);
               System.out.println("You have bought " + seed.getSeedName() + " seeds.");       
               System.out.println("You have planted your " + seed.getSeedName() + " seeds!");           
               }
               else{
                  System.out.println("You cannot plant your " + seed.getSeedName() + " seeds here!\nYou must plow the land first!");
               }
            } 
            else {
               System.out.println("You do not have enough coins to buy " + seed.getSeedName() + " seeds.");
            }
         }
      }
   }

   public ArrayList<Seeds> getSeeds() {
      return this.seeds;
   }

   public void displayShop(){
      System.out.println("Welcome to the shop!");
      System.out.println("Here are the seeds you can buy:");
      int i = 1;
      for (Seeds seed : this.seeds) {
         System.out.println("["+ i + "]" + seed.getSeedName() + " seeds: " + seed.getSeedCost() + " coins");
         i++;
      }
   }
}
