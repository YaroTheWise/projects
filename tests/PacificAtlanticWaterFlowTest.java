import java.util.List;

import com.company.fest.PacificAtlanticWaterFlow;
import org.junit.jupiter.api.Test;

public class PacificAtlanticWaterFlowTest {

    @Test
    public void first() {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        int[][] ints = new int[][]{
                new int[]{1, 2, 2, 3, 5},
                new int[]{3, 2, 3, 4, 4},
                new int[]{2, 4, 5, 3, 1},
                new int[]{6, 7, 1, 4, 5},
                new int[]{5, 1, 1, 2, 4}
        };

        List<List<Integer>> lists = pacificAtlanticWaterFlow.pacificAtlantic(ints);
    }
}
