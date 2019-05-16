import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.function.*;
import java.util.Random;
import java.util.Optional;
import java.util.Comparator;

public class vcx {
    public static Random rand = new Random(47);

    public static void showElement(int sumOfList) {

        int missElement = IntStream.range(0, 100)
                .sum() - sumOfList;
        System.out.println(missElement);

    }

    public static void main(String args[]) {

        List<Integer> list = Stream.iterate(0, n -> rand.nextInt(100))
                .distinct().limit(100)
                .collect(Collectors.toList());

        int deleteIndex = rand.nextInt(100);
        list.remove(deleteIndex);
        int sumOfList = list.stream()
                .mapToInt(a -> a)
                .sum();

        long timeBefore = System.currentTimeMillis();
        showElement(sumOfList);
        long timeAfter = System.currentTimeMillis();
        long elapsed = timeAfter - timeBefore;

        System.out.println(elapsed);


        long fastest = Long.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            timeBefore = System.currentTimeMillis();
            showElement(sumOfList);
            timeAfter = System.currentTimeMillis();
            elapsed = timeAfter - timeBefore;
            if (elapsed < fastest) {
                fastest = elapsed;

            }
        }
        System.out.println(fastest);
        //verificare la prima rulare
        System.out.println(list.contains(56));


    }
}
