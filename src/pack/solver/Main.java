package pack.solver;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Kirill Truntaev
 * @date   11/15/2021
 *
 * TODO:
 *  1) Add a GUI (JavaFX)
 */
public class Main {
    public static void main(String[] args) {
        /*
        int[][] tableTemplate =    {{0,0,0,     0,0,0,      0,0,0},
                                    {0,0,0,     0,0,0,      0,0,0},
                                    {0,0,0,     0,0,0,      0,0,0},

                                    {0,0,0,     0,0,0,      0,0,0},
                                    {0,0,0,     0,0,0,      0,0,0},
                                    {0,0,0,     0,0,0,      0,0,0},

                                    {0,0,0,     0,0,0,      0,0,0},
                                    {0,0,0,     0,0,0,      0,0,0},
                                    {0,0,0,     0,0,0,      0,0,0}};
        */

        // unknown origin
        int[][] table1 =   {{5, 0, 9,   0, 0, 0,   4, 0, 0},
                            {7, 0, 8,   3, 0, 4,   9, 0, 0},
                            {6, 0, 1,   0, 0, 0,   7, 3, 0},

                            {4, 6, 2,   5, 0, 0,   0, 0, 0},
                            {3, 8, 5,   7, 2, 0,   6, 4, 9},
                            {1, 0, 7,   4, 0, 8,   2, 0, 0},

                            {2, 0, 0,   1, 0, 0,   0, 0, 4},
                            {0, 0, 3,   0, 4, 0,   0, 8, 7},
                            {0, 7, 0,   0, 5, 3,   0, 0, 6}};

        // https://sandiway.arizona.edu/sudoku/examples.html ---- Arizona Daily Wildcat: Tuesday, Jan 17th 2006
        int[][] table2 =   {{0, 0, 0,   2, 6, 0,   7, 0, 1},
                            {6, 8, 0,   0, 7, 0,   0, 9, 0},
                            {1, 9, 0,   0, 0, 4,   5, 0, 0},

                            {8, 2, 0,   1, 0, 0,   0, 4, 0},
                            {0, 0, 4,   6, 0, 2,   9, 0, 0},
                            {0, 5, 0,   0, 0, 3,   0, 2, 8},

                            {0, 0, 9,   3, 0, 0,   0, 7, 4},
                            {0, 4, 0,   0, 5, 0,   0, 3, 6},
                            {7, 0, 3,   0, 1, 8,   0, 0, 0}};

        //https://sandiway.arizona.edu/sudoku/examples.html ---- Arizona Daily Wildcat: Wednesday, Jan 18th 2006
        int[][] table3 =   {{1, 0, 0,   4, 8, 9,   0, 0, 6},
                            {7, 3, 0,   0, 0, 0,   0, 4, 0},
                            {0, 0, 0,   0, 0, 1,   2, 9, 5},

                            {0, 0, 7,   1, 2, 0,   6, 0, 0},
                            {5, 0, 0,   7, 0, 3,   0, 0, 8},
                            {0, 0, 6,   0, 9, 5,   7, 0, 0},

                            {9, 1, 4,   6, 0, 0,   0, 0, 0},
                            {0, 2, 0,   0, 0, 0,   0, 3, 7},
                            {8, 0, 0,   5, 1, 2,   0, 0, 4}};

        //https://sandiway.arizona.edu/sudoku/examples.html ---- Challenge 1 from Sudoku Solver by Logic
        int[][] table4 =   {{0, 2, 0,   0, 0, 0,   0, 0, 0},
                            {0, 0, 0,   6, 0, 0,   0, 0, 3},
                            {0, 7, 4,   0, 8, 0,   0, 0, 0},

                            {0, 0, 0,   0, 0, 3,   0, 0, 2},
                            {0, 8, 0,   0, 4, 0,   0, 1, 0},
                            {6, 0, 0,   5, 0, 0,   0, 0, 0},

                            {0, 0, 0,   0, 1, 0,   7, 8, 0},
                            {5, 0, 0,   0, 0, 9,   0, 0, 0},
                            {0, 0, 0,   0, 0, 0,   0, 4, 0}};

        //unknown origin
        int[][] table5 =   {{0, 0, 0,   6, 0, 0,   4, 0, 0},
                            {7, 0, 0,   0, 0, 3,   6, 0, 0},
                            {0, 0, 0,   0, 9, 1,   0, 8, 0},

                            {0, 0, 0,   0, 0, 0,   0, 0, 0},
                            {0, 5, 0,   1, 8, 0,   0, 0, 3},
                            {0, 0, 0,   3, 0, 0,   0, 4, 5},

                            {0, 4, 0,   2, 0, 0,   0, 6, 0},
                            {9, 0, 3,   0, 0, 0,   0, 0, 0},
                            {0, 2, 0,   0, 0, 0,   1, 0, 0}};

        //https://www.livesudoku.com/en/sudoku/evil/1817031
        int[][] table6 =   {{0,0,0,     0,0,2,      1,0,0},
                            {0,0,0,     1,0,0,      0,0,5},
                            {0,0,9,     5,0,3,      0,0,8},

                            {0,0,2,     0,0,6,      0,0,4},
                            {6,0,0,     0,0,0,      0,0,0},
                            {8,0,0,     0,0,0,      3,0,0},

                            {0,5,0,     0,9,0,      0,7,0},
                            {0,9,8,     0,7,0,      0,0,0},
                            {0,0,1,     3,2,0,      8,0,6}};

        ///https://abcnews.go.com/blogs/headlines/2012/06/can-you-solve-the-hardest-ever-sudoku
        int[][] table7 =   {{8, 0, 0,   0, 0, 0,   0, 0, 0},
                            {0, 0, 3,   6, 0, 0,   0, 0, 0},
                            {0, 7, 0,   0, 9, 0,   2, 0, 0},

                            {0, 5, 0,   0, 0, 7,   0, 0, 0},
                            {0, 0, 0,   0, 4, 5,   7, 0, 0},
                            {0, 0, 0,   1, 0, 0,   0, 3, 0},

                            {0, 0, 1,   0, 0, 0,   0, 6, 8},
                            {0, 0, 8,   5, 0, 0,   0, 1, 0},
                            {0, 9, 0,   0, 0, 0,   4, 0, 0}};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select one of the options from the Menu below: ");
        System.out.println("1) Solve one of the pre-made Sudoku Puzzles.");
        System.out.println("2) Input your own Sudoku Puzzle.");
        System.out.print("\nInput options 1-2: ");
        int menuChoice = scanner.nextInt();

        if (menuChoice == 1) {
            System.out.print("\nChoose Puzzles 1-7 from the README.md: ");
            menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1 -> solveSudoku(table1);
                case 2 -> solveSudoku(table2);
                case 3 -> solveSudoku(table3);
                case 4 -> solveSudoku(table4);
                case 5 -> solveSudoku(table5);
                case 6 -> solveSudoku(table6);
                case 7 -> solveSudoku(table7);
            }
        } else {
            System.out.print("\nPlease input the Sudoku Puzzle line by line following the guidelines below:\n");
            System.out.print("1) Input the digits in their places and 0s for empty squares, with no spaces in between\n");
            System.out.print("2) Press \"enter\" after each line (9 digits)\n");
            System.out.println("3) Repeat this process until you have inputted 9 lines of digits");

            int[][] tableTempInput = new int[9][9];
            do {
                System.out.println("\n\nInput:");
                scanner.nextLine();         //discards a line with no inputs

                String[] inputs = new String[9];

                for (int i = 0; i < inputs.length; i++) {
                    inputs[i] = scanner.nextLine();
                    for (int j = 0; j < inputs[i].length(); j++) {
                        tableTempInput[i][j] = Integer.parseInt(inputs[i].charAt(j) + "");
                    }
                }

                System.out.println("\nIs this correct?: ");

                outputArray(tableTempInput);

                System.out.print("Re-input (Y/N): ");
                String tempInput = scanner.nextLine();
                if (!tempInput.equalsIgnoreCase("Y"))
                    break;

            } while (true);

            solveSudoku(tableTempInput);
        }

