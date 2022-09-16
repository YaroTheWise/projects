package hackerrank;

import java.util.List;

import com.hackerrank.oneweek.ComparisonSorting;
import org.junit.jupiter.api.Test;

public class ComparisonSortingTest {
    @Test
    public void first() {
        ComparisonSorting comparisonSorting = new ComparisonSorting();

        List<Integer> ints = List.of(1, 1, 3, 2, 1);
        List<Integer> integers = comparisonSorting.countingSort(ints);


    }
}
