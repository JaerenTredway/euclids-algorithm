import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Jaeren Tredway
 * @version 1.0 for CS261 Spring 2020
 *
 * This implements the extended Euclid's Algorithm to get gcd(a, b) and the
 * linear combination gcd(a, b) = sa + tb as in Bezout's Identity
 * 
 * scanner input: two positive integers a and b
 * output: from the Euclidian Algorithm --> gcd(a, b)
 * output: from Bezout's Identity (gcd(a, b) = sa + tb) --> s, t
 *
 * to complile in command line: javac EuclidsAlgorithm.java from inside the
 * src directory
 *
 * to run program: java EuclidsAlgorithm
 */
public class EuclidsAlgorithm {

    //CLASS VARIABES:
    private static Scanner scanner = new Scanner(System.in);
    static int a = 0;
    static int b = 0;

    //this method gets user input for a and b:
    static void getInput () {
        System.out.println("Enter a positive integer for \"a\": ");
        a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter a positive integer for \"b\": ");
        a = scanner.nextInt();
        scanner.nextLine();
    }

    //build an array to store [d, s, t]
    //d = gcd(a, b) = sa + tb
    static int[] gcd(int a, int b) {
        //exit condition to escape recursion:
        if (b == 0) {
            return new int[] { a, 1, 0 };
        }

        //run the recursion:
        int[] store = gcd(b, a % b);

        //store the final values after the recursion:
        int d = store[0];
        int s = store[2];
        int t = store[1] - (a / b) * store[2];
        return new int[] { d, s, t };
    }//END gcd()

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int[] vals = gcd(a, q);
        System.out.println("gcd(" + a + ", " + q + ") = " + vals[0]);
        System.out.println(vals[1] + "(" + a + ") + " + vals[2] +
                "(" + q + ") = " + vals[0]);
    }//END main()
}//END class EuclidsAlgorithm

