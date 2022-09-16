package backtracking;

import java.util.List;

import com.company.backtracking.LetterCombinationsPhoneNum;
import org.junit.jupiter.api.Test;

public class LetterCombinationsPhoneNumTest {

    @Test
    public void first(){
        LetterCombinationsPhoneNum letterCombinationsPhoneNum = new LetterCombinationsPhoneNum();
        String str ="234";
        List<String> strings = letterCombinationsPhoneNum.letterCombinations(str);
    }
}
