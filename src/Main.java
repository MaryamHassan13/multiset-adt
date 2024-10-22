import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void profileMultiSet(MultiSet myInput, int n) {
        List<Integer> itemsAdded = new ArrayList<>();
        Random rand = new Random();
        for (int i=0;i<n; i++) {
            int x = rand.nextInt(100) + 1;
            myInput.add(x);
            itemsAdded.add(x);
        }
        assert myInput.size() == n;
        long startMilliseconds = System.currentTimeMillis();
        long startSeconds = startMilliseconds / 1000;
        for (int x : itemsAdded) {
            myInput.remove(x);
        }
        long endMilliseconds = System.currentTimeMillis();
        long endSeconds = endMilliseconds / 1000;
        assert myInput.isEmpty();
        System.out.printf("%5d %37s %d%n", n, myInput.getClass(), endMilliseconds - startMilliseconds);
    }

    public static void main(String[] args) {
        // TODO complete this psvm main method to replicate the timing experiment from adts.py.
        //      Note: this will be client code of the various other classes needing to be written.
        MultiSet treeMultiSet = new TreeMultiSet();
        List<Integer> values = new ArrayList<>();
        values.add(500);
        values.add(1000);
        values.add(2000);
        values.add(4000);
        for (Integer n : values) {
            profileMultiSet(treeMultiSet,n);
        }
    }
}
