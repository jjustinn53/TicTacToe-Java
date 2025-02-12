package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static char[][] board;

    public static void main(String[] args) {
        setUp();
        play(board);
        }

    /**
     * This method sets up the board 2D array
     * with spaces for empty spots
     */
    public static void setUp() {
        board = new char[][]{
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
        };
    }

    /**
     * This method prints out the board with the spots filled with Xs and Os or empty spots
     * @param board
     */
    public static void printBoard(char[][] board) {
        System.out.println("Board:");

        for(int row = 0; row < board.length; row++) {
            if(row != 0) {
                System.out.println("-+-+-");
            }
            for(int col = 0; col < board[row].length; col++) {
                if(col != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This is where players get to select where X's and O's get placed
     * @param board
     */
    private static void play(char[][] board) {
        printBoard(board);


        boolean player1 = true;
        boolean win = false;

        Scanner scanner = new Scanner(System.in);
        int player = 1;
        char xO = 'X';
        boolean CPU = false;
        boolean invalid = false;
        int moves = 0;

        while(true) {
            System.out.println("CPU or Player?: ");
            String input = scanner.nextLine();

            if(!input.equalsIgnoreCase("CPU") && !input.equalsIgnoreCase("Player")) {
                System.out.println("Invalid input, Try again.");
            }

            if(input.equalsIgnoreCase("CPU")) {
                CPU = true;
                break;
            } else if(input.equalsIgnoreCase("player")) {
                CPU = false;
                break;
            }
        }

        do{
            if(player1 && !invalid) {
                player = 1;
                xO = 'X';
                player1 = false;
            } else if(!player1 && !invalid) {
                player = 2;
                xO = 'O';
                player1 = true;
            }
            Random random = new Random();

            int row = 0;
            int col = 0;

            if(!CPU || player == 1) {
                while(true) {
                    System.out.printf("Player %d's turn, Select a row (1-3): %n", player);
                    row = Integer.valueOf(scanner.nextLine()) - 1;
                    System.out.printf("Player %d's turn, Select a column (1-3): %n", player);
                    col = Integer.valueOf(scanner.nextLine()) - 1;

                    if(row < 0 || row > board.length || col < 0 || col > board[row].length) {
                        System.out.println("Invalid input, Try again.\n");
                    } else {
                        break;
                    }
                }
            } else if(player == 2 && CPU){
                row = random.nextInt(3);
                col = random.nextInt(3);
            }

            if(board[row][col] == ' ') {
                board[row][col] = xO;
                invalid = false;
                moves++;
            } else if(!CPU){
                System.out.println("Spot taken, Please try again.");
                invalid = true;
                continue;
            } else {
                System.out.println("Spot taken, Please try again.");
                invalid = true;
                continue;
            }
            win = winCheck(board);
            printBoard(board);

            if(moves == 9 && !win) {
                break;
            }
        } while (!win);

        if(win) {
            System.out.println("Player " + player + " won!");
        } else {
            System.out.println("Tie!");
        }
    }

    /**
     * This will go through entire board and check for horizontal, vertical, and diagonal wins by
     * checking if the boxes are equal to each other.
     * @param board
     * @return win
     */
    public static boolean winCheck(char[][] board) {

         for(int row = 0; row < board.length; row++) {
             if(board[row][0] != ' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                 return true;
             }
         }

         for(int col = 0; col < board[0].length; col++) {
            if (board[0][col] != ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }

         if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
         || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
             return true;
         }

         return false;
    }
}