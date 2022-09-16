import com.company.sortingandsearching.GetPeak;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetPeakTest {

    @Test
    public void first() {
        int[] ints = new int[] {1,2,3,4,5,6,7,8};
        int[] ints2 = new int[] {9,1,2,3,4,5,6,7,8};
        int[] ints3 = new int[] {9,10,12,13,4,5,6,7,8};
        int[] ints4 = new int[] {4, 5, 6, 7, 0, 1, 2};

        GetPeak getPeak = new GetPeak();
        Assertions.assertEquals(getPeak.get(ints), 7);
        Assertions.assertEquals(getPeak.get(ints2), 0);
        Assertions.assertEquals(getPeak.get(ints3), 3);
        Assertions.assertEquals(getPeak.get(ints4), 3);
    }
}
