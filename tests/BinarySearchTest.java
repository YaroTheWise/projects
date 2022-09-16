import com.company.sortingandsearching.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void first() {
        int[] ints = new int[]{6, 5, 4, 3};

        BinarySearch binarySearch = new BinarySearch();
        int search = binarySearch.search(ints);

        Assertions.assertEquals(search, 0);
    }


    @Test
    public void secondNew(){
        BinarySearch binarySearch = new BinarySearch();

        int[] ints = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(binarySearch.searchNew(ints, 4),3);
        Assertions.assertEquals(binarySearch.searchNew(ints, 1),0);
        Assertions.assertEquals(binarySearch.searchNew(ints, 6),5);
        Assertions.assertEquals(binarySearch.searchNew(ints, 7),-1);
        Assertions.assertEquals(binarySearch.searchNew(ints, 0),-1);
    }


    @Test
    public void thirdRecursion(){
        BinarySearch binarySearch = new BinarySearch();

        int[] ints = {1, 2, 3, 4, 5, 6};
        Assertions.assertEquals(binarySearch.searchNewRecursion(ints, 4),3);
        Assertions.assertEquals(binarySearch.searchNewRecursion(ints, 1),0);
        Assertions.assertEquals(binarySearch.searchNewRecursion(ints, 6),5);
        Assertions.assertEquals(binarySearch.searchNewRecursion(ints, 7),-1);
        Assertions.assertEquals(binarySearch.searchNewRecursion(ints, 0),-1);
    }

}
