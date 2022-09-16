import java.util.Map;

import com.company.IntToRoman;
import com.company.maxCount1InString.Anagrams;
import com.company.maxCount1InString.Atoi;
import com.company.maxCount1InString.Counter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterTests {

    @Test
    public void Test() {
        Assertions.assertEquals(0, Counter.start("", 0));
        Assertions.assertEquals(0, Counter.start("", 1));
        Assertions.assertEquals(3, Counter.start("101", 1));
        Assertions.assertEquals(3, Counter.start("010", 2));
        Assertions.assertEquals(5, Counter.start("10001", 3));
        Assertions.assertEquals(7, Counter.start("0100010", 5));
        Assertions.assertEquals(2, Counter.start("00", 5));
        Assertions.assertEquals(2, Counter.start("0000", 2));
        Assertions.assertEquals(4, Counter.start("1111", 2));
        Assertions.assertEquals(4, Counter.start("0111", 2));
        Assertions.assertEquals(5, Counter.start("0000111", 2));
    }

    @Test
    public void Test2() {
        Assertions.assertEquals(0, Atoi.get(""));
        Assertions.assertEquals(0, Atoi.get("00000"));
        Assertions.assertEquals(0, Atoi.get("-00000"));
        Assertions.assertEquals(0, Atoi.get("-00df000"));
        Assertions.assertEquals(3, Atoi.get("  +3 saf "));
        Assertions.assertEquals(3, Atoi.get("3 "));
        Assertions.assertEquals(5, Atoi.get("                      5"));
        Assertions.assertEquals(Integer.MAX_VALUE, Atoi.get("333333333333333333333333333333333333"));
        Assertions.assertEquals(Integer.MIN_VALUE, Atoi.get("   -333333333333333333333333333333333"));
        Assertions.assertEquals(0, Atoi.get("++2"));
        Assertions.assertEquals(0, Atoi.get("--2"));
        Assertions.assertEquals(0, Atoi.get("+ 2"));
        Assertions.assertEquals(0, Atoi.get("- 2"));
        Assertions.assertEquals(3, Atoi.get("3.14"));
    }


    @Test
    public void Test3() {
        Assertions.assertEquals("III", IntToRoman.intToRoman(3));
        Assertions.assertEquals("IV", IntToRoman.intToRoman(4));
        Assertions.assertEquals("IX", IntToRoman.intToRoman(9));
        Assertions.assertEquals("VIII", IntToRoman.intToRoman(8));
        Assertions.assertEquals("XVIII", IntToRoman.intToRoman(18));
        Assertions.assertEquals("XLVIII", IntToRoman.intToRoman(48));
        Assertions.assertEquals("XLVIII", IntToRoman.intToRoman(48));
    }

    @Test
    public void Test4() {
//        var t = Anagrams.getKey("bbaacc");


        Assertions.assertEquals(Map.of(), Anagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"
        }));
    }
}
