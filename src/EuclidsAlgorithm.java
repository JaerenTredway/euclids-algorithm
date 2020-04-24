import java.util.Scanner;

/**
 * @author Jaeren W Tredway
 * @version 1.0 for CS261 Spring 2020
 *
 * This implements the extended Euclid's Algorithm to get gcd(a, b) and the
 * linear combination gcd(a, b) = sa + tb as in Bezout's Identity
 *
 * scanner input: two positive integers a and b
 * output: from the Euclidian Algorithm --> gcd(a, b)
 * output: as per Bezout's Identity (gcd(a, b) = sa + tb) --> s, t
 *
 * to complile in command line: javac EuclidsAlgorithm.java from inside the
 * src directory
 *
 * to run program: java EuclidsAlgorithm
 */
public class EuclidsAlgorithm {

    //CLASS VARIABLES:
    private static Scanner scanner = new Scanner(System.in);
    static int a = 0; //first input number: the SMALLER ONE
    static int b = 0; //first input number: the LARGER ONE
    static int s = 0; //the Bezout's coefficient to a
    static int t = 0; //the Bezout's coefficient to b
    static int d = 0; //the value of gcd(a , b)


    //get user input for a and b:
    static void getInput () {
        System.out.println("Enter the positive integer for \"a\": ");
        a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the positive integer for \"b\": ");
        b = scanner.nextInt();
        scanner.nextLine();
    }

    //build an array to store [d, s, t]
    //d = gcd(a, b) = sa + tb
    static int[] gcd(int a, int b) {
        //exit condition:
        if (b == 0)
            return new int[] { a, 1, 0 };
        //run the recursion:
        int[] store = gcd(b, a % b);
        d = store[0];
        s = store[2];
        t = store[1] - (a / b) * store[2];
        return new int[] { d, s, t };
    }

    public static void main(String[] args) {
    //get the user input:
        getInput();
    //run the algorithm:
        int[] store = gcd(a, b);
    //print the output:
        System.out.println("Greatest Common Denominator from Euclidian " +
                "Algorithm:");
        System.out.println("gcd(" + a + ", " + b + ") = " + store[0]);
        System.out.println("Linear Combination as in Bezout's Identity:");
        System.out.println("s(a) + t(b) = gcd(a, b)");
        System.out.println(store[1] + "(" + a + ") + " + store[2] +
                "(" + b + ") = " + store[0]);
    }//END main()
}//END class EuclidsAlgorithm

