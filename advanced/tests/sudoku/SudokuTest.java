package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class SudokuTest {
    @Test
    public void print() {
        Sudoku sudoku = new Sudoku();
        sudoku.parse("""
            +-------+-------+-------+
            | 6 0 0 | 0 2 0 | 0 0 0 |
            | 0 0 5 | 0 0 6 | 1 8 0 |
            | 4 1 0 | 0 0 0 | 0 0 0 |
            +-------+-------+-------+
            | 0 0 4 | 0 8 0 | 0 0 3 |
            | 0 0 0 | 2 0 7 | 0 0 0 |
            | 9 0 0 | 0 5 0 | 8 0 0 |
            +-------+-------+-------+
            | 0 0 0 | 0 0 0 | 0 5 7 |
            | 0 7 9 | 1 0 0 | 6 0 0 |
            | 0 0 0 | 0 9 0 | 0 0 8 |
            +-------+-------+-------+
                """);

    }
}
