import com.company.sortingandsearching.SearchInRotatedSortedArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInRotatedSortedArrayTest {

    @Test
    public void first() {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        int[] ints2 = {3 ,1};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
//        Assertions.assertEquals(4, searchInRotatedSortedArray.search(ints,0));
        Assertions.assertEquals(-1, searchInRotatedSortedArray.search(ints2,0));
    }
}
