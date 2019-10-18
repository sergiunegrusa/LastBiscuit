import java.util.Scanner;

public class LastBiscuit{
    /* Level 3 Solution */


    private static int number1 = 6, number2 = 8;          ///number of biscuits in the first and second barrell
    private static int activeplayer, turn = 0;    ///turn is for which players turn it is
    private static Scanner in = new Scanner(System.in);

    /*
    This function is checking if a number is an integer and bigger than 0
     */

    private static int readPositiveNumber() {
        int number = -1;
        while (number <= 0) {
            if (in.hasNextInt()) {
                number = in.nextInt();
                if (number <= 0) {
                    System.out.println("Enter a positive number that is bigger than 0");
                }
            } else {
                System.out.println("Enter an integer number!");
                in.next();
            }
        }
        return number;
    }

   /*
    This function shows how many biscuits are left in each barrell
     */

    private static void biscuitsNumber() {
        System.out.println("Biscuits Left - Barrel 1: " + number1);
        System.out.println("Biscuits Left - Barrel 2: " + number2);
    }

    /*
    This function takes out the number of biscuits active player choose to take
     */

    private static void chooseBag() {
        System.out.print("Biscuits taken by player " + activeplayer + ": ");
        System.out.print("From barrel1 (one), barrel2 (two), or both (both)? ");

        int numberBiscuits = readPositiveNumber();

        boolean valid = false;
        while (!valid) {
            String option = in.next();
            switch (option) {
                case "one":
                    if(number1 == 0) {
                        turn --;
                        chooseBag();

                    }
                    while (numberBiscuits > number1) {
                        System.out.println("Enter a lower number:");
                        numberBiscuits = readPositiveNumber();
                    }
                    number1 -= numberBiscuits;
                    valid = true;
                    break;
                case "two":
                    if(number2 == 0) {
                        turn--;
                        chooseBag();

                    }
                    while (numberBiscuits > number2) {
                        System.out.println("Enter a lower number:");
                        numberBiscuits = readPositiveNumber();
                    }
                    number2 -= numberBiscuits;
                    valid = true;
                    break;
                case "both":
                    while (numberBiscuits > number1 || numberBiscuits > number2) {
                        turn--;
                        chooseBag();
                        System.out.println("Enter a lower number:");
                        numberBiscuits = readPositiveNumber();
                    }
                    number1 -= numberBiscuits;
                    number2 -= numberBiscuits;
                    valid = true;
                    break;
                default:
                    System.out.println("The data is wrong, please enter again");
            }
        }

    }


    ///Main program


    public static void main(String[] args) {


        while (number1 != 0 || number2 != 0) {
            turn++;
            if (turn % 2 == 1) {
                activeplayer = 1;
            } else {
                activeplayer = 2;
            }

            biscuitsNumber();
            chooseBag();
            if (number1 == 0 && number2 == 0) {
                biscuitsNumber();
                System.out.println("Winner is player " + activeplayer);
            }
        }
    }
}