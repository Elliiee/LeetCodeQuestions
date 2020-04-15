import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _286WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{-1, 0},
            new int[] {1, 0},
            new int[] {0, -1},
            new int[] {0, 1}
    );

    public void wallsAndGates(int[][] rooms){
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (rooms[r][c] == GATE){
                    queue.add(new int[]{r, c});
                }
            }
        }
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction: DIRECTIONS){
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < m || c < n || r >= m || c >= n || rooms[r][c] != EMPTY){
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[]{r, c});
            }
        }
    }
}
