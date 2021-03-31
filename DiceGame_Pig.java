/* Week 6 BJB Textbook Assignments
        Chapter 5, PP7(Dice game)
        Seongbeom Park (Aaron)
        Feb 14, 2021
     */

/* pseudo-code
Main
    -Scanner
    -Player1’s sum = 0;
    -Player2’s sum = 0;

    -while player1's sum < 100 && player2's sum < 100
        -a = scnr.next();
            -Player1’s sum += Player1(a, Player1’s sum);

        -b = scnr.next();
            -Player2’s sum += Player2(b, Player2’s sum);

    -if player1's sum1 >= 100
        -print "player1 win"
    -if player2's sum2 >= 100
        -print "player2 win"

make a method for each player.
	-Scanner
	-Random

	-while equals “roll”
	    -Dice number: rand.nextInt(6)+1
    	-if Dice number equals 1
		    -Return 0;
	    -else if the sum reach or over 100
            -returns the sum of rolls

     -if the player type "stop"
         -returns the sum of rolls

 */

import java.util.Random;
import java.util.Scanner;

public class DiceGame_Pig {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int Player1_Sum = 0;
        int Player2_Sum = 0;
        System.out.println("Rule: If a player type \"roll\", the player will get a random number between 1-6.");
        System.out.println("      However, if a player roll 1, the player's all points for that turn are lost and the turn ends immediately.");
        System.out.println("      If a player type \"stop\", the player's rolls are added to his/her total points.");
        System.out.println("      The first player to reach a score of at least 100 points wins.");
        while (Player1_Sum < 100 && Player2_Sum < 100) {
            System.out.println("Player1's turn\nChoose roll or stop: ");
            String a = scnr.next();
            Player1_Sum += player1(a,Player1_Sum);

            if (Player1_Sum < 100) {
                System.out.println("Player2's turn\nChoose roll or stop: ");
                String b = scnr.next();
                Player2_Sum += player2(b, Player2_Sum);
            }
        }
        if (Player1_Sum >= 100) {
            System.out.println("Player1 win");
        }
        else if (Player2_Sum >= 100) {
            System.out.println("Player2 win");
        }
        System.out.println();
        System.out.println("Total Score:");
        System.out.println("Player1: " + Player1_Sum);
        System.out.println("Player2: " + Player2_Sum);
    }
        public static int player1(String a, int Player1_Sum) {
            Scanner scnr = new Scanner(System.in);
            Random rand = new Random();
            int sum1 = 0;
            int DiceNum1 = 0;
            int Player1_Sum2 = Player1_Sum;

            while (!a.equals("roll") && !a.equals("stop")) {
                System.out.println("You must choose roll or stop.");
                System.out.println("Choose roll or stop: ");
                a = scnr.next();
            }

            while (a.equals("roll")) {
                DiceNum1 = rand.nextInt(6)+1;
                    if (DiceNum1 == 1) {
                        sum1 = 0;
                        System.out.println("You rolled 1. Your rolls at this turn are lost. Player1's sum: " + Player1_Sum +".");
                        System.out.println("Turn goes the Player2");
                        System.out.println();
                        return sum1;
                    }
                sum1 += DiceNum1;
                Player1_Sum2 += DiceNum1;
                System.out.println("You rolled: " + DiceNum1 + ". Player1's sum: " + Player1_Sum2 + ".");

                    if (Player1_Sum2 >= 100) {
                        System.out.println("You reached 100 points!");
                        System.out.println();
                        System.out.println("Game over: ");
                        return sum1;
                    }
                System.out.println("Choose roll or stop: ");
                a = scnr.next();


            }

            if (a.equals("stop")) {
                System.out.println("Player1 chose stop. Turn goes to the Player2.");
                System.out.println();
                return sum1;
            }
            return sum1;
        }

        public static int player2(String b, int Player2_Sum) {
            Scanner scnr = new Scanner(System.in);
            Random rand = new Random();
            int sum2 = 0;
            int DiceNum2 = 0;
            int Player2_Sum2 = Player2_Sum;

            while (!b.equals("roll") && !b.equals("stop")) {
                System.out.println("You must choose roll or stop.");
                System.out.println("Choose roll or stop: ");
                b = scnr.next();
            }

            while (b.equals("roll")) {
                DiceNum2 = rand.nextInt(6)+1;
                    if (DiceNum2 == 1) {
                        sum2 = 0;
                        System.out.println("You rolled 1. Your rolls at this turn are lost. Player2's sum: " + Player2_Sum +".");
                        System.out.println("Turn goes the Player1");
                        System.out.println();
                        return sum2;
                    }
                sum2 += DiceNum2;
                Player2_Sum2 += DiceNum2;
                System.out.println("You rolled: " + DiceNum2 + ". Player2's sum: " + Player2_Sum2 + ".");

                    if (Player2_Sum2 >= 100) {
                        System.out.println("You reached 100 points!");
                        System.out.println();
                        System.out.println("Game over: ");
                        return sum2;
                    }
                System.out.println("Choose roll or stop: ");
                b = scnr.next();

                while (!b.equals("roll") && !b.equals("stop")) {
                    System.out.println("You must choose roll or stop.");
                    System.out.println("Choose roll or stop: ");
                    b = scnr.next();
                }
            }

            if (b.equals("stop")) {
                System.out.println("Player2 chose stop. Turn goes to the Player1.");
                System.out.println();
                return sum2;
            }
            return sum2;
        }
}
