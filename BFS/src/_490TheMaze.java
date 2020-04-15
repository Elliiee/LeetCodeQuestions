import java.util.LinkedList;
import java.util.Queue;

public class _490TheMaze {
    private int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination){
        int m = maze.length;
        if (m == 0) return false;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()){
            int[] s = queue.poll();

            if (s[0] == destination[0] && s[1] == destination[1]){
                return true;
            }

            for (int[] d : directions){
                int r = s[0] + d[0];
                int c = s[1] + d[1];

                //keep on adding the particular entry of the directions array till we hit a wall or a boundary
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0){
                    r += d[0];
                    c += d[1];
                }

                // mark the position before hitting the wall or boundary as visited
                // and add it to the queue
                if (!visited[r - d[0]][c - d[1]]){
                    queue.add(new int[]{r - d[0], c - d[1]});
                    visited[r - d[0]][c - d[1]] = true;
                }
            }
        }
        return false;
    }
}
