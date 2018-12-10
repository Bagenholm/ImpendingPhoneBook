package util;

import java.util.Scanner;

public class InputManager {

    Scanner sc = new Scanner(System.in);

    /** Takes input and returns if it's a digit. */
    public int verifyInt() {
        String input = sc.nextLine();
        int i;
        if( input.length() > 0 && input.matches("[0-9]*") ) {
            i = Integer.parseInt(input);

            return i;
        } else {
            System.out.println("Invalid input, please enter a digit.");
            return verifyInt();
        }
    }

    /** Takes input and returns if it's a digit between 0 and the max value.
     * Used to not get NullPointerException when accessing arraylists*/
    public int verifyInt(int min, int max) {
        String input = sc.nextLine();
        int i;
        if( input.length() > 0 && input.matches("[0-9]*") ) {
            i = Integer.parseInt(input);
            if (i >= min && i <= max)
                return i;
            else return verifyInt(min, max);
        } else {
            System.out.println("Invalid input, please enter a digit.");
            return verifyInt();
        }
    }

    /** For consistency, letting all input go through InputManager. */
    public String verifyString() {
        return sc.nextLine();
    }
}
