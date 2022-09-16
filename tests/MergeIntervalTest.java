import com.company.sortingandsearching.MergeInterval;
import org.junit.jupiter.api.Test;

public class MergeIntervalTest {


    @Test
    public void first() {
        int[][] ints = new int[][]{
                new int[]{6, 7},
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 18}
        };

        MergeInterval mergeInterval = new MergeInterval();
        int[][] merge = mergeInterval.merge(ints);
    }
}
