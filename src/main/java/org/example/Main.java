package org.example;

import org.example.Dron.Dron;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Scanner;

enum control {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    PRINT,
    FAULT

}
public class Main {

    public static control converter(char c) {
        switch(c) {
            case 'w':
                return control.UP;
            case 's':
                return control.DOWN;
            case 'a':
                return control.LEFT;
            case 'd':
                return control.RIGHT;
            case 'p':
                return control.PRINT;
            default:
                return control.FAULT;
        }
    }

    public static void printMap(ArrayList<ArrayList<Integer>> map) {
        for(int i = 0; i < map.size(); ++i) {
            System.out.println(map.get(i));
        }
    }

    public static void main(String[] argvs) {
        Dron d1 = new Dron();

        int row = 0, col = 0;

        Scanner scan = new Scanner(System.in);


        try {
            row = scan.nextInt();
            col = scan.nextInt();
            d1.setBoundary(row, col);
        } catch(Exception e) {
            System.err.println("Wrong typed size of map");
        }

        // try to make 2d-array
        ArrayList<ArrayList<Integer>> dronMap = new ArrayList<ArrayList<Integer>> ();

        for (int i = 0; i < row; ++i) {

            dronMap.add(new ArrayList<Integer>());
            ArrayList<Integer> curr = dronMap.get(i);

            for(int j = 0; j < col; ++j) {

                curr.add(0);
            }
        }

        printMap(dronMap);

        Dron.Position curr = d1.current();
        dronMap.get(curr.ns).set(curr.ew, dronMap.get(curr.ns).get(curr.ew) + 1);

        // CMD
        while (scan.hasNext()) {

            String cmd = scan.next();
            // String is not collection
            //ArrayList<Character> chars = new ArrayList<Character>(cmd);
            int n = cmd.length();

            for( int i = 0; i < n; ++i) {

                char c = cmd.charAt(i);

                control ct = converter(c);

                // Swtich
                try {
                    switch (ct) {
                        case UP:
                            System.out.println("going Up");
                            d1.forward();
                            break;
                        case DOWN:
                            System.out.println("going Down");
                            d1.backward();
                            break;
                        case LEFT:
                            System.out.println("going Left");
                            d1.left();
                            break;
                        case RIGHT:
                            System.out.println("going Right");
                            d1.right();
                            break;
                        case PRINT:
                            printMap(dronMap);
                            continue;
                        default:
                            System.err.println("Invalid command! It's ignored.");
                            throw new InvalidKeyException();
                    }
                    curr = d1.current();
                    System.out.println("Current position: " + "EW: " + curr.ew + "NS: " + curr.ns);
                    dronMap.get(curr.ns).set(curr.ew, dronMap.get(curr.ns).get(curr.ew) + 1);

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

            } // for loop


        }// while loop
    }
}
