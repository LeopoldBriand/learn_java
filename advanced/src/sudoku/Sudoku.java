package sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

public class Sudoku {
    @SuppressWarnings("unchecked")
    public Optional<Integer>[][] grid = new Optional[9][9];

    public Optional<Integer>[] getRow(Integer rowNumber) {
        return grid[rowNumber];
    }

    public Optional<Integer>[] getColumn(Integer columnNumber) {
        @SuppressWarnings("unchecked")
        Optional<Integer>[] result = new Optional[9];
        int index = 0;
        for (Optional<Integer>[] row : grid) {
            result[index] = row[columnNumber];
            index++;
        }
        return result;
    }

    public Optional<Integer>[] getSquare(Integer squareNumber) {
        Integer x = (int)Math.floor(squareNumber/3)*3;
        Integer y = (int)Math.floor(squareNumber%3)*3;
        @SuppressWarnings("unchecked")
        Optional<Integer>[] result = new Optional[]{
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
        return result;
    }

    public boolean check() {
        // Check rows
        for (int i = 0; i <9; i++) {
            Integer[] row = (Integer[]) Arrays.stream(getRow(i)).filter(Optional::isPresent).map(Optional::get).toArray();
            if(hasIdenticalValues(row)) {return false;}
            Integer[] column = (Integer[]) Arrays.stream(getColumn(i)).filter(Optional::isPresent).map(Optional::get).toArray();
            if(hasIdenticalValues(column)) {return false;}
        }
        return true;
    } 

    private boolean hasIdenticalValues(Integer[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true; 
            }
        }
        return false;
    }

    public void parse(String data) {
        char[] rawData = data.replaceAll("[^0-9]", "").toCharArray();
        
        for (int i = 0; i < rawData.length; i++) {
            Integer n = Character.getNumericValue(rawData[i]);
            grid[i/9][i%9] = n > 0 ? Optional.of(n) : Optional.empty();
        }
    }

    public void print() {
        System.out.println("+-------+-------+-------+" );
        System.out.println("| " + getValue(0,0) +" "+ getValue(0,1) +" "+ getValue(0,2) + " | " + getValue(0,3) +" "+ getValue(0,4) +" "+ getValue(0,5) + " | " + getValue(0,6) +" "+ getValue(0,7) +" "+ getValue(0,8) + " |");
        System.out.println("| " + getValue(1,0) +" "+ getValue(1,1) +" "+ getValue(1,2) + " | " + getValue(1,3) +" "+ getValue(1,4) +" "+ getValue(1,5) + " | " + getValue(1,6) +" "+ getValue(1,7) +" "+ getValue(1,8) + " |");
        System.out.println("| " + getValue(2,0) +" "+ getValue(2,1) +" "+ getValue(2,2) + " | " + getValue(2,3) +" "+ getValue(2,4) +" "+ getValue(2,5) + " | " + getValue(2,6) +" "+ getValue(2,7) +" "+ getValue(2,8) + " |");
        System.out.println("+-------+-------+-------+" );
        System.out.println("| " + getValue(3,0) +" "+ getValue(3,1) +" "+ getValue(3,2) + " | " + getValue(3,3) +" "+ getValue(3,4) +" "+ getValue(3,5) + " | " + getValue(3,6) +" "+ getValue(3,7) +" "+ getValue(3,8) + " |");
        System.out.println("| " + getValue(4,0) +" "+ getValue(4,1) +" "+ getValue(4,2) + " | " + getValue(4,3) +" "+ getValue(4,4) +" "+ getValue(4,5) + " | " + getValue(4,6) +" "+ getValue(4,7) +" "+ getValue(4,8) + " |");
        System.out.println("| " + getValue(5,0) +" "+ getValue(5,1) +" "+ getValue(5,2) + " | " + getValue(5,3) +" "+ getValue(5,4) +" "+ getValue(5,5) + " | " + getValue(5,6) +" "+ getValue(5,7) +" "+ getValue(5,8) + " |");
        System.out.println("+-------+-------+-------+" );
        System.out.println("| " + getValue(6,0) +" "+ getValue(6,1) +" "+ getValue(6,2) + " | " + getValue(6,3) +" "+ getValue(6,4) +" "+ getValue(6,5) + " | " + getValue(6,6) +" "+ getValue(6,7) +" "+ getValue(6,8) + " |");
        System.out.println("| " + getValue(7,0) +" "+ getValue(7,1) +" "+ getValue(7,2) + " | " + getValue(7,3) +" "+ getValue(7,4) +" "+ getValue(7,5) + " | " + getValue(7,6) +" "+ getValue(7,7) +" "+ getValue(7,8) + " |");
        System.out.println("| " + getValue(8,0) +" "+ getValue(8,1) +" "+ getValue(8,2) + " | " + getValue(8,3) +" "+ getValue(8,4) +" "+ getValue(8,5) + " | " + getValue(8,6) +" "+ getValue(8,7) +" "+ getValue(8,8) + " |");
        System.out.println("+-------+-------+-------+" );
    }

    private String getValue(Integer x, Integer y) {
        Integer value = grid[x][y].orElse(0);
        return value == 0 ? "." : Integer.toString(value);
    }
}
