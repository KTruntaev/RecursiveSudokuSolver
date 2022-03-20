package pack.solver;

import java.util.ArrayList;

/**
 * Square objects are used primarily to store the # of possible solutions in a given
 * square of a Sudoku puzzle
 */
public class Square {
    ArrayList<Integer> possibleSolutions;
    int currentValue;
    boolean notPreset;

    /**
     * Constructs a "non-static" square that needs to be solved
     *
     * @param pS    is the list of all possible solutions for this square of a puzzle
     * @param value is the initial value of a square
     */
    public Square(ArrayList<Integer> pS, int value) {
        possibleSolutions = pS;
        currentValue = value;
        notPreset = true;
    }

    /**
     * Generates a "static" square that does not need to be solved
     *
     * @param value is the value of the square
     */
    public Square(int value) {
        currentValue = value;
        notPreset = false;
    }

    public void setValue(int value) {
        currentValue = value;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public boolean getPresetState() {
        return notPreset;
    }

    public ArrayList<Integer> getSolutions() {
        return possibleSolutions;
    }
}
