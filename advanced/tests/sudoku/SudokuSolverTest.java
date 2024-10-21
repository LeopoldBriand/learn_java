package sudoku;

import java.util.ArrayList;

import org.junit.Test;

public class SudokuSolverTest {
    @Test
    public void collapse() {
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
        
        CollapsableSudoku collapsable = CollapsableSudoku.fromSudoku(sudoku);
        collapsable.collapse();
        collapsable.collapse();
        collapsable.toSudoku().print();
    }
}
