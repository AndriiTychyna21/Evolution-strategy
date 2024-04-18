import functions.Algorithm;
import functions.Bukin;
import functions.Matyasa;
import functions.Schaffer;
import functions.Matyasa;

public class Main {
    public static void main(String[] args) {
        System.out.println("Schaffer function N.2");
        Algorithm algo = new Schaffer();
        System.out.println("x = " + algo.bestPoint.x);
        System.out.println("y = " + algo.bestPoint.y);
        System.out.println("f = " + algo.bestValue);
        double approximate = 0;
        approximate += algo.bestValue;
        for (int i = 0; i < 9; i++){
            algo = new Schaffer();
            approximate += algo.bestValue;
        }
        approximate /= 10;
        System.out.println("Approximate result: " + approximate);
        approximate = 0;

        System.out.println("\nBukin function N.6");
        algo = new Bukin();
        System.out.println("x = " + algo.bestPoint.x);
        System.out.println("y = " + algo.bestPoint.y);
        System.out.println("f = " + algo.bestValue);
        approximate += algo.bestValue;
        for (int i = 0; i < 9; i++){
            algo = new Bukin();
            approximate += algo.bestValue;
        }
        approximate /= 10;
        System.out.println("Approximate result: " + approximate);
        approximate = 0;

        System.out.println("\nMatyas function");
        algo = new Matyasa();
        System.out.println("x = " + algo.bestPoint.x);
        System.out.println("y = " + algo.bestPoint.y);
        System.out.println("f = " + algo.bestValue);
        approximate += algo.bestValue;
        for (int i = 0; i < 9; i++){
            algo = new Matyasa();
            approximate += algo.bestValue;
        }
        approximate /= 10;
        System.out.println("Approximate result: " + approximate);
    }
}
