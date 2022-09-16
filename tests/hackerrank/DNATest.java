package hackerrank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.hackerrank.oneweek.Model;
import com.hackerrank.oneweek.Node;
import org.junit.jupiter.api.Test;

import static com.hackerrank.oneweek.DnaHealth.run;
import static com.hackerrank.oneweek.GenerateTree.generateTree;
import static java.util.stream.Collectors.toList;

public class DNATest {

    @Test
    public void first() {


        List<Integer> health = List.of(1, 2, 3, 4, 5, 6);
        List<String> genes = List.of("a", "b", "c", "aa", "d", "b");
        Node node = generateTree(genes, health);

        List<Model> models = new ArrayList<>();


        Model model1 = new Model(1, 5, "caaab");
        Model model2 = new Model(0, 4, "xyz");
        Model model3 = new Model(2, 4, "bcdybc");
        models.add(model1);
        models.add(model2);
        models.add(model3);
        run(node, models);
    }

    @Test
    public void second() throws IOException {
        Calendar time1 =  Calendar.getInstance();



        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/sheinyaroslav/Downloads/Test5.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        List<Model> models = new ArrayList<>();
        //models.add(new Model(2, 1, "sda"));

        IntStream.range(0, s).forEach(sItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);

                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];

                models.add(new Model(first, last, d));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        Calendar time3 =  Calendar.getInstance();
        Node node = generateTree(genes, health);
        Calendar time4 =  Calendar.getInstance();

        run(node, models);

        bufferedReader.close();

        Calendar time2 =  Calendar.getInstance();

        long diff = time2.getTimeInMillis() - time1.getTimeInMillis();
        long diff2 = time4.getTimeInMillis() - time3.getTimeInMillis();
        System.out.println();
        System.out.println(diff2);
        System.out.println(diff);
    }

}
