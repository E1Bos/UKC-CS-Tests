/***
 * 
 * 
 * @author  Sean Idisi & Luca Chan
 * @version 1.0
 * Test cases for Task1 and Task2
 */

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import org.junit.*;

public class RunTest {

	@Test
	public void testReverseH() {
		Task1 t1 = new Task1();
		int size = 3;
		t1.setTowerSize(size);	
		// Create a new output stream to capture the output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// Store a reference to the original output stream
		PrintStream originalOut = System.out; 
		// Replace the output stream with the stream we created that will store the output
		System.setOut(new PrintStream(outputStream));
		// When this function is called the output will be stored in the output stream
		t1.reverseToH(size, 1, 3);
		// We put back the original output stream
        System.setOut(originalOut);
		// We trim the output to remove any leading or trailing white spaces
		String actualOutput = outputStream.toString().trim();
		try {
			// We read the expected output from the file
			String expectedOutput = Files.readString(Path.of("expected_output.txt")).trim();	
			// We compare the actual output with the expected output
			assertEquals("The output did not match the expected result.",expectedOutput, actualOutput);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test 
	public void StringSumHelper1(){
		Task2 t2 = new Task2();
		HashSet<String> strings = new HashSet<String>();
		strings.add("S");
		strings.add("E");
		strings.add("A");
		strings.add("N");
		strings.add("SEAN");
		t2.setStrings(strings);
		boolean output = t2.stringSum();
		Assert.assertEquals(true, output);
	}

	@Test 
	public void StringSumHelper2(){
		Task2 t2 = new Task2();
		HashSet<String> strings = new HashSet<String>();
		strings.add("S");
		strings.add("E");
		strings.add("A");
		strings.add("SEAN");
		t2.setStrings(strings);
		boolean output = t2.stringSum();
		Assert.assertEquals(false, output);
	}

	@Test 
	public void StringSumHelper3(){
		Task2 t2 = new Task2();
		HashSet<String> strings = new HashSet<String>();
		strings.add("");
		strings.add("SEAN");
		t2.setStrings(strings);
		boolean output = t2.stringSum();
		Assert.assertEquals(false, output);
	}

	@Test 
	public void StringSumHelper4(){
		Task2 t2 = new Task2();
		HashSet<String> strings = new HashSet<String>();
		strings.add("L");
		strings.add("E");
		strings.add("E");
		strings.add("T");
		strings.add("C");
		strings.add("o");
		strings.add("D");
		strings.add("E");
		strings.add("LEETCODE");
		t2.setStrings(strings);
		boolean output = t2.stringSum();
		Assert.assertEquals(false, output);
	}


	@Test 
	public void StringSumHelper5(){
		Task2 t2 = new Task2();
		HashSet<String> strings = new HashSet<String>();
		strings.add("L");
		strings.add("E");
		strings.add("T");
		strings.add("C");
		strings.add("O");
		strings.add("D");
		strings.add("LETCOD");
		t2.setStrings(strings);
		boolean output = t2.stringSum();
		Assert.assertEquals(true, output);
	}



	@Test 
	public void StringSumHelper6(){
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
	public void StringSumHelper7(){
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
	public void StringSumHelper8(){
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
	public void DigTest1() {
		Task3 t3 = new Task3();
		int[][] map = new int[][] {
			
		new int[] {0,1,1,0,0},
		new int[] {2,0,0,0,0},
		new int[] {0,0,3,1,0},
		new int[] {1,0,0,1,0},
		new int[] {0,1,0,0,5}};	
		t3.setMap(map);
		Assert.assertEquals(13, t3.dig(6));
	}

	@Test 
	public void DigTest2() {
		Task3 t3 = new Task3();
		int[][] map = {
		new int[]{2, 3, 1},
		new int[] {0, 0, 0},
		new int[] {5, 4, 3}
		};	
		t3.setMap(map);
		Assert.assertEquals(9, t3.dig(3));
	}

	@Test 
	public void DigTest3() {
		Task3 t3 = new Task3();
		int[][] map = {
		{1, 3, 1, 4},
		{0, 2, 5, 0},
		{1, 0, 2, 3}	
		};	
		t3.setMap(map);
		Assert.assertEquals(21, t3.dig(5));
	}

	@Test 
	public void DigTest4() {
		Task3 t3 = new Task3();
		int[][] map = {	
		new int[]{1, 3, 1, 4},
		new int[]{0, 2, 5, 0},
		new int[]{1, 0, 2, 3},
		};	
		t3.setMap(map);
		Assert.assertEquals(0, t3.dig(0));
	}

	@Test 
	public void DigTest5() {
		Task3 t3 = new Task3();
		int[][] map = {	
			new int []{1, 2, 3},
			new int[]{4, 5, 6},
			new int[] {7, 8, 9},
		};	
		t3.setMap(map);
		Assert.assertEquals(45, t3.dig(6));
	}
}
