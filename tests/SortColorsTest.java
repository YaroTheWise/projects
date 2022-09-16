import java.util.Arrays;

import com.company.sortingandsearching.SortColors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortColorsTest {

    @Test
    public void first() {
        int[] ints = new int[]{2, 0, 2, 1, 1, 0};
        int[] result = new int[]{0, 0, 1, 1, 2, 2};

        SortColors.sortColors(ints);

        Assertions.assertArrayEquals(ints, result);
    }

    @Test
    public void second() {
        int[] ints = new int[]{0, 0, 0, 2, 1, 1, 2, 0, 2, 2, 0, 2, 1, 1, 0, 2, 2, 2, 2};
        int[] result = Arrays.stream(ints).sorted().toArray();

        SortColors.sortColors(ints);

        Assertions.assertArrayEquals(ints, result);
    }

    @Test
    public void third() {
        int[] ints = new int[]{2, 0, 1};
        int[] result = Arrays.stream(ints).sorted().toArray();

        SortColors.sortColors(ints);

        Assertions.assertArrayEquals(ints, result);
    }
}
