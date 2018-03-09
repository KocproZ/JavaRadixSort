import org.junit.BeforeClass;
import org.junit.Test;
import pl.kocproz.radix.Main;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by KocproZ on 6/17/17.
 */
public class MainTest {

    static int cases = 9000000;
    static int[] inputList = new int[cases];
    static int[] expected;

    @BeforeClass
    public static void beforeClass() {
        Random r = new Random();
        for (int i = 0; i < cases; i++) {
            inputList[i] = r.nextInt(9000000);
        }
        expected = Arrays.copyOf(inputList, cases);
    }

    @Test
    public void sortTest() {
        int[] outputList = Main.sort(Arrays.copyOf(inputList, cases));
        Arrays.sort(expected);
        assertArrayEquals(expected, outputList);
    }

    @Test
    public void sortBinaryTest() {
        int[] outputList = Main.sortBinary(Arrays.copyOf(inputList, cases));
        Arrays.sort(expected);
        assertArrayEquals(expected, outputList);
    }

    @Test
    public void getFirstDigitTest() {
        int a = 88;
        int result = Main.getFirstDigit(a);
        assertEquals(8, result);
    }

    @Test
    public void getSecondDigitTest() {
        int a = 79;
        int result = Main.getSecondDigit(a);
        assertEquals(7, result);
    }

    @Test
    public void getThirdDigitTest() {
        int a = 32;
        int result = Main.getThirdDigit(a);
        assertEquals(0, result);
    }

    @Test
    public void getDigitTest() {
        int a = 421907;
        assertEquals(7, Main.getDigit(a, 1));
        assertEquals(0, Main.getDigit(a, 2));
        assertEquals(9, Main.getDigit(a, 3));
        assertEquals(1, Main.getDigit(a, 4));
        assertEquals(2, Main.getDigit(a, 5));
    }

}
