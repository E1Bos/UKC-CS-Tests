import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * RBTTest
 *
 * --------------------------------------------------------------------
 * ⚠️ WARNING | THIS TEST ASSUMES `root` IS PUBLIC ON THE RBT CLASS ⚠️
 * --------------------------------------------------------------------
 *
 * @version 1.0.1
 * @author Daniel Wilson (dancodes.online)
 */
public class RBTTest {
    @Test
    public void testMaxHeight() {
        RBT tree = new RBT();

        tree.insert(10);

        assertEquals(1, tree.maxHeight());
    }

    @Test
    public void testMaxHeightDuplicates() {
        RBT tree = new RBT();

        tree.insert(10);
        tree.insert(10);

        assertEquals(1, tree.maxHeight());
    }

    @Test
    public void testMaxHeight_2() {
        RBT tree = new RBT();

        tree.insert(10);
        tree.insert(5);

        assertEquals(2, tree.maxHeight());
    }

    /**
     * The tree should insert like a regular tree
     */
    @Test
    public void testTreeInsert() {
        RBT rbt = new RBT();

        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(15);

        assertEquals(Node.Color.BLACK, rbt.root.getColor());
        assertEquals(Node.Color.RED, rbt.root.getLeft().getColor());
        assertEquals(Node.Color.RED, rbt.root.getRight().getColor());
    }

    /**
     * Case 1: The root is always black
     */
    @Test
    public void testInsertionCase1() {
        RBT rbt = new RBT();

        rbt.insert(10);

        assertEquals(Node.Color.BLACK, rbt.root.getColor());
    }

    /**
     * Case 2: X.uncle is red
     */
    @Test
    public void testInsertionCase2_Left() {
        RBT rbt = new RBT();

        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(15);
        rbt.insert(0);

        assertEquals(Node.Color.BLACK, rbt.root.getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getLeft().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getRight().getColor());
        assertEquals(Node.Color.RED, rbt.root.getLeft().getLeft().getColor());
        assertEquals(null, rbt.root.getRight().getLeft());
    }

    /**
     * Case 2: X.uncle is red
     */
    @Test
    public void testInsertionCase2_Right() {
        RBT rbt = new RBT();

        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(15);
        rbt.insert(20);

        assertEquals(Node.Color.BLACK, rbt.root.getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getLeft().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getRight().getColor());
        assertEquals(Node.Color.RED, rbt.root.getRight().getRight().getColor());
        assertEquals(null, rbt.root.getRight().getLeft());
    }

    /**
     * Case 3: X.uncle is black (triangle)
     * Case 4: X.uncle is black (line)
     */
    @Test
    public void testInsertionCase3_Left() {
        RBT rbt = new RBT();

        rbt.insert(10);
        rbt.insert(12);
        rbt.insert(11);

        assertEquals(Node.Color.BLACK, rbt.root.getColor());
        assertEquals(Node.Color.RED, rbt.root.getLeft().getColor());
        assertEquals(Node.Color.RED, rbt.root.getRight().getColor());

    }

    /**
     * Case 3: X.uncle is black (triangle)
     * Case 4: X.uncle is black (line)
     */
    @Test
    public void testInsertionCase3_Right() {
        RBT rbt = new RBT();

        rbt.insert(10);
        rbt.insert(8);
        rbt.insert(9);

        assertEquals(Node.Color.BLACK, rbt.root.getColor());
        assertEquals(Node.Color.RED, rbt.root.getLeft().getColor());
        assertEquals(Node.Color.RED, rbt.root.getRight().getColor());

    }

    /**
     * Test from 100-1
     */
    @Test
    public void testBigTree() {
        RBT rbt = new RBT();

        for (int i = 100; i > 0; i--) {
            rbt.insert(i);
        }

        assertEquals(Node.Color.BLACK, rbt.root.getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getLeft().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getRight().getColor());
        assertEquals(Node.Color.RED, rbt.root.getLeft().getLeft().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getLeft().getRight().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getRight().getLeft().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getRight().getRight().getColor());

        assertEquals(69, rbt.root.getData());
    }

    /**
     * Test of 100 random numbers (no duplicates)
     */
    @Test
    public void testRandomBigTree() {
        RBT rbt = new RBT();

        List<Integer> nums = List.of(11, 49, 43, 44, 7, 25, 22, 76, 34, 66, 77, 86, 46, 61, 21, 17, 91, 8, 4, 47, 24,
                20, 1, 63, 38, 27, 29, 80, 26, 88, 97, 48, 36, 89, 28, 6, 99, 42, 14, 68, 59, 37, 79, 69, 84, 50, 92,
                13, 55, 23, 30, 39, 98, 54, 5, 16, 41, 33, 81, 93, 40, 2, 19, 12, 70, 3, 32, 15, 45, 10, 35, 18, 73, 9,
                95, 56, 62, 78, 60, 53, 67, 57, 72, 65, 71, 90, 58, 74, 94, 75, 96, 85, 100, 52, 83, 87, 82, 31, 64,
                51);

        for (int i : nums) {
            rbt.insert(i);
        }

        assertEquals(Node.Color.BLACK, rbt.root.getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getLeft().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getRight().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getLeft().getLeft().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getLeft().getRight().getColor());
        assertEquals(Node.Color.RED, rbt.root.getRight().getLeft().getColor());
        assertEquals(Node.Color.BLACK, rbt.root.getRight().getRight().getColor());

        assertEquals(43, rbt.root.getData());
        assertEquals(9, rbt.maxHeight());
    }

    /**
     * Test from 100000-1
     */
    @Test
    public void testLargeTree() {
        RBT rbt = new RBT();

        long start = System.currentTimeMillis();

        for (int i = 100000; i > 0; i--) {
            rbt.insert(i);
        }

        long end = System.currentTimeMillis();

        assertEquals(67233, rbt.root.getData());
        assertEquals(rbt.maxHeight(), 31);

        assertTrue(end - start < 5000);
    }
}
