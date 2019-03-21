/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as4;

/**
 * Provides the navigation service
 * @author csc190
 */
public class MapNavigator {
    /***
     * Generate the navigation map
     * @param map - each cell has 0 or 1. 0 means not a block. 1 means a block.
     * @param rowTarget - target location. First dimension index.
     * @param colTarget - target location. Second dimension index.
     * @return a 2d map where each cell represents the distance/cost to the target. If not reachable
     * from target, then the distance is Integer.MAX_VALUE;
     */
    public int [][] getNavMap(int [][] map, int rowTarget, int colTarget){
        /**
         * Slow VERSION. Update the matrix whenever there is a neigbor that
         * could lead to a lower value. Worst complexity O(n^2) where n is 
         * the total number of cells.
         */
        int [][] res = new int [map.length][map[0].length];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                res[i][j] = i==rowTarget && j==colTarget? 0: Integer.MAX_VALUE;
            }
        }
        
        boolean bChanged = true;
        while(bChanged){//continue until no changes are made in the last pass
            bChanged = false;
            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[0].length;j++){
                    if(map[i][j]==0){//that is the cell can be updated
                        //check each of its neighbor cell and see if it lead to better distance
                        for(int offX=-1; offX<=1; offX++){
                            for(int offY=-1; offY<=1; offY++){
                                int nbX = i+offX;
                                int nbY = j+offY;
                                if(nbX<0 || nbX>=map.length || nbY<0 || nbY>=map[0].length){
                                    continue;// invalid coordinates. 
                                }
                                //NOW it's valid coordinate
                                int candidateDist = res[nbX][nbY] + 1;
                                if(res[i][j]>candidateDist){
                                    res[i][j] = candidateDist;
                                    bChanged = true; 
                                }
                            }
                        }
                    }
                }
            }
            
        }
        
        
        return res;
    }
}
