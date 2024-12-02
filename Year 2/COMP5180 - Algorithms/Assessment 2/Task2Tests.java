import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Task 2 of the Algorithms A2 assignment
 * 
 * Passing these tests is not a guarantee that your solution is correct.
 * 
 * @author lb851 & Sean Chan
 * @version 1.1
 */
public class Task2Tests {

    private final Task2 solution = new Task2();

    @Test
    public void testSingleElementSet() {
        HashSet<String> strings = new HashSet(Set.of("abc"));
        solution.setStrings(strings);
        assertFalse(solution.stringSum());
    }

    @Test
    public void testNonConcatenableStrings() {
        HashSet<String> strings = new HashSet<>(Set.of("abc", "def", "ghi"));
        solution.setStrings(strings);
        assertFalse(solution.stringSum());
    }

    @Test
    public void testConcatenableString() {
        HashSet<String> strings = new HashSet<>(Set.of("abc", "def", "abcdef"));
        solution.setStrings(strings);
        assertTrue(solution.stringSum());
    }

    @Test
    public void testEmptySet() {
        HashSet<String> strings = new HashSet<>(Set.of());
        solution.setStrings(strings);
        assertFalse(solution.stringSum());
    }

    @Test
    public void testCaseSensitivity() {
        HashSet<String> strings = new HashSet<>(Set.of("Comp", "5180", "COMP5180"));
        solution.setStrings(strings);
        assertFalse(solution.stringSum());
    }

    @Test
    public void testConcatenationWithRepetition() {
        HashSet<String> strings = new HashSet<>(Set.of("a", "aa", "aaa", "aaaa"));
        solution.setStrings(strings);
        assertTrue(solution.stringSum());
    }

    @Test
    public void testMultipleConcatenableStrings() {
        HashSet<String> strings = new HashSet<>(Set.of("cat", "dog", "catdog", "dogcat"));
        solution.setStrings(strings);
        assertTrue(solution.stringSum());
    }

    @Test
    public void testSelfConcatenationNotAllowed() {
        HashSet<String> strings = new HashSet<>(Set.of("hello", "world", "helloworldhello"));
        solution.setStrings(strings);
        assertFalse(solution.stringSum());
    }

    @Test
    public void testLongerConcatenatedString() {
        HashSet<String> strings = new HashSet<>(Set.of("abc", "def", "ghi", "abcdefghi"));
        solution.setStrings(strings);
        assertTrue(solution.stringSum());
    }

    @Test
    public void testConcatenationWithOverlappingSubstrings() {
        HashSet<String> strings = new HashSet<>(Set.of("cat", "cats", "dog", "catsdog"));
        solution.setStrings(strings);
        assertTrue(solution.stringSum());
    }

    @Test
    public void testWithSpaces() {
        HashSet<String> strings = new HashSet<>(Set.of(" ", "  ", "   "));
        solution.setStrings(strings);
        assertTrue(solution.stringSum());
    }

    @Test
    public void testEmptyStringWithSpaces() {
        HashSet<String> strings = new HashSet<>(Set.of("", " ", "  "));
        solution.setStrings(strings);
        assertFalse(solution.stringSum());
    }

    @Test
    public void testEmptyStringwithWords() {
        HashSet<String> strings = new HashSet<>(Set.of("", "hello", "world"));
        solution.setStrings(strings);
        assertFalse(solution.stringSum());
    }

    @Test
    public void testWordsWithSpaces() {
        HashSet<String> strings = new HashSet<>(Set.of("Hello ", "World", "Hello World"));
        solution.setStrings(strings);
        assertTrue(solution.stringSum());
    }

    @Test
    public void SeanLikesGoTrue() {
        HashSet<String> strings = new HashSet<>(Set.of("Sean", "Likes", "Go", "SeanLikesGo"));
        solution.setStrings(strings);
        boolean output = solution.stringSum();
        assertEquals(true, output);
    }

    @Test
    public void SeanLikesGoFalse() {
        HashSet<String> strings = new HashSet<>(Set.of("Sean", "Likes", "go", "SeanLikesGo"));
        solution.setStrings(strings);
        boolean output = solution.stringSum();
        assertEquals(false, output);
    }

    @Test
    public void LucaLikesRustTrue() {
        HashSet<String> strings = new HashSet<>(Set.of("l", "uca", "luca", "likes", "rust", "lucalikesrust"));
        solution.setStrings(strings);
        boolean output = solution.stringSum();
        assertEquals(true, output);
    }
}
