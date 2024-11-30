import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Tests for the Computer Systems Assembler
 * 
 * Passing these tests is not a guarantee that your solution is completely
 * correct
 * and there is no guarantee that these tests are correct.
 * 
 * @author lb851 & Sean Chan
 */
public class RunTest {

	public static String getAssemblerOutput(String input) {
		StringWriter output = new StringWriter();
		Assembler asm = new Assembler(input, output);

		try {
			asm.assemble();
		} catch (IOException ex) {
			System.err.println("Exception running test.");
			return null;
		}

		return output.toString().trim();
	}

	public static void isEqual(String input, String expected) {
		String output = getAssemblerOutput(input);

		assertEquals(expected.trim(), output);
	}

	@Test
	public void testGivenAInst21() {
		String input = """
				ldr A, $21
				""";

		String expected = "0000000000010101";

		isEqual(input, expected);
	}

	@Test
	public void testGivenCInstAsm() {
		String input = """
				ldr D, (A)
				sub D, D, (A)
				jgt D
				ldr D, (A)
				jmp
				str (A), D
				""";

		String expected = """
				1111110000010000
				1111010011010000
				1110001100000001
				1111110000010000
				1110101010000111
				1110001100001000""";

		isEqual(input, expected);
	}

	@Test
	public void testGivenAddAsm() {
		String input = """
				ldr A, $2
				ldr D, A
				ldr A, $3
				add D, D, A
				ldr A, $0
				str (A), D
				""";

		String expected = """
				0000000000000010
				1110110000010000
				0000000000000011
				1110000010010000
				0000000000000000
				1110001100001000""";

		isEqual(input, expected);
	}

	@Test
	public void testMultipleAInst() {
		String input = """
				ldr A, $44
				ldr A, $256
				ldr A, $1028
				ldr A, $1298
				ldr A, $1984
				ldr A, $12312
				ldr A, $12833
				ldr A, $32767
				""";

		String expected = """
				0000000000101100
				0000000100000000
				0000010000000100
				0000010100010010
				0000011111000000
				0011000000011000
				0011001000100001
				0111111111111111""";

		isEqual(input, expected);
	}

	@Test
	public void testAInstLotsOfSpaces() {
		String input = """
					      ldr		A    	,    	 $21
				""";

		String expected = "0000000000010101";

		isEqual(input, expected);
	}

	@Test
	public void testInvalidAInst() {
		String input = """
				ldr D, $21
				""";

		String expected = "";

		isEqual(input, expected);
	}

	@Test
	public void testInvalidAInst2() {
		String input = """
				ldr (A), $21
				""";

		String expected = "";

		isEqual(input, expected);
	}
	
	@Test
	public void testInvalidAInst3() {
		String input = """
				ldr A, 21
				""";

		String expected = "";

		isEqual(input, expected);
	}

	@Test
	public void testNegativeAInst() {
		String input = """
				ldr A, $-2
				""";

		String expected = "";

		isEqual(input, expected);
	}

	@Test
	public void testOverflowAInst() {
		String input = """
				ldr A, $32768
				""";

		String expected = "";

		isEqual(input, expected);
	}

	@Test
	public void testAWithEmptyLines() {
		String input = """
				ldr A, $23

				ldr A, $44


				ldr A, $256



				ldr A, $1028
				""";

		String expected = """
				0000000000010111
				0000000000101100
				0000000100000000
				0000010000000100""";

		isEqual(input, expected);
	}

	@Test
	public void testCInst() {
		String input = """
				ldr D, A
				sub D, D, (A)
				jgt D
				ldr D, (A)
				jmp
				str (A), D
				""";

		String expected = """
				1110110000010000
				1111010011010000
				1110001100000001
				1111110000010000
				1110101010000111
				1110001100001000""";

		isEqual(input, expected);
	}

	@Test
	public void testAInstAndCInst() {
		String input = """
				ldr A, $1
				ldr (A), A
				jgt D
				ldr D, A
				jmp
				str (A), D
				""";

		String expected = """
				0000000000000001
				1110110000100000
				1110001100000001
				1110110000010000
				1110101010000111
				1110001100001000""";

		isEqual(input, expected);
	}

	@Test
	public void testCInstWithWhiteSpaces() {
		String input = """
				ldr 	D, A
					sub	 D,    D,  (A)
				jgt    D
				ldr    D    ,    A

				str    (A),    D
				""";

		String expected = """
				1110110000010000
				1111010011010000
				1110001100000001
				1110110000010000
				1110001100001000""";

		isEqual(input, expected);

	}

	@Test
	public void testAllLdrCInst() {
		String input = """
				ldr D, A
				ldr D, D
				ldr (A), A
				ldr (A), D
				ldr A, A
				ldr A, D""";

		String expected = """
				1110110000010000
				1110001100010000
				1110110000100000
				1110001100100000
				1110110000100000
				1110001100100000""";

		isEqual(input, expected);
	}

	@Test
	public void testAllStr() {
		String input = """
				str (A), A
				str (A), D
				""";

		String expected = """
				1110110000001000
				1110001100001000""";

		isEqual(input, expected);
	}

	@Test
	public void testInvalidStr() {
		String input = """
				str A, D
				""";

		String expected = "";

		isEqual(input, expected);
	}

	@Test
	public void testAdd() {
		String input = """
				add A, D, A
				add D, D, (A)
				""";

		String expected = """
				1110000010100000
				1111000010010000""";

		isEqual(input, expected);
	}

	@Test
	public void testSub() {
		String input = """
				sub A, D, A
				sub D, D, (A)
				""";

		String expected = """
				1110010011100000
				1111010011010000""";

		isEqual(input, expected);
	}

	@Test
	public void testJumps() {
		String input = """
				jgt D
				jeq A
				jge (A)
				jlt D
				jle (A)
				jne D
				jmp
				""";

		String expected = """
				1110001100000001
				1110110000000010
				1111110000000011
				1110001100000100
				1111110000000110
				1110001100000101
				1110101010000111
				""";

		isEqual(input, expected);
	}

	@Test
	public void testNonConditionalJumpWithSource() {
		String input = """
				jmp A
				jmp (A)
				jmp D
				""";

		String expected = """
				1110101010000111
				1110101010000111
				1110101010000111
				""";

		isEqual(input, expected);
	}

	@Test
	public void testLongInput() {
		String input = """
				ldr A, $4
				ldr (A), A
				jlt D
				ldr D, (A)
				jmp
				str (A), D
				ldr A, $5
				sub D, D, A
				ldr A, $6
				add D, D, A
				ldr A, $7
				str (A), D
				ldr A, $8
				sub D, D, A
				ldr A, $9
				add D, D, A
				ldr A, $10
				str (A), D
				ldr A, $11
				sub D, D, A
				ldr A, $12
				add D, D, A
				ldr A, $13
				str (A), D
				ldr A, $14
				sub D, D, A
				ldr A, $15
				add D, D, A
				ldr A, $16
				str (A), D
				""";

		String expected = """
				0000000000000100
				1110110000100000
				1110001100000100
				1111110000010000
				1110101010000111
				1110001100001000
				0000000000000101
				1110010011010000
				0000000000000110
				1110000010010000
				0000000000000111
				1110001100001000
				0000000000001000
				1110010011010000
				0000000000001001
				1110000010010000
				0000000000001010
				1110001100001000
				0000000000001011
				1110010011010000
				0000000000001100
				1110000010010000
				0000000000001101
				1110001100001000
				0000000000001110
				1110010011010000
				0000000000001111
				1110000010010000
				0000000000010000
				1110001100001000
								""";

		isEqual(input, expected);
	}

}