import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("boy"));
        assertFalse(palindrome.isPalindrome("gigi"));
        assertTrue(palindrome.isPalindrome("pip"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
    }

    @Test
    public void testIsPalindromeRecursion() {
        assertFalse(palindrome.isPalindromeRecursion("boy"));
        assertFalse(palindrome.isPalindromeRecursion("gigi"));
        assertTrue(palindrome.isPalindromeRecursion("pip"));
        assertTrue(palindrome.isPalindromeRecursion(""));
        assertTrue(palindrome.isPalindromeRecursion("a"));
    }

    @Test
    public void testIsPalindromeWithCharacterComparator() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("hshi", cc));
        assertFalse(palindrome.isPalindrome("fuhg", cc));
    }

    @Test
    public void testIsPalindromeWithCharacterComparatorN() {
        CharacterComparator cc = new OffByN(3);
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("cgf", cc));
        assertFalse(palindrome.isPalindrome("csss", cc));
        assertFalse(palindrome.isPalindrome("booooy", cc));
    }
}