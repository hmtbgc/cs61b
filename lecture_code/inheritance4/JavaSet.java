import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JavaSet {
    public static void main(String[] args) {
        Set<Integer> javaSet = new HashSet<>();
        javaSet.add(1);
        javaSet.add(2);
        for (int i : javaSet) {
            System.out.println(i);
        }

        /*
        ArraySet<Integer> javaArraySet = new ArraySet<>();
        javaArraySet.add(1);
        javaArraySet.add(2);
        for (int i : javaArraySet) {
            System.out.println(i);
        }

         */

        Iterator<Integer> seer = javaSet.iterator();
        while (seer.hasNext()) {
            System.out.println(seer.next());
        }
    }
}
