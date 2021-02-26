package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {
        var n = SCAN.nextInt();
        var seed = SCAN.nextInt();

        var rand = new Random(seed);
        var field = new boolean[n][n];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = rand.nextBoolean();
            }
        }

        for (boolean[] booleans : field) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean ? 'O' : ' ');
            }
            System.out.println();
        }
    }
}
