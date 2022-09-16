import java.util.Arrays;

import com.company.sortingandsearching.TopKFrequentElements;
import org.junit.jupiter.api.Test;

public class TopKFrequentElementsTest {


    @Test
    public void first() {


        int[] ints = new int[]{5, 3, 1, 1, 1, 3, 73, 1};


        int[] ints2 = Arrays.copyOf(ints, 5);

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] ints1 = topKFrequentElements.topKFrequent(ints, 1);


    }


}
