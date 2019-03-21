package xyz.trendfashion.practice.eight;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaDemo {

    private static List<String> stringList = Arrays.asList("Kobe", "Michael", "Michelle", "Huntington", "Peter", "Johnson", "Clinton");
    private static List<Integer> integerList = Arrays.asList(-10, 11, 432, 1, 129129, -772, 1, -10);

    public static void main(String[] args) {
        sortOriginal();
        sortLambda();
        toLowerCaseLamda();
        addSuffix();
        findMax();
        filterNegative();
        distinct();
        flatMap();
        sum();
    }

    private static void sortOriginal() {
        Collections.sort(integerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(integerList);
    }

    private static void sortLambda() {
//        Collections.sort(stringList, (str1, str2) -> str1.compareTo(str2));
        Collections.sort(stringList, Comparator.comparing(s -> s));
        System.out.println(stringList);
    }

    private static void toLowerCaseLamda() {
        List<String> lowerStringList = stringList.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowerStringList);
    }

    private static void addSuffix() {
        List<String> suffixedStringList = stringList.stream().map(s -> s += "suffix").collect(Collectors.toList());
        System.out.println(suffixedStringList);
    }

    private static void findMax() {
        Integer max = integerList.stream().reduce(Integer::max).get();
        System.out.println(max);
    }

    private static void filterNegative() {
        List<Integer> negativeList = integerList.stream().filter(i -> i < 0).collect(Collectors.toList());
        System.out.println(negativeList);
    }

    private static void distinct() {
        List<Integer> distinctList = integerList.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList);
    }

    // others such as: peek, limit, skip.
    private static void flatMap() {
        Stream<List<Integer>> stream1 = Stream.of(
                Arrays.asList(1, 9),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> stream2 = stream1.flatMap((childList) -> childList.stream());
        stream2.forEach(o -> {
            System.out.print(o);
            System.out.print(" ");
        });
        System.out.println();
    }

    // others such as: allMatch, anyMatch, findFirst, noneMatch, max, min.
    private static void sum() {
        List<Integer> integerList1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integerList1.add(i + 1);
        }
        Integer sum = integerList1.stream().reduce(-50, (tmpSum, item) -> tmpSum + item);
        System.out.println(sum);
    }
}
