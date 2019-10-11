import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN  {
    static CharacterComparator offByOne = new OffByN(3);

    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'd'));
        assertTrue((offByOne.equalChars('h', 'e')));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('z', 'x'));
    }
}
