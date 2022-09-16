import com.company.NumberOfWeakCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfWeakCharactersTest {

    @Test
    public void first() {

        int[][] ints = new int[][]{new int[]{7,9}, new int[]{10,7}, new int[]{6,9}
                , new int[]{10,4}, new int[]{7,5}, new int[]{7,10}};

//        [[7,9],[10,7],[6,9],[10,4],[7,5],[7,10]]
//        [[1,1],[2,1],[2,2],[1,2]]
        int[][] ints2 = new int[][]{new int[]{1,1}, new int[]{2,1}, new int[]{2,2}
                , new int[]{1,2}};
        NumberOfWeakCharacters numberOfWeakCharacters = new NumberOfWeakCharacters();
        Assertions.assertEquals(2, numberOfWeakCharacters.numberOfWeakCharacters(ints));
        Assertions.assertEquals(1, numberOfWeakCharacters.numberOfWeakCharacters(ints2));
    }
}
