package util;

import java.time.LocalDate;
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

    public LocalDate verifyDate() {
        String year, month, day;

        String input = sc.nextLine();

        if (input.length() == 8 && input.matches("[0-9]{8}")) {
            year = input.substring(0, 4);
            month = input.substring(4, 6);
            day = input.substring(6, 8);
            return LocalDate.parse(year + month + day);
        } else if (input.length() == 6 && input.matches("[0-9]{6}")) {
            if (Integer.parseInt(input.substring(0, 2)) > 19 ) {
                year = "19"+input.substring(0, 2);
                month = input.substring(2, 4);
                day = input.substring(4, 6);
                return LocalDate.parse(month + year + day);
            } else {
                year = "20"+input.substring(0, 2);
                month = input.substring(2, 4);
                day = input.substring(4, 6);
                return LocalDate.parse(month + year + day);
            }
        }
        else {
            System.out.println("Please enter date in the format YYYYMMDD");
            return verifyDate();
        }
    }

}
