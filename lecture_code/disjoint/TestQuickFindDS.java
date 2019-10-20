import org.junit.Test;
import static org.junit.Assert.*;

public class TestQuickFindDS {
    @Test
    public void TestforQuickFindDS() {
        QuickFindDS aList = new QuickFindDS(5);
        assertFalse(aList.isConnected(0, 1));
        aList.connect(0, 1);
        assertTrue(aList.isConnected(0, 1));
        aList.connect(2, 3);
        aList.connect(3, 4);
        int[] expect = new int[]{1, 1, 4, 4, 4};
        int[] actual = new int[aList.size()];
        for (int i = 0; i < aList.size(); ++i) {
            actual[i] = aList.getith(i);
        }
        assertArrayEquals(actual, expect);
    }
}
