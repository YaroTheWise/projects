import com.company.sortingandsearching.Search2DMatrixII;
import com.company.sortingandsearching.Search2DMatrixII2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Search2DMatrixIITest {


    @Test
    public void first() {
        int[][] matrix = new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30},
               new int[]{118,121,123,126,130},
        };

        Search2DMatrixII2 search2DMatrixII = new Search2DMatrixII2();

        assertTrue(search2DMatrixII.searchMatrix(matrix, 5));
        assertTrue(search2DMatrixII.searchMatrix(matrix, 3));
        assertFalse(search2DMatrixII.searchMatrix(matrix, 0));
        assertFalse(search2DMatrixII.searchMatrix(matrix, 50));
        assertTrue(search2DMatrixII.searchMatrix(matrix, 11));
        assertTrue(search2DMatrixII.searchMatrix(matrix, 18));
        assertTrue(search2DMatrixII.searchMatrix(matrix, 130));
        assertTrue(search2DMatrixII.searchMatrix(matrix, 121));
        assertTrue(search2DMatrixII.searchMatrix(matrix, 30));
        assertFalse(search2DMatrixII.searchMatrix(matrix, 1130));
        assertTrue(search2DMatrixII.searchMatrix(matrix, 19));
        assertTrue(search2DMatrixII.searchMatrix(matrix, 15));
    }
}
