import com.company.sortingandsearching.FindKthLargest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindKthLargestTest {

    @Test
    public void first(){
        int[] ints = new int[] {3,2,1,5,6,4};

        FindKthLargest findKthLargest = new FindKthLargest();
        int kthLargest = findKthLargest.findKthLargest(ints, 2);

        Assertions.assertEquals(kthLargest, 5);
    }
}
