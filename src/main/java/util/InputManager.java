package util;

import java.time.LocalDate;
import java.util.Scanner;

public class InputManager {

    Scanner sc = new Scanner(System.in);

    public String takeInput() {
        return sc.nextLine();
    }

    /** Takes input and returns if it's a digit trough verifyIntFormat(). */
    public int verifyInt() {
        System.out.println("Please enter a digit.");
        return verifyIntFormat(takeInput());
    }

    public int verifyIntFormat(String input) {
        if( input.length() > 0 && input.matches("[0-9]*") ) {
            return Integer.parseInt(input);
        } else {
            return verifyInt();
        }
    }

    /** Takes input and returns if it's a digit between 0 and the max value, through verifyInt(int, int, String).
     * Used to not get NullPointerException when accessing arraylists*/
    public int verifyInt(int min, int max) {
        System.out.println("Please enter a digit. Leave blank to go back to main menu.");
        return verifyIntFormat(min, max, takeInput());
    }

    public int verifyIntFormat(int min, int max, String input) {
        if (input.length() > 0) {
            if(input.matches("[0-9]*") ) {
                int i = Integer.parseInt(input);
                if (i >= min && i <= max)
                    return i;
                else return verifyInt(min, max);
            } else {
                return verifyInt(min, max);
            }
        } else return 1;
    }

    public String verifyEmail(){
        String email = takeInput();
        if(email.contains("@")){
            return email;
        }else{
            System.out.println("Please enter a valid email.");
            return verifyEmail();
        }
    }

    /** For consistency, letting all input go through InputManager. */
    public String verifyString() {
        return takeInput();
    }


    /** Takes a string in the format YYYYMMDD or YYMMDD and converts it to LocalDate, through verifyDateFormat().
     * If YY in YYMMDD is lower than 19, makes it 20YY, else 19YY. Also checks that birthday is not after today */
    public LocalDate verifyDate() {
        System.out.println("Please enter date in the format YYYYMMDD or YYMMDD");
        String input = takeInput();
        LocalDate localDate = checkDateFormat(input);
        if (localDate.isAfter(LocalDate.now())) {
            System.out.println("Time travelers not accepted, input birthdate again");
            return verifyDate();
        }
        else {
            return localDate;
        }
    }

    public LocalDate checkDateFormat(String input) {
        String year, month, day;

        if (input.length() == 8 && input.matches("([1]|[2]){1}([9|0]){1}[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}")) {
            year = input.substring(0, 4);
            month = input.substring(4, 6);
            day = input.substring(6, 8);
            return LocalDate.parse(year + "-" + month + "-" + day);
        } else if (input.length() == 6 && input.matches("[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}")) {
            if (Integer.parseInt(input.substring(0, 2)) > 19 ) {
                year = "19"+input.substring(0, 2);
                month = input.substring(2, 4);
                day = input.substring(4, 6);
                return LocalDate.parse(year + "-" + month + "-" + day);
            } else {
                year = "20"+input.substring(0, 2);
                month = input.substring(2, 4);
                day = input.substring(4, 6);
                return LocalDate.parse(year + "-" + month + "-" + day);
            }
        } else {
            return verifyDate();
        }
    }
}