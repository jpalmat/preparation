package interview;

import java.util.*;

public class SudokuValidator {
    public static void main(String[] args) {
        int[][] grid =
                {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}};


        int[][] grid2 =
                        {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 3}};
        System.out.println(isValidSudoku(grid2));
    }

//Time complexity : since all we do here is just one iteration over the board with 81 cells.
//Space complexity : O(1), because there is fix number of cells of 81
    public static boolean isValidSudoku(int[][] grid) {
        //I considered 3 arrays of set
        // 1 set for every row
        Set<Integer>[] rowSet = new HashSet[9];
        // 1 set for every column
        Set<Integer>[] colSet = new HashSet[9];
        // 1 set for every box
        Set<Integer>[] boxSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }


        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                // check rows => if there is a duplicate => contains method will return false.
                if (!rowSet[i].add(grid[i][j])) return false;

                // check columns => if there is a duplicate => contains method will return false.
                if (!colSet[i].add(grid[i][j])) return false;

                //check boxes => if there is a duplicate => contains method will return false.
                int idx = 3 * (i / 3) + j / 3;
                if (!boxSet[idx].add(grid[i][j])) return false;
            }
        }
        return true;
    }
}
