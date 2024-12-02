import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Task 3 of the Algorithms A2 assignment
 * 
 * Passing these tests is not a guarantee that your solution is correct.
 * 
 * @author lb851 & Sean Chan
 * @version 1.1
 */
public class Task3Tests {

    private final Task3 solution = new Task3();

    @Test
    public void testEmptyGrid() {
        int[][] map = new int[0][0];
        solution.setMap(map);
        assertEquals(0, solution.dig(5));
    }

    @Test
    public void testSingleRowGrid() {
        int[][] map = new int[][] { new int[] { 0, 0, 3, 0, 0 } };
        solution.setMap(map);
        assertEquals(15, solution.dig(5));
    }

    @Test
    public void testSingleColumnGrid() {
        int[][] map = new int[][] { new int[] { 0 }, new int[] { 0 }, new int[] { 3 }, new int[] { 0 },
                new int[] { 0 } };
        solution.setMap(map);
        assertEquals(9, solution.dig(5));
    }

    @Test
    public void testComplexGrid() {
        int[][] map = new int[][] {
                new int[] { 0, 1, 1, 0, 0 },
                new int[] { 2, 0, 0, 0, 0 },
                new int[] { 0, 0, 3, 1, 0 },
                new int[] { 1, 0, 0, 1, 0 },
                new int[] { 0, 1, 0, 0, 5 } };
        solution.setMap(map);
        assertEquals(13, solution.dig(6));
    }

    @Test
    public void testNonSquareGrid() {
        int[][] map = new int[][] {
                new int[] { 0, 1, 1, 0, 0 },
                new int[] { 2, 0, 0, 0, 0 },
                new int[] { 0, 0, 1, 1, 0 },
                new int[] { 1, 0, 0, 3, 0 },
                new int[] { 0, 1, 0, 0, 0 },
                new int[] { 0, 1, 3, 0, 0 },
                new int[] { 0, 0, 0, 0, 0 },
                new int[] { 0, 1, 3, 12, 0 } };
        solution.setMap(map);
        assertEquals(16, solution.dig(8));
    }

    @Test
    public void testNonSquareGrid2() {
        int[][] map = new int[][] {
                new int[] { 0, 1, 1, 0, 0, 0, 1, 2, 1 },
                new int[] { 0, 0, 0, 0, 0, 0, 1, 2, 1 },
                new int[] { 0, 1, 0, 0, 1, 0, 0, 0, 0 },
                new int[] { 0, 1, 2, 1, 0, 0, 1, 0, 1 },
                new int[] { 0, 1, 0, 0, 0, 2, 0, 2, 0 },
                new int[] { 0, 1, 1, 1, 3, 0, 1, 0, 1 },
                new int[] { 0, 1, 1, 0, 5, 0, 1, 0, 1 },
                new int[] { 0, 1, 1, 0, 0, 0, 1, 2, 1 } };
        solution.setMap(map);
        assertEquals(16, solution.dig(8));
    }

    @Test
    public void testAbnormallySizedGrid() {
        int[][] map = new int[][] {
                new int[] { 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0 },
                new int[] { 0, 0, 0, 0, 0, 83 } };
        solution.setMap(map);
        assertEquals(415, solution.dig(10));
    }

    // Running this without memoization or a cache is not recommended.
    // If you want to run this test, uncomment the line below.
    @Test
    public void testBiggerBattery() {
        int[][] map = new int[][] {
                new int[] { 0, 1, 1, 0, 0 },
                new int[] { 2, 0, 0, 0, 0 },
                new int[] { 0, 0, 3, 1, 0 },
                new int[] { 1, 0, 0, 1, 0 },
                new int[] { 6, 1, 0, 0, 5 } };
        solution.setMap(map);
        assertEquals(129, solution.dig(25));
    }

    // Running this without memoization or a cache is not recommended.
    // If you want to run this test, uncomment the line below.
    @Test
    public void testAbsurdlyLargeBattery() {
        int[][] map = new int[][] {
                new int[] { 0, 1, 1, 0, 0 },
                new int[] { 2, 1, 0, 2, 0 },
                new int[] { 3, 4, 3, 1, 2 },
                new int[] { 1, 3, 6, 1, 0 },
                new int[] { 6, 3, 5, 3, 7 } };
        solution.setMap(map);
        assertEquals(326, solution.dig(50));
    }

    // Running this without memoization or a cache is not recommended.
    // If you want to run this test, uncomment the line below.
    @Test
    public void testUnrealisticBattery() {
        int[][] map = new int[][] {
                new int[] { 0, 1, 1, 0, 0 },
                new int[] { 2, 1, 0, 2, 0 },
                new int[] { 3, 4, 3, 1, 2 },
                new int[] { 1, 3, 6, 1, 0 },
                new int[] { 6, 3, 5, 3, 7 },
                new int[] { 3, 1, 1, 2, 0 },
                new int[] { 6, 3, 5, 3, 12 },
                new int[] { 19, 1, 18, 5, 7 },
                new int[] { 52, 15, 22, 32, 12 } };
        solution.setMap(map);
        assertEquals(25624, solution.dig(500));
    }
}
