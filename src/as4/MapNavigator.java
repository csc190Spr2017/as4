/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

/**
 * Provides the navigation service
 *
 * @author csc190
 */
public class MapNavigator {

    /**
     * *
     * Generate the navigation map
     *
     * @param map - each cell has 0 or 1. 0 means not a block. 1 means a block.
     * @param rowTarget - target location. First dimension index.
     * @param colTarget - target location. Second dimension index.
     * @return a 2d map where each cell represents the distance/cost to the
     * target. If not reachable from target, then the distance is
     * Integer.MAX_VALUE;
     */
    public int[][] getNavMap(int[][] map, int rowTarget, int colTarget) {
        /**
         * FAST Version. BFS Search (given all neighbor distance is 1). Idea:
         * keep a queue of to be processed and keep track of the "visited" state
         * of all cells - never process the same cell again.
         */
        int[][] res = new int[map.length][map[0].length]; //result to return
        boolean[][] visited = new boolean[map.length][map[0].length]; //whether visited
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                res[i][j] = i == rowTarget && j == colTarget ? 0 : Integer.MAX_VALUE;
                visited[i][j] = map[i][j] == 0 ? false : true; //don't visit blocks
            }
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        queue.add(new Pair(rowTarget, colTarget));
        visited[rowTarget][colTarget] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.remove();
            int x = pair.getKey();
            int y = pair.getValue();

            //update each of its neighbors
            for (int xOffset = -1; xOffset <= 1; xOffset++) {
                for (int yOffset = -1; yOffset <= 1; yOffset++) {
                    int nbX = x + xOffset;
                    int nbY = y + yOffset;
                    if (nbX < 0 || nbY < 0 || nbX >= map.length || nbY >= map[0].length) {
                        continue; //out of range
                    }
                    if (xOffset == 0 && yOffset == 0) {
                        continue;
                    }
                    //NOW valid indexes
                    if (map[nbX][nbY] == 0 && !visited[nbX][nbY]) {//not blocks
                        visited[x][y] = true;
                        int newval = res[x][y] + 1;
                        res[nbX][nbY] = newval;
                        queue.add(new Pair(nbX, nbY));

                    }
                }
            }

        }

        return res;
    }
    
    
}
