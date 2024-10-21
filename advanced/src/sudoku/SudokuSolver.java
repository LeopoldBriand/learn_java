package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class SudokuSolver {
    public static Sudoku solve(Sudoku sudoku) {
        CollapsableSudoku collapsable = CollapsableSudoku.fromSudoku(sudoku);
        while (!collapsable.isSolved()) {
            collapsable.collapse();
        }
        return collapsable.toSudoku();
    }
}

class CollapsableSudoku {
    public Possibilities[][] grid = new Possibilities[9][9];
    public static CollapsableSudoku fromSudoku(Sudoku sudoku) {
        CollapsableSudoku result = new CollapsableSudoku();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Optional<Integer> value = sudoku.grid[i][j];
                if(value.isPresent()) {
                    Integer[] v = {value.get()}; 
                    result.grid[i][j] = new Possibilities(v);
                } else {
                    result.grid[i][j] = Possibilities.Default();
                }
            }
        }
        return result;
    }
    public Sudoku toSudoku() {
        Sudoku result = new Sudoku();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Possibilities value = grid[i][j];
                if(value.size() > 1) {
                    result.grid[i][j] = Optional.empty();
                } else {
                    result.grid[i][j] = Optional.of(value.get(0));
                }
            }
        }
        return result;
    }
    public boolean isSolved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Possibilities value = grid[i][j];
                if(value.size() > 1) {
                    return false;
                } 
            }
        }
        return true;
    }
    public void collapse() {
        // TODO: remove all on the same Row/column/square but is not enought to solve
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j].size() > 1) {
                    ArrayList<Integer> alreadyUsed = getRowValuesFromCoord(i, j);
                    alreadyUsed.addAll(getColumnValuesFromCoord(i, j));
                    alreadyUsed.addAll(getSquareValuesFromCoord(i, j));
                    grid[i][j].removeAll(alreadyUsed);
                }
            }
        }
    }
    private ArrayList<Integer> getRowValuesFromCoord(Integer x, Integer y) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (ArrayList<Integer> cell : grid[x]) {
            if (cell != null && cell.size() == 1) {
                result.add(cell.get(0));
            }
        }
        return result;
    }
    private ArrayList<Integer> getColumnValuesFromCoord(Integer x, Integer y) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (ArrayList<Integer>[] row : grid) {
            ArrayList<Integer> cell = row[y];
            if (cell != null && cell.size() == 1) {
                result.add(cell.get(0));
            }
        }
        return result;
    }
    private ArrayList<Integer> getSquareValuesFromCoord(Integer xx, Integer yy) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Integer x = (int)Math.floor(xx/3)*3;
        Integer y = (int)Math.floor(yy/3)*3;
        ArrayList<Integer>[] square = new Possibilities[]{
            grid[x][y],
            grid[x][y+1],
            grid[x][y+2],
            grid[x+1][y],
            grid[x+1][y+1],
            grid[x+1][y+2],
            grid[x+2][y],
            grid[x+2][y+1],
            grid[x+2][y+2],
        };
        for (ArrayList<Integer> cell : square) {
            if (cell != null && cell.size() == 1) {
                result.add(cell.get(0));
            }
        }
        return result;
    }
}

class Possibilities extends ArrayList<Integer> {
    Possibilities() {
        super();
    }
    Possibilities(Integer[] values) {
        super(Arrays.asList(values));
    }
    static Possibilities Default() {
        Integer[] values = {1,2,3,4,5,6,7,8,9};
        return new Possibilities(values);
    }
}