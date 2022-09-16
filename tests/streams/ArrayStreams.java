package streams;

import java.sql.Time;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayStreams {

    @Test
    public void first() {


        int[] arr = new int[]{2, 43, 34, 43, 32, 1, 4, 3, 4};

        IntStream stream = Arrays.stream(arr);

        Collector<? super Stream<Integer>, ?, ?> collector;
//        stream.collect(collector);

//        Stream.<Integer>builder().build()
//        Assertions.assertEquals(60, concat.count());
//        Assertions.assertEquals(100, collect.size());
//        Time.valueOf("12:01:00AM");
    }

    @Test
    public void second() {
        Assertions.assertEquals("00:01:00",timeConversion("12:01:00AM"));
        Assertions.assertEquals("12:01:00",timeConversion("12:01:00PM"));
    }

    public static String timeConversion(String s) {
        // Write your code here
        String[] split = s.split(":");
        Integer integer = Integer.valueOf(split[0]);
        if (split[2].charAt(2) == 'A') {
            if (integer == 12) {
                integer = 0;
            }
        } else {
            if (integer != 12) {
                integer += 12;
            }
        }

        return String.format("%02d:%s:%s", integer, split[1], split[2].substring(0, 2));
    }

}
