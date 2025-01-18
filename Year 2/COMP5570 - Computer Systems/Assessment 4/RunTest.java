import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the Computer Systems Parser
 *
 * Passing these tests is not a guarantee that your solution is completely
 * correct.
 *
 * @author lb851 & Sean Chan UWU
 * @version 1.3
 */
public class RunTest {

    public static boolean parseInput(String input) {
        Parser parser = new Parser(input);

        return parser.parse();
    }

    public static void isExpectedValue(String input, boolean expected) {
        boolean output = parseInput(input);

        assertEquals(expected, output);
    }

    @Test
    public void parseValidSingleClass() {
        String input = """
                classes {
                                class c1 {
                                    title = "Valid Single Class";
                                    groups = 12;
                                }
                            }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void lecturesShouldNotBeEmpty() {
        String input = """
                lectures {
                }

                    """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void classesShouldNotBeEmpty() {
        String input = """
                classes {
                }

                    """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void shouldOnlyContain3Mods() {
        String input = """
                assessments {
                    assessment A2 {
                    type = in-class-test;
                    title = "Hack Assembler";
                    weighting = 10%;
                    after = [A1, c2];
                    }
                }
                classes {
                    class c1 {
                    title = "Prep for A1";
                    groups = 14;
                }
                    class c2 {
                    title = "Prep for A2";
                    after = [A1, c1];
                    groups = 14;
                    }
                }
                lectures {
                    lecture L1 {
                    title = "Lecture 1";
                    }
                }
                lectures {
                    lecture L1 {
                    title = "Lecture 1";
                    }
                }
                lectures {
                    lecture L1 {
                    title = "Lecture 1";
                    }
                }
                    """;
        boolean expected = false;
        isExpectedValue(input, expected);

    }

    @Test
    public void parseValidClassNoGroup() {
        String input = """
                classes {
                    class c1 {
                        title = "Valid Class 1";
                        after = [A1];
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseValidClassGroupThenAfter() {
        String input = """
                classes {
                    class c1 {
                        title = "Valid Class 1";
                        groups = 12;
                        after = [A1];
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseValidClassAfterThenGroup() {
        String input = """
                classes {
                    class c1 {
                        title = "Valid Class 1";
                        after = [A1];
                        groups = 12;
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseInvalidClassDupeAfter() {
        String input = """
                classes {
                    class c1 {
                        title = "Class 1";
                        after = [A1];
                        groups = 12;
                        after = [A2];
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseInvalidClassDupeGroups() {
        String input = """
                classes {
                    class c1 {
                        title = "Class 1";
                        groups = 12;
                        after = [A1];
                        groups = 13;
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseInvalidClassOrder() {
        String input = """
                classes {
                    class c1 {
                        after = [A1];
                        title = "Class 1";
                        groups = 12;
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseInvalidSingleClass() {
        String input = """
                classes {
                    class c1 {
                        title = "No group :(";
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseValidMultipleClass() {
        String input = """
                classes {
                    class c1 {
                        title = "Valid Class 1";
                        groups = 1;
                    }

                    class c2 {
                        title = "Valid Class 2";
                        groups = 2;
                        }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseAllClassPermutations() {
        String input = """
                classes {
                    class c1 {
                        title = "Class 1";
                        groups = 1;
                    }

                    class c2 {
                        title = "Class 2";
                        after = [L2];
                    }

                    class c3 {
                        title = "Class 3";
                        after = [L3];
                        groups = 3;
                    }

                    class c4 {
                        title = "Class 4";
                        groups = 4;
                        after = [L4];
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseInvalidMultipleClass() {
        String input = """
                classes {
                    class c1 {
                        title = "Whoops! forgot a semicolon!"
                    }

                    class c2 {
                        title = "Valid Class!!";
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseEmptyClasses() {
        String input = """
                classes {}
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseEmptyClass() {
        String input = """
                classes {
                    class c1 {}
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseEmptyLectures() {
        String input = """
                lectures {}
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseEmptyLecture() {
        String input = """
                lectures {
                    lecture l1 {}
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseValidLecture() {
        String input = """
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseMultipleLecture() {
        String input = """
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }

                    lecture l2 {
                        title = "Lecture 2";
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseInvalidLecture() {
        String input = """
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }

                    lecture l2 {
                        title "Forgot equals sign";
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseEmptyAssessments() {
        String input = """
                assessments {}
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseEmptyAssessment() {
        String input = """
                assessments {
                    assessment a1 {}
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseValidAssessment() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "Does this test pass?";
                        weighting = 2%;
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseAssessmentThenEmpty() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "Does this test pass?";
                        weighting = 2%;
                    }
                }

                {}
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseValidAssessmentWithAfter() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "Hopefully this tests passes too!";
                        weighting = 1%;
                        after = [previousTest];
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseMultipleValidAssessment() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "Does this test pass?";
                        weighting = 2%;
                    }

                    assessment a2 {
                        type = carefully-thought-out-type-two;
                        title = "Does this test pass too?";
                        weighting = 2%;
                    }

                    assessment a3 {
                        type = some-other-test;
                        title = "ANOTHER ASSESSMENT??";
                        weighting = 101%;
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void parseMultipleValidAssessmentWithAfter() {
        String input = """
                assessments {
                    assessment a1 {
                        type = exam;
                        title = "Exam";
                        weighting = 101%;
                        after = [lastModule];
                    }
                    assessment a2 {
                        type = in-class-test;
                        title = "Idk";
                        weighting = 124%;
                        after = [A2];
                    }
                    assessment a3 {
                        type = worth-nothing;
                        title = "Void";
                        weighting = 0%;
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void testLectureWithAssessmentWrong() {
        String input = """
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }
                }
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "Does this test pass?";
                        weighting = 2%;
                        after = [l1];
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void testLectureWithAssessmentRight() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "Does this test pass?";
                        weighting = 2%;
                        after = [l1];
                    }
                }
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void testLectureWithClassWrong() {
        String input = """
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }
                }
                classes {
                    class c1 {
                        title = "Class 1";
                        after = [l1];
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void testLectureWithClassRight() {
        String input = """
                classes {
                    class c1 {
                        title = "Class 1";
                        after = [l1];
                    }
                }
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void testAllValidWrongOrder() {
        String input = """
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }
                }

                classes {
                    class c1 {
                        title = "Class 1";
                        after = [l1];
                    }
                }

                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "amazon shopping";
                        weighting = 2%;
                        after = [c1];
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void testAllValidWrongOrder2() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "amazon shopping";
                        weighting = 2%;
                        after = [c1];
                    }
                }
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }
                }
                classes {
                    class c1 {
                        title = "Class 1";
                        after = [l1];
                    }
                }

                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void testAllValidCorrectOrder() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "amazon shopping";
                        weighting = 2%;
                        after = [c1];
                    }
                }
                classes {
                    class c1 {
                        title = "Class 1";
                        after = [l1];
                    }
                }
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }
                }

                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void testAllMultipleValid() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "speed eating";
                        weighting = 2%;
                        after = [c1];
                    }

                    assessment a2 {
                        type = test-credit;
                        title = "lb851";
                        weighting = 212%;
                    }
                }
                classes {
                    class c1 {
                        title = "Class 1";
                        after = [l1];
                    }

                    class c2 {
                        title = "Class 2";
                        groups = 12;
                    }
                }
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }

                    lecture l2 {
                        title = "Lecture 2";
                    }
                }
                """;
        boolean expected = true;
        isExpectedValue(input, expected);
    }

    @Test
    public void testAllWithInvalid() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "speed eating";
                        weighting = 2%;
                        after = [c1];
                    }

                    assessment a2 {
                        type = test-credit;
                        title = "Ok im not gonna credit myself multiple times";
                        weighting = 2%;
                    }
                }
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }

                    lecture l2 {
                        title = "Lecture 2";
                    }
                }
                classes {
                    class c1 {
                        title = "Missing after or groups";
                    }
                    class c2 {
                        title = "Class 2";
                        groups = 12;
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void testMultipleLecturesKeywords() {
        String input = """
                lectures {
                    lecture l1 {
                        title = "Lecture 1";
                    }
                }

                lectures {
                    lecture l2 {
                        title = "Lecture 2";
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void testMultipleClassesKeywords() {
        String input = """
                classes {
                    class c1 {
                        title = "Class 1";
                        after = [l1];
                    }
                }

                classes {
                    class c2 {
                        title = "Class 2";
                        after = [l2];
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }

    @Test
    public void testMultipleAssessmentsKeywords() {
        String input = """
                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "this is a nice passing test!";
                        weighting = 2%;
                        after = [c1];
                    }
                }

                assessments {
                    assessment a1 {
                        type = assessment-test;
                        title = "whoops! another assessments keyword";
                        weighting = 2%;
                        after = [c1];
                    }
                }
                """;
        boolean expected = false;
        isExpectedValue(input, expected);
    }
}