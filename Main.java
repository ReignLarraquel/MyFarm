import my_farm.*;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Farm farm = new Farm();
      Farmer farmer;
      String name;

      //Setup Map:
      Shop shop = new Shop();
      UseItem useItem = new UseItem();

      System.out.println("Welcome to My Farm!");

      System.out.println("What is your name?");
      Scanner input = new Scanner(System.in);
      name = input.next();
      farmer = new Farmer(name);

      farm.displayFarm();
   }
}
