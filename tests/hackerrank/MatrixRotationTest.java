package hackerrank;

import java.util.ArrayList;
import java.util.List;

import com.hackerrank.oneweek.MatrixRotation;
import org.junit.jupiter.api.Test;

public class MatrixRotationTest {
    @Test
    public void first() {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> objects1 = new ArrayList<>();
        objects1.add(1);
        objects1.add(2);
        objects1.add(3);
        objects1.add(4);
        objects1.add(5);
        matrix.add(objects1);
        List<Integer> objects2 = new ArrayList<>();
        objects2.add(14);
        objects2.add(15);
        objects2.add(16);
        objects2.add(17);
        objects2.add(6);
        matrix.add(objects2);
        List<Integer> objects3 = new ArrayList<>();
        objects3.add(13);
        objects3.add(20);
        objects3.add(19);
        objects3.add(18);
        objects3.add(7);
        matrix.add(objects3);
        List<Integer> objects4 = new ArrayList<>();
        objects4.add(12);
        objects4.add(11);
        objects4.add(10);
        objects4.add(9);
        objects4.add(8);
        matrix.add(objects4);

        MatrixRotation.matrixRotation(matrix, 1);
    }

    @Test
    public void second() {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> objects1 = new ArrayList<>();
        objects1.add(1);
        objects1.add(2);
        objects1.add(3);
        objects1.add(4);
        matrix.add(objects1);
        List<Integer> objects2 = new ArrayList<>();
        objects2.add(5);
        objects2.add(6);
        objects2.add(7);
        objects2.add(8);
        matrix.add(objects2);
        List<Integer> objects3 = new ArrayList<>();
        objects3.add(9);
        objects3.add(10);
        objects3.add(11);
        objects3.add(12);
        matrix.add(objects3);
        List<Integer> objects4 = new ArrayList<>();
        objects4.add(13);
        objects4.add(14);
        objects4.add(15);
        objects4.add(16);
        matrix.add(objects4);

        MatrixRotation.matrixRotation(matrix, 1);
    }

    @Test
    public void third() {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> objects1 = new ArrayList<>();
        objects1.add(1);
        objects1.add(1);
        matrix.add(objects1);
        List<Integer> objects2 = new ArrayList<>();
        objects2.add(1);
        objects2.add(1);
        matrix.add(objects2);
        MatrixRotation.matrixRotation(matrix, 1);
    }
}
