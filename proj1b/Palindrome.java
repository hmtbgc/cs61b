public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            d.addLast(c);
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d, temp;
        d = wordToDeque(word);
        temp = wordToDeque(word);
        String forward, backward;
        forward = backward = "";
        for (int i = 0; i < d.size(); ++i) {
            forward += d.removeFirst();
            backward += temp.removeLast();
        }
        return forward.equals(backward);
    }


    private boolean helper(Deque wordDeque) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }
        if (wordDeque.removeFirst() == wordDeque.removeLast()) {
            return helper(wordDeque);
        }
        return false;
    }

    public boolean isPalindromeRecursion(String word) {
        Deque d = wordToDeque(word);
        return helper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        while (d.size() > 1) {
            char first = d.removeFirst();
            char last = d.removeLast();
            if (!(cc.equalChars(first, last))) {
                return false;
            }
        }
        return true;
    }
}
