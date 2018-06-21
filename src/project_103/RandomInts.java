package project_103;
import java.util.*;

public class RandomInts {
   static Random rand = new Random();

   public static void main(String[] args) {
      int low = 3, high = 7;
      int random = rand.nextInt(high-low+1)+low; // Generates a random number between low and high (inclusive)
      System.out.println(random);
   }
}