        scanner.close();
    }

    public static void outputArray(int[][] template) {
        for (int[] row : template) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(int[][] template) {
        Table board = new Table(template);

        System.out.println("\nINITIAL: ");
        board.drawTable();

        System.out.println("# OF POTENTIAL SOLUTIONS: ");
        board.drawNumSolutions();

        long executionStart = System.nanoTime();
        recursiveSolver(board, 0, 0);
        long executionEnd = System.nanoTime();

        System.out.println("SOLVED: ");
        board.drawTable();

        System.out.println("Execution Time: " + (executionEnd - executionStart)/1_000_000.0 + " ms");
    }

    public static int recursiveSolver(Table board, int row, int column) {
        if (column > 8) {
            row++;
            column = 0;
        }

        //checks if the cell needs to be solved
        if (board.isEmpty(row, column)) {
            ArrayList<Integer> possibleSolutions = board.getSolutionsFor(row, column);
            int guess = possibleSolutions.get(0);
            int guessIndex = -1;

            while (!board.isCompleted()) {

                //this loop iterates through all possible solutions until it finds one that works
                while (!board.isPossible(guess, row, column)) {
                    guessIndex++;
                    if (guessIndex >= possibleSolutions.size()) {
                        board.set(0, row, column);             //needs to be done due to potentially already having a guess in that slot
                        return 1;
                    }

                    guess = possibleSolutions.get(guessIndex);
                }

                board.set(guess, row, column);

                if (board.isCompleted())     //prevents going out of bounds
                    return 91284128;

                guessIndex = guessIndex + recursiveSolver(board, row, column + 1);      //actual recursive part

                if (board.isCompleted())     //prevents returning all 0s
                    return 91284128;

                if (guessIndex >= possibleSolutions.size()) {
                    board.set(0, row, column);    //needs to be done due to potentially already having a guess in that slot
                    return 1;
                }

                guess = possibleSolutions.get(guessIndex);
            }
        } else {
            recursiveSolver(board, row, column + 1);
            return 1;
        }

        return -1234541287;                  //final return doesn't matter
    }
}
