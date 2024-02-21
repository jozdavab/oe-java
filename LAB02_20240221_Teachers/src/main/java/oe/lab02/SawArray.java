package oe.lab02;

public class SawArray {
    // You can define an entry point to your application anywhere.
    public static void main(String[] args) {

        int[][] saw = new int[3][];

        for (int i = 0; i < saw.length; i++) {
            saw[i] = new int[i + 1];
        }

        //0
        //00
        //000

        System.out.println(saw[2][2]);
        System.out.println(saw[2][3]); // Index out of bounds
    }
}