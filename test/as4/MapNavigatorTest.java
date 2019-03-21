/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as4;

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
        int[][] map = null;
        int rowTarget = 0;
        int colTarget = 0;
        MapNavigator instance = new MapNavigator();
        int[][] expResult = null;
        int[][] result = instance.getNavMap(map, rowTarget, colTarget);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
