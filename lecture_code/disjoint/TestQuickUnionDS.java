import org.junit.Test;
import static org.junit.Assert.*;

public class TestQuickUnionDS {
    @Test
    public void TestforQuickUnionDS() {
        QuickUnionDS aList = new QuickUnionDS(5);
        assertFalse(aList.isConnected(0, 1));
        aList.connect(0, 1);
        assertTrue(aList.isConnected(0, 1));
        aList.connect(2, 3);
        aList.connect(3, 4);
        int[] expect = new int[]{1, -1, 3, 4, -1};
        int[] actual = new int[aList.size()];
        for (int i = 0; i < aList.size(); ++i) {
            actual[i] = aList.getith(i);
        }
        assertArrayEquals(actual, expect);
    }
}

