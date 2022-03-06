import java.util.Scanner;

/**
 * The BoardFoot program implements an application that
 * calculates the length, equal to one board foot, and
 * accepts two parameters: width and height.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-3-1
 */

class BoardFoot {

    /**
     * Declaring constant for one board foot.
     */
    private static final double ONE_BOARD_FOOT = 144;
    /**
     * Declaring constant for negative number error.
     */
    private static final String NEGATIVE_ERROR = "Positive numbers only!";
    /**
     * Declaring constant for invalid string.
     */
    private static final String INVALID_STRING = "Only numbers are valid!";

    /**
     * Calculates length of board.
     *
     * @param width passed in
     * @param height passed in
     * @return length
     */
    public static double calculateBoardFoot(double width, double height) {
        final double length = ONE_BOARD_FOOT / (width * height);
        return length;
    }

    /**
     * Main entry into program.
     *
     * @param args nothing passed in
     */
    public static void main(String[] args) {
        // declaring variables
        final Scanner sc = new Scanner(System.in);
        double widthUserDouble = 0;
        double heightUserDouble = 0;
        double userBoardLength = 0;
        String widthUserString = "";
        String heightUserString = "";

        // displays opening message
        System.out.println("This program figures out the length of a "
                           + "wooden board that is 1 board foot \n"
                           + "in dimension. (1 board foot is 144^3 "
                           + "inches of wood) \n");

        // gets width from user
        System.out.print("Enter the width (inches): ");
        widthUserString = sc.nextLine();

        try {
            // converts width to a double
            widthUserDouble = Double.parseDouble(widthUserString);

            if (widthUserDouble > 0) {
                // gets height from user
                System.out.print("Enter the height (inches): ");
                heightUserString = sc.nextLine();

                try {
                    // converts height to double
                    heightUserDouble = Double.parseDouble(heightUserString);

                    if (heightUserDouble > 0) {
                        userBoardLength = calculateBoardFoot(widthUserDouble,
                                                             heightUserDouble);

                        // display length to the user
                        System.out.println();
                        System.out.println("The wood should be "
                                           + userBoardLength
                                           + " inch(es) long.");

                    } else {
                        // displays error for negative height
                        System.out.println(NEGATIVE_ERROR);
                    }
                } catch (IllegalArgumentException exception) {
                    // displays error for invalid string
                    System.out.println(INVALID_STRING);
                }
            } else {
                // displays error
                System.out.println(NEGATIVE_ERROR);
            }
        } catch (IllegalArgumentException exception) {
            // displays error
            System.out.println(INVALID_STRING);
        }
    }
}
