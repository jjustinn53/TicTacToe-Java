package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        }

    public static void setUp() {
        char[][] board = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
        };
        System.out.println("Board:");
        printBoard(board);
    }

    public static void printBoard(char[][] board) {
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
    }

    public static void play(char[][] board) {
        setUp();

        boolean player1 = true;
        boolean win = false;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int player;
            if(player1) {
                player = 1;
            } else {
                player = 2;
            }

            System.out.printf("Player %i's turn, Select a row (1-3):");
            int row = Integer.valueOf(scanner.nextLine());
            System.out.printf("Player %i's turn, Select a column (1-3):");
            int col = Integer.valueOf(scanner.nextLine());

        }
    }
}