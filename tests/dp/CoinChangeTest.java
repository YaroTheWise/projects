package dp;

import com.company.dp.CoinChange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinChangeTest {

    @Test
    public void first() {
        CoinChange coinChange = new CoinChange();
       Assertions.assertEquals(20, coinChange.coinChange(new int[] {186,419,83,408}, 6249));
    }
}
