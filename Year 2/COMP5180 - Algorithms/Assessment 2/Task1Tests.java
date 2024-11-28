import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;

import org.junit.Before;

/**
 * Tests for Task 1 of the Algorithms A2 assignment
 * 
 * Passing these tests is not a guarantee that your solution is completely correct
 * and there is no guarantee that these tests are correct.
 * 
 * @author lb851 & Sean Chan
 */
public class Task1Tests {

    private final Task1 solution = new Task1();
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    @Before
    public void setUp() {

        // Redirect the standard output to the ByteArrayOutputStream
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
    }

    @Test
    public void testHeight0() {
        solution.setTowerSize(0);
        solution.reverseToH(0, 1, 3);

        String output = baos.toString();
        String expectedOutput = "";
        assertEquals(expectedOutput.replaceAll("\\s+", ""), output.replaceAll("\\s+", ""));
    }

    @Test
    public void testHeightNegative() {
        solution.setTowerSize(-1);
        solution.reverseToH(-1, 1, 3);

        String output = baos.toString();
        String expectedOutput = "";
        assertEquals(expectedOutput.replaceAll("\\s+", ""), output.replaceAll("\\s+", ""));
    }

    @Test
    public void testHeight1() {
        solution.setTowerSize(1);
        solution.reverseToH(1, 1, 3);

        String output = baos.toString();
        String expectedOutput = """
                Move Disk 1 from Peg 1 to Peg 3
                """;
        assertEquals(expectedOutput.replaceAll("\\s+", ""), output.replaceAll("\\s+", ""));
    }

    @Test
	public void SeanLikesGoTrue(){
		Task2 t2 = new Task2();
		HashSet<String> strings = new HashSet<String>();
		strings.add("Sean");
		strings.add("Likes");
		strings.add("Go");
		strings.add("SeanLikesGo");
		t2.setStrings(strings);
		boolean output = t2.stringSum();
		Assert.assertEquals(true, output);
	}

    	@Test
	public void SeanLikesGoFalse(){
		Task2 t2 = new Task2();
		HashSet<String> strings = new HashSet<String>();
		strings.add("Sean");
		strings.add("Likes");
		strings.add("go");
		strings.add("SeanLikesGo");
		t2.setStrings(strings);
		boolean output = t2.stringSum();
		Assert.assertEquals(false, output);
	}

    @Test 
	public void LucaLikesRustTrue(){
		Task2 t2 = new Task2();
		HashSet<String> strings = new HashSet<String>();
		strings.add("l");
		strings.add("uca");
		strings.add("luca");	
		strings.add("likes");
		strings.add("rust");
		strings.add("lucalikesrust");
		t2.setStrings(strings);
		boolean output = t2.stringSum();
		Assert.assertEquals(true, output);
	}

    @Test
    public void testHeight3() {
        solution.setTowerSize(3);
        solution.reverseToH(3, 1, 3);

        String output = baos.toString();
        String expectedOutput = """
                Move Disk 3 from Peg 1 to Peg 3
                Move Disk 2 from Peg 1 to Peg 2
                Move Disk 3 from Peg 3 to Peg 2
                Move Disk 1 from Peg 1 to Peg 3
                Move Disk 3 from Peg 2 to Peg 1
                Move Disk 2 from Peg 2 to Peg 3
                Move Disk 3 from Peg 1 to Peg 3
                """;
        assertEquals(expectedOutput.replaceAll("\\s+", ""), output.replaceAll("\\s+", ""));
    }

    @Test
    public void testSameSourceAndDestination() {
        solution.setTowerSize(3);
        solution.reverseToH(3, 1, 1);

        String output = baos.toString();
        String expectedOutput = "";
        assertEquals(expectedOutput.replaceAll("\\s+", ""), output.replaceAll("\\s+", ""));
    }

    @Test
    public void testHeight4DifferentSourceAndDestination() {
        solution.setTowerSize(4);
        solution.reverseToH(4, 1, 2);

        String output = baos.toString();
        String expectedOutput = """
                                Move Disk 4 from Peg 1 to Peg 3
                Move Disk 3 from Peg 1 to Peg 2
                Move Disk 4 from Peg 3 to Peg 2
                Move Disk 2 from Peg 1 to Peg 3
                Move Disk 4 from Peg 2 to Peg 1
                Move Disk 3 from Peg 2 to Peg 3
                Move Disk 4 from Peg 1 to Peg 3
                Move Disk 1 from Peg 1 to Peg 2
                Move Disk 4 from Peg 3 to Peg 2
                Move Disk 3 from Peg 3 to Peg 1
                Move Disk 4 from Peg 2 to Peg 1
                Move Disk 2 from Peg 3 to Peg 2
                Move Disk 4 from Peg 1 to Peg 3
                Move Disk 3 from Peg 1 to Peg 2
                Move Disk 4 from Peg 3 to Peg 2
                                """;
        assertEquals(expectedOutput.replaceAll("\\s+", ""), output.replaceAll("\\s+", ""));
    }

    @Test
    public void testHeight5() {
        solution.setTowerSize(5);
        solution.reverseToH(5, 1, 3);

        String output = baos.toString();
        String expectedOutput = """
                Move Disk 5 from Peg 1 to Peg 3
                Move Disk 4 from Peg 1 to Peg 2
                Move Disk 5 from Peg 3 to Peg 2
                Move Disk 3 from Peg 1 to Peg 3
                Move Disk 5 from Peg 2 to Peg 1
                Move Disk 4 from Peg 2 to Peg 3
                Move Disk 5 from Peg 1 to Peg 3
                Move Disk 2 from Peg 1 to Peg 2
                Move Disk 5 from Peg 3 to Peg 2
                Move Disk 4 from Peg 3 to Peg 1
                Move Disk 5 from Peg 2 to Peg 1
                Move Disk 3 from Peg 3 to Peg 2
                Move Disk 5 from Peg 1 to Peg 3
                Move Disk 4 from Peg 1 to Peg 2
                Move Disk 5 from Peg 3 to Peg 2
                Move Disk 1 from Peg 1 to Peg 3
                Move Disk 5 from Peg 2 to Peg 1
                Move Disk 4 from Peg 2 to Peg 3
                Move Disk 5 from Peg 1 to Peg 3
                Move Disk 3 from Peg 2 to Peg 1
                Move Disk 5 from Peg 3 to Peg 2
                Move Disk 4 from Peg 3 to Peg 1
                Move Disk 5 from Peg 2 to Peg 1
                Move Disk 2 from Peg 2 to Peg 3
                Move Disk 5 from Peg 1 to Peg 3
                Move Disk 4 from Peg 1 to Peg 2
                Move Disk 5 from Peg 3 to Peg 2
                Move Disk 3 from Peg 1 to Peg 3
                Move Disk 5 from Peg 2 to Peg 1
                Move Disk 4 from Peg 2 to Peg 3
                Move Disk 5 from Peg 1 to Peg 3
                """;
        assertEquals(expectedOutput.replaceAll("\\s+", ""), output.replaceAll("\\s+", ""));
    }
}