import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // Use arrays instead of HashMaps to store row → y-list and col → x-list
        ArrayList<Integer>[] row = new ArrayList[n + 1];
        ArrayList<Integer>[] col = new ArrayList[n + 1];

        // Initialize array lists
        for (int i = 0; i <= n; i++) {
            row[i] = new ArrayList<>();
            col[i] = new ArrayList<>();
        }

        // Fill the row and column lists
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            row[x].add(y);
            col[y].add(x);
        }

        // Sort each row and column list
        for (int i = 0; i <= n; i++) {
            if (row[i].size() > 1) Collections.sort(row[i]);
            if (col[i].size() > 1) Collections.sort(col[i]);
        }

        int covered = 0;

        // Check each building
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            ArrayList<Integer> rowList = row[x];
            ArrayList<Integer> colList = col[y];

            // Check left & right
            boolean hasLeftRight =
                rowList.size() >= 3 &&
                y != rowList.get(0) &&
                y != rowList.get(rowList.size() - 1);

            // Check up & down
            boolean hasUpDown =
                colList.size() >= 3 &&
                x != colList.get(0) &&
                x != colList.get(colList.size() - 1);

            if (hasLeftRight && hasUpDown)
                covered++;
        }

        return covered;
    }
}
