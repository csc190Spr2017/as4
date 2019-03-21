/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as4;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author csc190
 */
public class MapNavigatorTest {
    
    public MapNavigatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNavMap method, of class MapNavigator.
     */
    @Test
    public void testGetNavMap() {
        System.out.println("getNavMap");
        int[][] map = new int [][] {
            {0, 1, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int rowTarget = 0;
        int colTarget = 2;
        MapNavigator instance = new MapNavigator();
        int[][] expResult = new int [][] {
            {4, Integer.MAX_VALUE, 0},
            {3, Integer.MAX_VALUE, 1},
            {3, 2, 2}
        };
        int[][] result = instance.getNavMap(map, rowTarget, colTarget);
        assertArrayEquals(expResult, result);
        
    }
    
    @Test
    public void testSpeed(){//for 200x200 matrix, has to be handled within 5 seconds
        int [][] map = new int [200][200];
        Random rand = new Random();
        for(int i=0; i<200; i++){
            for(int j=0; j<200; j++){
                map[i][j] = rand.nextInt(2);
            }
        }
        
        MapNavigator inst = new MapNavigator();
        StopWatch timer = new StopWatch("timer");
        timer.start();
        final int TIMES = 10;
        for(int times=0; times<TIMES; times++){
            int [][] res = inst.getNavMap(map, 190, 190);
        }
        timer.stop();
        long msTotal = timer.getElapsed();
        System.out.println("AVG TIME: " + msTotal/TIMES + " millisec.");
        if(msTotal/TIMES>5){
            fail("Too much time for 200x200 case");
        }
    }
    
}
