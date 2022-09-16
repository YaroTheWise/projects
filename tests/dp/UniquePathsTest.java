package dp;

import com.company.dp.UniquePaths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniquePathsTest {

    @Test
    public void first(){
        UniquePaths uniquePaths = new UniquePaths();

        Assertions.assertEquals(28, uniquePaths.uniquePaths(3,7));
    }
}
