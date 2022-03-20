package pack.solver;

import java.util.ArrayList;

/**
 * Table object contains all the individual square objects, as well as the checker methods
 * that ensure that guesses follow the puzzle's rules
 */

public class Table {

    Square[][] squares;


     /*
     * Constructs a Table from an inputted preset
     *
     * @param preset - the original state of the Sudoku puzzle to be solved
     */
    public Table(int[][] preset) {
        squares = new Square[preset.length][preset[0].length];

        // creates the original state of the table
        for (int i = 0; i < preset.length; i++) {
            for (int j = 0; j < preset[0].length; j++) {
                squares[i][j] = new Square(preset[i][j]);
            }
        }

        // figuring out all the possible solutions for that square
        // greatly speeds up the algorithm
        for (int i = 0; i < preset.length; i++) {
            for (int j = 0; j < preset[0].length; j++) {
                if (preset[i][j] == 0) {
                    ArrayList<Integer> guesses = new ArrayList<>();

                    int potentialGuess = 1;
                    while (potentialGuess <= 9) {
                        if (isPossible(potentialGuess, i, j))
                            guesses.add(potentialGuess);
                        potentialGuess++;
                    }
                    squares[i][j] = new Square(guesses, preset[i][j]);
                }
                else {
                    squares[i][j] = new Square(preset[i][j]);
                }
            }
        }
    }

    public ArrayList<Integer> getSolutionsFor(int row, int column) {
        return squares[row][column].getSolutions();
    }

    public void drawNumSolutions() {
        double averageNumSolutions = 0;
        int numberOfBlankSquares = 0;

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j].getCurrentValue() != 0)
                    System.out.print(0 + " ");
                else {
                    System.out.print(squares[i][j].getSolutions().size() + " ");
                    averageNumSolutions += squares[i][j].getSolutions().size();
                    numberOfBlankSquares++;
                }

                if (j == 2 || j == 5)
                    System.out.print("\t");
            }

            if (i == 2 || i == 5)
                System.out.println();

            System.out.println();
        }
        averageNumSolutions = averageNumSolutions / numberOfBlankSquares;

        //the average # of solutions can be seen as the level of difficulty a specific puzzle has
        System.out.println("The Average Number of Solutions:" + averageNumSolutions + "\n\n");
    }

    public void set(int num, int row, int column) {
        squares[row][column].setValue(num);
    }

    public boolean isCompleted() {
        for (Square[] squareRow : squares) {
            for (Square square : squareRow) {
                if (square.getCurrentValue() == 0)
                    return false;
            }
        }
        return true;
    }

    public boolean isPossible(int num, int row, int column) {
        if (!checkSquare(num, row, column)) {
            return false;
        }
        if (!checkColumn(num, row, column)) {
            return false;
        }
        return checkRow(num, row, column);
    }

    public boolean checkSquare(int num, int row, int column) {
        // determining the 3x3 square being checked
        int beginColumn = 6;
        int endColumn = 8;

        if (column < 3) {
            beginColumn = 0;
            endColumn = 2;
        } else if (column < 6) {
            beginColumn = 3;
            endColumn = 5;
        }

        int beginRow = 6;
        int endRow = 8;

        if (row < 3) {
            beginRow = 0;
            endRow = 2;
        } else if (row < 6) {
            beginRow = 3;
            endRow = 5;
        }

        for (int i = beginRow; i <= endRow; i++) {
            for (int j = beginColumn; j <= endColumn; j++) {
                if (squares[i][j].getCurrentValue() == num)
                    return false;
            }
        }

        return true;
    }

    public boolean checkRow(int num, int row, int column) {
        for (int i = 0; i < squares.length; i++) {
            if (squares[row][i].getCurrentValue() == num)
                return false;
        }
        return true;
    }

    public boolean checkColumn(int num, int row, int column) {
        for (int i = 0; i < squares.length; i++)
            if (squares[i][column].getCurrentValue() == num)
                return false;

        return true;
    }

    public boolean isEmpty(int row, int column) {
        return squares[row][column].getPresetState();
    }

    public void drawTable() {
        System.out.println("\n-------------\t-------------\t-------------");

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (j % 3 == 0)
                    System.out.print("| ");

                if(squares[i][j].getCurrentValue() == 0)
                    System.out.print(" " + " | ");
                else
                    System.out.print(squares[i][j].getCurrentValue() + " | ");

                if (j == 2 || j == 5)
                    System.out.print("\t");
            }

            if (i == 2 || i == 5)
                System.out.println("\n-------------\t-------------\t-------------");

            System.out.println("\n-------------\t-------------\t-------------");
        }
        System.out.println("\n\n");
    }
}